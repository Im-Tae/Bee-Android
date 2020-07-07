package com.gsm.bee_assistant_android.di.module.login

import com.gsm.bee_assistant_android.ui.login.classroom.*
import dagger.Binds
import dagger.Module

@Module
abstract class ClassroomLoginActivityModule {

    @Binds
    abstract fun provideClassroomLoginPresenter(presenter : ClassroomLoginPresenter) : ClassroomLoginContract.Presenter

    @Binds
    abstract fun provideClassroomLoginView(view : ClassroomLoginActivity) : ClassroomLoginContract.View
}