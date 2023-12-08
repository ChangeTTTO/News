package com.pn.SuperUi.util;

import android.content.Context
import android.content.res.Configuration

/**
 * 深色模式工具类
 */
object SuperDarkUtil {
    /**
     * 是否是深色模式
     */
    fun isDark(context: Context):Boolean{
        return context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK==Configuration.UI_MODE_NIGHT_YES
    }
}
