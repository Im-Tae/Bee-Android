package com.gsm.bee_assistant_android.ui.login.classroom

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ClassroomLoginPresenter @Inject constructor(override val view: ClassroomLoginContract.View) : ClassroomLoginContract.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun disposeDisposable() = compositeDisposable.dispose()
}