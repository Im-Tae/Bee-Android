package com.gsm.bee_assistant_android.di.module.fragment

import com.gsm.bee_assistant_android.ui.SetSchoolDialogFragment
import com.gsm.bee_assistant_android.ui.contract.SetSchoolDialogContract
import com.gsm.bee_assistant_android.ui.presenter.SetSchoolDialogPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SetSchoolDialogModule {

    @Binds
    abstract fun provideSetSchoolDialogPresenter(presenter : SetSchoolDialogPresenter): SetSchoolDialogContract.Presenter

    @Binds
    abstract fun provideSetSchoolDialogView(view : SetSchoolDialogFragment): SetSchoolDialogContract.View
}