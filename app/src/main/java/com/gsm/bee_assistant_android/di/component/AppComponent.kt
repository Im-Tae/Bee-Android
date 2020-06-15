package com.gsm.bee_assistant_android.di.component

import com.gsm.bee_assistant_android.di.app.MyApplication
import com.gsm.bee_assistant_android.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        DataModule::class,
        NetworkModule::class
    ]
)

interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication) : Builder
        fun build() : AppComponent
    }
}