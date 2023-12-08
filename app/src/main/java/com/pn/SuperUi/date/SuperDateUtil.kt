package com.pn.SuperUi.date

import java.util.Calendar

/**
 * 时间日期工具类
 * object: 单例,可以通过类名直接访问
 */
object SuperDateUtil {
    /**
     *获取当前系统年份
     */
    fun currentYear():Int{
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}