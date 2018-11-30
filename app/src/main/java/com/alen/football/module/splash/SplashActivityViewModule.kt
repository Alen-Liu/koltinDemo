package com.alen.football.module.splash

import android.arch.lifecycle.LiveData
import com.alen.football.base.BaseViewModel
import com.alen.football.module.splash.bean.ConfigItem
import javax.inject.Inject

/**
 * Created By Alen
 * 2018/11/21
 */
class SplashActivityViewModule @Inject constructor(val repository : SplashActivityRepository) : BaseViewModel(){
    init {
        _repository = repository;
    }

    fun getConfig() : LiveData<ConfigItem> {
        return repository.getConfig()
    }


}