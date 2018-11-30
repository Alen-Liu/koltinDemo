package com.alen.football.module.login

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import com.alen.common.widget.CommonToast
import com.alen.football.R
import com.alen.football.base.BaseActivity
import com.alen.football.module.main.MainActivity
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created By Alen
 * 2018/11/26
 */
class LoginActivity : BaseActivity() {
    @Inject
    lateinit var viewModule : LoginActivityViewModule

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.bt_login)
    fun onClick(view : View) {
        when(view.id) {
            R.id.bt_login ->{
                var userName = edt_login_name.text.toString()
                var password = edt_login_password.text.toString()
                if(TextUtils.isEmpty(userName)){
                    CommonToast.showShort(R.string.str_login_name_not_null)
                    return
                }
                if(TextUtils.isEmpty(password)){
                    CommonToast.showShort(R.string.str_login_pass_not_null)
                    return
                }
                viewModule.login(userName, password).observe(this, Observer { success -> kotlin.run {
                    if(success != null && success){
                        MainActivity.launch(this)
                        finish()
                    }
                } })
            }
        }
    }
}