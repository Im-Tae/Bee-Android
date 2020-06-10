package com.gsm.bee_assistant_android.di.app

import com.gsm.bee_assistant_android.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    enum class Key {
        EMAIL,
        SCHOOL_NAME
    }

    companion object {
        const val Api_Key = "3817fd5251488daeddd413b2502fb3cd"
        const val School_Info_Url = "http://www.career.go.kr/cnet/openapi/"
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().application(this).build()
}