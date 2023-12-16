package com.pn.news.component.guide

import android.content.Intent
import android.util.Log
import com.pn.news.MainActivity
import com.pn.news.R
import com.pn.news.activity.BaseViewModelActivity
import com.pn.news.databinding.ActivityGuideBinding
import com.pn.news.utils.Constant
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
        //在GuideActivity中为ViewPager绑定适配器
        binding.list.adapter=adapter

        //让指示器根据列表控件配合工作
        binding.indicator.setViewPager(binding.list)

        //适配器注册数据源观察者
        adapter.registerDataSetObserver(binding.indicator.dataSetObserver)
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
            //进行偏好设置
            PreferenceUtil.setShowGuide(false)
            //准备进入主界面之后再进入登录界面
            val intent = Intent(this,MainActivity::class.java)
            intent.action= Constant.ACTION_LOGIN   //携带一个标记到主界面
            startActivity(intent)//  启动主界面
            finish()  //关闭引导界面
        }
        binding.experienceNow.setOnClickListener{
            Log.d(TAG, "initListeners: 点击了立即体验")
            PreferenceUtil.setShowGuide(false)
            //启动应用主界面
            startActivityAfterFinishThis(MainActivity::class.java)
        }
    }
    companion object{
        const val TAG = "GuideActivity"
    }
}