package com.alen.football.application

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.alen.common.CommonContext
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Kotlin 学习：
 * 1. 使用 multiDex打包
 * 2. https://github.com/JessYanCoding/AndroidAutoSize 进行屏幕适配
 * 3. 使用ConstraintLayout 进行布局
 * 4. 使用 Kotlin 扩展进行控件绑定
 * 5. 使用retrofit Rxjava Dagger2 构建MVVM框架
 * 6. 添加leak检查 检测内存泄漏
 * 7. 使用Glide 加载图片
 */
class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().application(this).build()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        CommonContext.appContext = this

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this)
    }
}