package com.gsm.bee_assistant_android.ui.login.google

import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.gsm.bee_assistant_android.di.app.MyApplication
import com.gsm.bee_assistant_android.retrofit.domain.user.UserToken
import com.gsm.bee_assistant_android.retrofit.network.UserApi
import com.gsm.bee_assistant_android.ui.login.classroom.ClassroomLoginActivity
import com.gsm.bee_assistant_android.utils.PreferenceManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GoogleLoginPresenter @Inject constructor(override val view: GoogleLoginContract.View) : GoogleLoginContract.Presenter {

    @Inject
    lateinit var pref: PreferenceManager

    @Inject
    lateinit var userRetrofit: UserApi

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun googleLogin(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 100) {

            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)

            if (result!!.isSuccess) {

                val account = result.signInAccount
                val credential = GoogleAuthProvider.getCredential(account?.idToken, null)

                addDisposable(
                    Observable.just(
                        FirebaseAuth
                            .getInstance()
                            .signInWithCredential(credential)
                    ).subscribe {
                        getToken(account?.email.toString())
                    }
                )
            }
        }
    }

    private fun getToken(email: String) {

        view.showProgress()

        addDisposable(
            userRetrofit.getUserToken(email)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : DisposableObserver<UserToken>(){

                    override fun onNext(userToken: UserToken) {
                        Log.i("userToken", userToken.token)
                        pref.setData(MyApplication.Key.USER_TOKEN.toString(), userToken.token)
                    }

                    override fun onComplete() {
                        view.hideProgress()

                        view.startActivity(ClassroomLoginActivity::class.java).apply {
                            pref.setData(MyApplication.Key.EMAIL.toString(), email)
                            view.finishActivity()
                        }
                    }

                    override fun onError(e: Throwable) {}
                })
        )
    }

    override fun googleSignIn(signInIntent: Intent) = view.showLogin(signInIntent)

    override fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun disposeDisposable() = compositeDisposable.dispose()
}