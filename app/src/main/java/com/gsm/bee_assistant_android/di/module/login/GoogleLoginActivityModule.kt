package com.gsm.bee_assistant_android.di.module.login

import com.gsm.bee_assistant_android.ui.login.google.*
import dagger.Binds
import dagger.Module

@Module
abstract class GoogleLoginActivityModule {

    @Binds
    abstract fun provideGoogleLoginPresenter(presenter : GoogleLoginPresenter) : GoogleLoginContract.Presenter

    @Binds
    abstract fun provideGoogleLoginView(view : GoogleLoginActivity) : GoogleLoginContract.View
}