package com.alen.common.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created By Alen
 * 2018/11/21
 */

object RetroInstance{
    var retrofit: Retrofit? = null;

    fun getInstance() : Retrofit{
        if(retrofit == null){
            val gsonConverterFactory = MoshiConverterFactory.create()
            val okHttpClient = OkHttpClient()
            val builder = okHttpClient.newBuilder()
            builder.addInterceptor(RequestInterceptor())
            builder.retryOnConnectionFailure(true)
            retrofit = Retrofit.Builder().client(okHttpClient)
                    .baseUrl(NetConstants.BASE_NET_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
                    .build()
        }
        return retrofit!!
    }
}