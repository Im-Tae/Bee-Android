package com.gsm.bee_assistant_android.di.module

import android.content.Context
import com.gsm.bee_assistant_android.utils.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun pref(context: Context) : PreferenceManager = PreferenceManager(context)
}