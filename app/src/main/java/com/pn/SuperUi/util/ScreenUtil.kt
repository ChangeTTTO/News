package com.pn.SuperUi.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * 屏幕工具类
 */
object ScreenUtil {
    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    fun getScreenWith(context: Context): Int {
        //获取window管理器
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        //创建显示对象
        val outDisplayMetrics = DisplayMetrics()

        //获取默认显示对象
        wm.defaultDisplay.getMetrics(outDisplayMetrics)

        //返回屏幕宽度
        return outDisplayMetrics.widthPixels
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    fun getScreenHeight(context: Context): Int {
        //获取window管理器
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        //创建显示对象
        val outDisplayMetrics = DisplayMetrics()

        //获取默认显示对象
        wm.defaultDisplay.getMetrics(outDisplayMetrics)

        //返回屏幕宽度
        return outDisplayMetrics.heightPixels
    }
}