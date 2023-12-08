package com.pn.news.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.pn.SuperUi.date.SuperDateUtil
import com.pn.SuperUi.util.SuperDarkUtil
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
        //如果系统为深色模式
        if (SuperDarkUtil.isDark(this)){
            //状态栏文字为黑色
            QMUIStatusBarHelper.setStatusBarLightMode(this)
        }else{
            //状态栏文字为白色
            QMUIStatusBarHelper.setStatusBarDarkMode(this)
        }
        //设置版本年份
       /* var copyright = findViewById<TextView>(R.id.copyright)
        val currentYear =SuperDateUtil.currentYear()
        copyright.setText("Copyright @${currentYear}")*/
    }
}