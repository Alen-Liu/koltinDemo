package com.alen.football.module.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import android.util.Log
import com.alen.common.net.BaseResultBean
import com.alen.common.net.TokenManager
import com.alen.common.widget.CommonToast
import com.alen.football.base.BaseRepository
import com.alen.football.module.login.api.LoginApi
import com.alen.football.module.splash.api.ConfigApi
import com.alen.football.module.splash.bean.ConfigItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created By Alen
 * 2018/11/26
 */
class LoginActivityRepository(loginApi: LoginApi)  : BaseRepository() {
    var loginApi : LoginApi = loginApi

    var loginResult : MutableLiveData<Boolean> = MutableLiveData()


    override fun release() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun login(userName: String, password: String): LiveData<Boolean> {

        loginApi.login(userName, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data ->
                    if(data.status == BaseResultBean.Result.RESULT_SUCCESS) {
                        TokenManager.token = data.result
                        loginResult.value = true
                    } else {
                        loginResult.value = false
                        if(data.msg != null){CommonToast.showShort(data.msg!!)}
                    }
                }, {
                    error -> loginResult.value = false
                    if(error.message != null){CommonToast.showShort(error.message!!)}
                })

        return loginResult
    }

}