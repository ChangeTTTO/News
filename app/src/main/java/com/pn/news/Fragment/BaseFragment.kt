package com.pn.news.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * 所有Fragment父类
 */
abstract class BaseFragment : Fragment() {
    /**
     * 找控件
     */
    protected open fun initViews() {}

    /**
     * 设置数据
     */
    protected open fun initDatum() {}

    /**
     * 设置监听器
     */
    protected open fun initListeners() {}

    /**
     * 返回要显示的控件
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //获取view
        val view = getLayoutView(inflater, container, savedInstanceState)

        //返回view
        return view
    }

    open abstract fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    /**
     * View创建了
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initDatum()
        initListeners()
    }
}