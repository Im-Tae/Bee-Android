package com.gsm.bee_assistant_android.di.app

import com.gsm.bee_assistant_android.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    enum class Key {
        EMAIL,
        SCHOOL_NAME,
        CLASSROOM_TOKEN
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().application(this).build()
}