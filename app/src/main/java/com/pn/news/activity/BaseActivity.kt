package com.pn.news.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 所有Activity的父类
 * open:类能被继承方法能被重写
 */
open class BaseActivity :AppCompatActivity() {
    /**
     * 找控件
     */
    protected open fun initViews(){

    }

    /**
     * 设置数据
     */
    protected open fun initDatum(){

    }
    /**
     * 设置监听器
     */
    protected open fun initListeners(){

    }

    /**
     * 在OnCreate方法后调用
     */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews()
        initDatum()
        initListeners()
    }
}