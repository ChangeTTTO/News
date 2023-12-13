package com.pn.news.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.ixuea.courses.mymusic.util.ReflectUtil

/**
 * 通用ViewModel Activity
 * 包括ViewBinding，主要是处理每次要setContentView
 * 以及自动创建ViewModel
 * 以及viewModel的通用观察处理
 */
open class BaseViewModelActivity<VB : ViewBinding> : BaseLogicActivity() {
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //调用inflate方法，创建viewBinding,javaClass：当前这个类的class
        binding = ReflectUtil.newViewBinding(layoutInflater, javaClass)

        setContentView(binding.root)
    }
}