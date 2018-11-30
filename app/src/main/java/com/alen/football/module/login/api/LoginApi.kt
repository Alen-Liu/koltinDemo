package com.alen.football.module.login.api

import com.alen.football.module.login.bean.LoginResultBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created By Alen
 * 2018/11/26
 */

interface LoginApi {
    @POST("/user/login")
    @FormUrlEncoded
    fun login(@Field("userName")userNamen : String , @Field("password")password : String): Observable<LoginResultBean>
}