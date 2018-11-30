package com.alen.football.module.splash.bean

import com.alen.common.net.BaseResultBean
import com.google.gson.annotations.SerializedName

/**
 * Created By Alen
 * 2018/11/23
 */
class ConfigResultBean : BaseResultBean(){
    @SerializedName("result")
    var result: List<ConfigItem>? = null

}