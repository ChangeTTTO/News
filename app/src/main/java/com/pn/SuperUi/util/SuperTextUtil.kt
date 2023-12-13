package com.pn.SuperUi.util

import android.text.method.LinkMovementMethod
import android.widget.TextView

/**
 * 文本相关工具类
 */
object SuperTextUtil {
    /**
     * 设置富文本，超链接颜色，链接可点击
     * @param view
     * @param color
     */
    fun setLinkColor(view: TextView, color: Int) {
        //设置超链接文本可以点击
        view.movementMethod = LinkMovementMethod.getInstance()
        //链接的颜色
        view.setLinkTextColor(color)
    }
}