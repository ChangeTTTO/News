package com.pn.news.component.guide
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class GuideAdapter(val context: Context,fragmentManager:FragmentManager) :FragmentStatePagerAdapter(fragmentManager){
    private var datum :MutableList<Int> = mutableListOf()
    /**
     *有多少item
     */
    override fun getCount(): Int {
        return datum.size
    }

    /**
     *获取当前位置的数据
     */
    override fun getItem(position: Int): Fragment {
        return GuideFragment.newInstance(datum[position])
    }

    /**
     * 设置数据
     */
    fun setDatum(datum: MutableList<Int>) {
        this.datum.clear()
        this.datum.addAll(datum)
        notifyDataSetChanged()
    }
}