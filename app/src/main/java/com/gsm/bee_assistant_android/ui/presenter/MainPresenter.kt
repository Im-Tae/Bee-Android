package com.gsm.bee_assistant_android.ui.presenter

import com.gsm.bee_assistant_android.ui.contract.MainContract
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainPresenter @Inject constructor(override val view: MainContract.View) : MainContract.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var lastTimeBackPressed: Long = 0

    override fun backPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 2500)
            view.finishAffinityActivity()
        else {
            view.showToast("'뒤로' 버튼을 한번 더 누르면 종료합니다.")
            lastTimeBackPressed = System.currentTimeMillis()
        }
    }

    override fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun disposeDisposable() = compositeDisposable.dispose()
}