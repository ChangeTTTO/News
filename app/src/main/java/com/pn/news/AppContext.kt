package com.pn.news

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV


/**
 * 全局Application
 * 打开应用就一直在，杀死应用才结束
 */
class AppContext :Application() {


    override fun onCreate() {
        super.onCreate()
        initMMKV()
    }

    /**
     * mmkv root: /data/data/com.pn.news/files/mmkv
     * 用来代替系统的sharedPreferences
     */
    private fun initMMKV(){
        val rootDir = MMKV.initialize(this)
        Log.d("tag", "initMMKV:$rootDir")
    }
}