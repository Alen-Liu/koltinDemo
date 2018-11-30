package com.alen.common.widget

import android.widget.Toast
import com.alen.common.CommonContext

/**
 * Created By Alen
 * 2018/11/26
 */
object CommonToast {
    private var mToast: Toast? = null

    fun showShort(str: String) {
        if (mToast == null) {
            mToast = Toast.makeText(CommonContext.appContext, "", Toast.LENGTH_SHORT)
        }
        mToast!!.setText(str)
        mToast!!.duration = Toast.LENGTH_SHORT
        mToast!!.show()
    }

    fun showShort(resId: Int) {
        if (mToast == null) {
            mToast = Toast.makeText(CommonContext.appContext, "", Toast.LENGTH_SHORT)
        }
        mToast!!.setText(CommonContext.appContext!!.resources.getString(resId))
        mToast!!.duration = Toast.LENGTH_SHORT
        mToast!!.show()
    }

    fun showLong(str: String) {
        if (mToast == null) {
            mToast = Toast.makeText(CommonContext.appContext, "", Toast.LENGTH_SHORT)
        }
        mToast!!.setText(str)
        mToast!!.duration = Toast.LENGTH_LONG
        mToast!!.show()
    }

    fun showLong(resId: Int) {
        if (mToast == null) {
            mToast = Toast.makeText(CommonContext.appContext, "", Toast.LENGTH_SHORT)
        }
        mToast!!.setText(CommonContext.appContext!!.resources.getString(resId))
        mToast!!.duration = Toast.LENGTH_LONG
        mToast!!.show()
    }
}
