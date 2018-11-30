package com.alen.football.application

import com.alen.common.net.RetroInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [BindActivityModule::class, BindServiceModule::class])
class AppModule {
    @Provides
    fun provideRestroAdapter(): Retrofit {
        return RetroInstance.getInstance()
    }
}