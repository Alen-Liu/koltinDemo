package com.alen.football.module.login.bean

import com.alen.common.net.BaseResultBean
import com.alen.football.module.splash.bean.ConfigItem
import com.google.gson.annotations.SerializedName

/**
 * Created By Alen
 * 2018/11/26
 */
class LoginResultBean : BaseResultBean(){
    @SerializedName("result")
    var result: String? = null

}