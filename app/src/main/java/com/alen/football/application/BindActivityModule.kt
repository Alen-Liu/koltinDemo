package com.alen.football.application

import com.alen.football.annotation.App
import com.alen.football.annotation.PerActivity
import com.alen.football.module.login.LoginActivity
import com.alen.football.module.login.LoginActivityModule
import com.alen.football.module.main.MainActivity
import com.alen.football.module.main.MainActivityModule
import com.alen.football.module.splash.SplashActivity
import com.alen.football.module.splash.SplashActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created By Alen
 * 2018/11/21
 */
@Module
abstract class BindActivityModule{
    @Binds
    @App
    internal abstract fun application(app: MyApplication): android.app.Application


    @PerActivity
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun splashActivityInjector(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun loginActivityInjector(): LoginActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivityInjector(): MainActivity

}