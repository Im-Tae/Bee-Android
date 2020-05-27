package com.gsm.bee_assistant_android.ui.presenter

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.gsm.bee_assistant_android.di.app.MyApplication
import com.gsm.bee_assistant_android.ui.contract.SetSchoolContract
import com.gsm.bee_assistant_android.utils.PreferenceManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SetSchoolPresenter @Inject constructor(override val view: SetSchoolContract.View) : SetSchoolContract.Presenter {

    @Inject
    lateinit var pref : PreferenceManager

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getUserInfo() {

        val user = FirebaseAuth.getInstance().currentUser

        user.let {

            val name = it?.displayName
            val email = it?.email
            val photoUrl = it?.photoUrl

            pref.setData(MyApplication.Key.EMAIL.toString(), email.toString())

            Log.d("test", email.toString())
        }
    }

    override fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun disposeDisposable() = compositeDisposable.dispose()
}