package com.alen.football.module.main

import com.alen.football.annotation.PerActivity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created By Alen
 * 2018/11/27
 */
@Module
class MainActivityModule {
    @Provides
    @PerActivity
    internal fun provideMainRepository(): MainActivityRepository {
        return MainActivityRepository()
    }


    @Provides
    @PerActivity
    internal fun provideMainVieweModel(r: MainActivityRepository): MainActivityViewModule {
        return MainActivityViewModule(r)
    }
}