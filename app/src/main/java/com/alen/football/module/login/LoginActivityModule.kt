package com.alen.football.module.login

import com.alen.football.annotation.PerActivity
import com.alen.football.module.login.api.LoginApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created By Alen
 * 2018/11/26
 */
@Module
class LoginActivityModule {

    @Provides
    @PerActivity
    internal fun provideLoginRepository(loginAPi: LoginApi): LoginActivityRepository {
        return LoginActivityRepository(loginAPi)
    }

    @Provides
    fun provideConfigApi(retrofit: Retrofit) : LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Provides
    @PerActivity
    internal fun provideLoginVieweModel(r: LoginActivityRepository): LoginActivityViewModule {
        return LoginActivityViewModule(r)
    }
}