package com.pn.SuperUi.util

import android.os.Process

/**
 * 进程工具类
 */
object SuperProcessUtil {
    /**
     * 杀死当前应用
     * @param :本机的id   在未root情况下，只能杀死当前应用
     */
    fun killApp() {
        Process.killProcess(Process.myPid())
    }
}