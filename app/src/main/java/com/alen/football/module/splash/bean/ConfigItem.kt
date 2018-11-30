package com.alen.football.module.splash.bean
import com.google.gson.annotations.SerializedName


/**
 * Created By Alen
 * 2018/11/23
 */
data class ConfigItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("key")
    var key: String,
    @SerializedName("remark")
    var remark: String,
    @SerializedName("status")
    var status: Int,
    @SerializedName("value")
    var value: String


)