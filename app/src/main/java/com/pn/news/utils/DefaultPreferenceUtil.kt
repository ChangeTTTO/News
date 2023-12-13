package com.pn.news.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * 偏好设置工具类
 * 是否登录了，是否显示引导界面，用户Id
 */
class DefaultPreferenceUtil(context: Context) {
    private var context: Context
    private val preference: SharedPreferences

    //默认构造方法
    init {
        //保存上下文
        this.context = context.applicationContext
        //这样写有内存泄漏：this.context = context
        //因为当前工具类不会马上释放
        //如果当前工具类引用了界面实例
        //当界面关闭后
        //因为界面对应在这里还有引用
        //所以会导致界面对象不会被释放

        //获取系统默认偏好设置，在设置界面保存的值就可以这样获取
        //获取指向在给定上下文中由首选项框架使用的默认文件的 SharedPreferences 实例。默认名称
        preference = PreferenceManager.getDefaultSharedPreferences(this.context)


        //自定义名称
        // preference = this.context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }
    /**
     * companion object:设置静态方法和静态常量
     */
    companion object {
        /**
         * 偏好设置文件名称
         */
        private const val NAME = "news"
        private const val TERMS_SERVICE = "TERMS_SERVICE"
        private const val KEY_MOBILE_NETWORK_PLAY = "mobile_network_play"

        private var instance: DefaultPreferenceUtil? = null

        /**
         * 获取偏好设置单例
         * @param context
         * @return:DefaultPreferenceUtil实例
         */
        @Synchronized
        fun getInstance(context: Context): DefaultPreferenceUtil {
            if (instance == null) {
                instance = DefaultPreferenceUtil(context)
            }
            return instance!!
        }
    }

    //region 用户协议
    /**
     * 设置同意了用户协议
     * 往preference内存入
     */
    fun setAcceptTermsServiceAgreement() {
        putBoolean(TERMS_SERVICE, true)
    }

    /**
     * 获取是否同意了用户条款
     * @return
     */
        val isAcceptTermsServiceAgreement: Boolean
        get() = preference.getBoolean(TERMS_SERVICE, false)
    //endregion

    /**
     * 移动网络下是否播放
     * @return 默认不能播放
     */
    val isMobileNetworkPlay: Boolean
        get() = preference.getBoolean(KEY_MOBILE_NETWORK_PLAY, false)

    //region 辅助方法
    //往preference内存boolean
    private fun putBoolean(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).apply()
    }
    //endregion


}