package com.pn.news.component.guide

import android.util.Log
import com.pn.news.activity.BaseViewModelActivity
import com.pn.news.databinding.ActivityGuideBinding
import com.pn.news.utils.PreferenceUtil



/**
 * 左右滚动的引导界面
 * 如果想实现更复杂的效果，例如：滚动时文本缩放等效果，可以使用类似这样的框架：
 * https://github.com/bingoogolapple/BGABanner-Android
 */
class GuideActivity : BaseViewModelActivity<ActivityGuideBinding>() {
    override fun initListeners() {
        super.initListeners()
        binding.loginOrRegister.setOnClickListener{
            Log.d(TAG, "initListeners: 点击了注册登录")
            PreferenceUtil.setShowGuide(false)
        }
        binding.experienceNow.setOnClickListener{
            Log.d(TAG, "initListeners: 点击了立即体验")
            PreferenceUtil.setShowGuide(false)
        }
    }
    companion object{
        const val TAG = "GuideActivity"
    }
}