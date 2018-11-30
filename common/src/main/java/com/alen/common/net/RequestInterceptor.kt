package com.alen.common.net

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created By Alen
 * 2018/11/21
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var oldRequest = chain.request()
        var authorizedUrlBuilder = oldRequest.url().newBuilder().scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())

        var newRequest = oldRequest.newBuilder().method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
        if(TokenManager.token != null){
            newRequest.header("token", TokenManager.token)
        }
        return chain.proceed(newRequest.build())
    }

}