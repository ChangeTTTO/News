package com.pn.news.component.guide
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.pn.news.adapter.BaseFragmentPagerAdapter

class GuideAdapter(context: Context, fragmentManager: FragmentManager) :
    BaseFragmentPagerAdapter<Int>(context, fragmentManager) {

    /**
     * 获取当前位置的数据
     * @param position
     * @return
     */
    override fun getItem(position: Int): Fragment {
        return GuideFragment.newInstance(getData(position))
    }

}