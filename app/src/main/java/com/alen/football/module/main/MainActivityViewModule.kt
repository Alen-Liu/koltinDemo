package com.alen.football.module.main

import com.alen.football.base.BaseViewModel
import javax.inject.Inject

/**
 * Created By Alen
 * 2018/11/27
 */
class MainActivityViewModule @Inject constructor(val repository : MainActivityRepository) : BaseViewModel() {

    init {
        _repository = repository;
    }
}