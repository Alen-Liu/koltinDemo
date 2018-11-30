package com.alen.common.net

import com.google.gson.annotations.SerializedName

/**
 * Created By Alen
 * 2018/11/23
 */
open class BaseResultBean {
    object Result {
        const val RESULT_SUCCESS = 200
    }
    @SerializedName("msg")
    var msg: String? = null
    @SerializedName("status")
    var status: Int = 0
}