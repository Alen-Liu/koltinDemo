package com.alen.football.module.login

import android.arch.lifecycle.LiveData
import com.alen.football.base.BaseViewModel
import javax.inject.Inject

/**
 * Created By Alen
 * 2018/11/26
 */
class LoginActivityViewModule  @Inject constructor(val repository : LoginActivityRepository) : BaseViewModel() {

    init {
        _repository = repository;
    }


    fun login(userName: String, password: String) : LiveData<Boolean> {
        return repository.login(userName, password)
    }

}
