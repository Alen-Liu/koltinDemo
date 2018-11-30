package com.alen.football.base

import android.arch.lifecycle.ViewModel

/**
 * Created By Alen
 * 2018/11/21
 */
open class BaseViewModel : ViewModel() {
    lateinit var _repository: BaseRepository

    override fun onCleared() {
        super.onCleared()
        if(_repository != null){
            _repository.release()
        }
    }
}