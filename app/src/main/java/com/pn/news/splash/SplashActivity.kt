package com.pn.news.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pn.news.R
import com.qmuiteam.qmui.util.QMUIStatusBarHelper

/**
 * 启动界面
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)
        //状态栏文字为黑色
        QMUIStatusBarHelper.setStatusBarLightMode(this)
    }
}