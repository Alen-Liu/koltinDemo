package com.alen.football.module.splash

import com.alen.football.annotation.PerActivity
import com.alen.football.module.splash.api.ConfigApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created By Alen
 * 2018/11/21
 */
@Module
class SplashActivityModule {

    @Provides
    @PerActivity
    internal fun provideSplashRepository(configApi: ConfigApi): SplashActivityRepository {
        return SplashActivityRepository(configApi)
    }

    @Provides
    fun provideConfigApi(retrofit: Retrofit) : ConfigApi {
        return retrofit.create(ConfigApi::class.java)
    }

    @Provides
    @PerActivity
    internal fun provideSplashVieweModel(r: SplashActivityRepository): SplashActivityViewModule {
        return SplashActivityViewModule(r)
    }
}