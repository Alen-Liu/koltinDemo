package com.alen.football.module.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import com.alen.football.R
import com.alen.football.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
/**
 * Created By Alen
 * 2018/11/27
 */
class MainActivity : BaseActivity() {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }
}