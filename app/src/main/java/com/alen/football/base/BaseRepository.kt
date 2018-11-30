package com.alen.football.base

import io.reactivex.disposables.Disposable

/**
 * Created By Alen
 * 2018/11/21
 */
abstract class BaseRepository{
    abstract fun release()

    fun checkAndDispose(disposable: Array<Disposable>){
        for(dis in disposable){
            if(dis != null && !dis.isDisposed) {
                dis.dispose()
            }
        }
    }
}