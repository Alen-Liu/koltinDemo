package com.alen.football.module.splash

import android.os.Bundle
import com.alen.common.net.NetConstants
import com.alen.football.R
import com.alen.football.base.BaseActivity
import com.alen.football.module.login.LoginActivity
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(){
    @Inject lateinit var viewModule : SplashActivityViewModule

    lateinit var  disposable : Disposable;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        getConfig()

        goNext()
    }


    private fun getConfig() {
        viewModule.getConfig().observe(this, android.arch.lifecycle.Observer {
            config ->
            run {
                if(config != null) {
                    //Glide.with(this).load(NetConstants.BASE_IMAGE_URL + config!!.value).into(iv_splash)
                }
            }
        })
    }


    /**
     * 自动跳转到下一个页面的逻辑
     */
    private fun goNext() {
        // 使用Rxjava 定时任务
        disposable = Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    LoginActivity.launch(this)
                    this.finish()
                }
    }


    override fun onDestroy() {
        super.onDestroy()
        if(disposable != null){
            disposable.dispose()
        }
    }

}