package com.gsm.bee_assistant_android.ui.assistant

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AssistantPresenter @Inject constructor(
    override val view: AssistantContract.View,
    override val compositeDisposable: CompositeDisposable
) : AssistantContract.Presenter {

    override fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun disposeDisposable() = compositeDisposable.dispose()
}