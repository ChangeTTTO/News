package com.pn.news.component.guide

import android.os.Bundle
import com.pn.news.Fragment.BaseViewModelFragment
import com.pn.news.databinding.FragmentGuideBinding
import com.pn.news.utils.Constant


/**
 * 引导界面Fragment
 */
class GuideFragment : BaseViewModelFragment<FragmentGuideBinding>() {
    override fun initDatum() {
        super.initDatum()
        //获取数据
        val data = requireArguments().getInt(Constant.ID)
        binding.icon.setImageResource(data)
    }

    companion object {
        /**
         * 创建Fragment
         * 数据通过bundle传输
         * 将bundle数据存入Fragment中
         */
        fun newInstance(data: Int): GuideFragment {
            val args = Bundle()
            args.putInt(Constant.ID, data)

            val fragment = GuideFragment()
            fragment.arguments = args
            return fragment
        }
    }
}