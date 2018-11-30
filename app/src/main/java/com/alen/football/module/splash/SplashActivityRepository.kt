package com.alen.football.module.splash

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import com.alen.football.base.BaseRepository
import com.alen.football.module.splash.api.ConfigApi
import com.alen.football.module.splash.bean.ConfigItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created By Alen
 * 2018/11/21
 */
class SplashActivityRepository(configApi: ConfigApi) : BaseRepository(){
    var configApi : ConfigApi = configApi
    var configItem : MutableLiveData<ConfigItem> = MutableLiveData()
    override fun release() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getConfig() : MutableLiveData<ConfigItem> {
        configApi.getAppConfig().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data ->  for(config in data.result!!){
                        if(TextUtils.equals(config.key, "splash_img"))
                            configItem.value = config
                    }
                }, {
                    error -> configItem.value = null;
                })
        return configItem
    }
}