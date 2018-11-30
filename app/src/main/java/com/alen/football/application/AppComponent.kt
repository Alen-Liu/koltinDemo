package com.alen.football.application;

import com.alen.football.annotation.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created By Alen
 * 2018/11/21
 */
@App
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application:MyApplication):Builder

        fun build():AppComponent
    }
}
