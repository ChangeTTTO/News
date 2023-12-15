package com.pn.news.component.guide

import android.util.Log
import com.pn.news.R
import com.pn.news.activity.BaseViewModelActivity
import com.pn.news.databinding.ActivityGuideBinding
import com.pn.news.utils.PreferenceUtil



/**
 * 左右滚动的引导界面
 * 如果想实现更复杂的效果，例如：滚动时文本缩放等效果，可以使用类似这样的框架：
 * https://github.com/bingoogolapple/BGABanner-Android
 */
class GuideActivity : BaseViewModelActivity<ActivityGuideBinding>() {
    private lateinit var adapter: GuideAdapter
    override fun initDatum() {
        super.initDatum()
        //创建适配器
         adapter = GuideAdapter(this, supportFragmentManager)
        //设置适配器到GuideActivity
        binding.list.adapter=adapter
        //准备数据
        var datum: MutableList<Int> = ArrayList()
        datum.add(R.drawable.guide1)
        datum.add(R.drawable.guide2)
        datum.add(R.drawable.guide3)
        datum.add(R.drawable.guide4)
        datum.add(R.drawable.guide5)

        //设置数据到适配器
        adapter.setDatum(datum)
    }
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