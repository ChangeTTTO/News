package com.pn.news.activity

import android.content.Intent
import android.os.Build

/**
 * 通用界面逻辑
 */
open class BaseCommonActivity : BaseActivity() {
    /**
     * 启动界面
     * @param clazz
     */
    private fun startActivity(clazz: Class<*>) {
        //创建Intent
        val intent = Intent(this, clazz)
        //启动界面
        startActivity(intent)
    }

    /**
     * 启动界面并关闭当前界面
     * @param clazz
     */
    fun startActivityAfterFinishThis(clazz: Class<*>) {
        startActivity(clazz)
        //谁调关谁，关闭之后按返回键将不会返回到被关闭的界面
        finish()
    }

    /**
     * 启动界面，可以传递一个字符串参数
     * @param clazz
     * @param id
     */
   /* protected fun startActivityExtraId(
        clazz: Class<*>,
        id: String
    ) {
        //创建Intent
        val intent = Intent(this, clazz).apply {
            //传递数据
            //不为空才传递
            putExtra(Constant.ID, id)
        }

        //启动界面
        startActivity(intent)
    }*/

    /**
     * 获取字符串
     * @param key
     * @return
     */
    protected fun extraString(key: String): String {
        return extraStringOrNull(key)!!
    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    private fun extraStringOrNull(key: String): String? {
        return intent.getStringExtra(key)
    }

    /**
     * 获取字符串类型Id
     *
     * @return
     */
   /* protected fun extraId(): String {
        return extraString(Constant.ID)
    }
*/
    /**
     * 获取int值
     *
     * @param key
     * @return
     */
    protected fun extraInt(key: String): Int {
        return intent.getIntExtra(key, -1)
    }

    /**
     * 设置状态栏颜色
     *
     * @param data
     */
    protected open fun setStatusBarColor(data: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置状态栏颜色
            val window = window
            window.statusBarColor = data

            //设置导航栏颜色
            window.navigationBarColor = data
        }
    }

    /**
     * 获取data对象
     * @return
     */
  /*  protected inline fun <reified T> extraData(): T {
        return intent.getParcelableExtra(Constant.DATA)!!
    }*/
}