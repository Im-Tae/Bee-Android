package com.gsm.bee_assistant_android.di.module.fragment

import com.gsm.bee_assistant_android.ui.assistant.AssistantContract
import com.gsm.bee_assistant_android.ui.assistant.AssistantFragment
import com.gsm.bee_assistant_android.ui.assistant.AssistantPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class AssistantModule {

    @Binds
    abstract fun provideAssistantPresenter(presenter : AssistantPresenter): AssistantContract.Presenter

    @Binds
    abstract fun provideAssistantFragment(view : AssistantFragment): AssistantContract.View
}