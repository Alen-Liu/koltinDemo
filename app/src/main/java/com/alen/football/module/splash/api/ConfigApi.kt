package com.alen.football.module.splash.api

import com.alen.football.module.splash.bean.ConfigResultBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created By Alen
 * 2018/11/23
 */
interface ConfigApi {

    @GET("/app/config")
    fun getAppConfig(): Observable<ConfigResultBean>
}