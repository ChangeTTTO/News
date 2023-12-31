package com.pn.news.component.splash

import android.os.Bundle
import android.os.Process
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.FragmentManager
import com.google.android.material.button.MaterialButton
import com.pn.SuperUi.util.ScreenUtil
import com.pn.SuperUi.util.SuperProcessUtil
import com.pn.SuperUi.util.SuperTextUtil
import com.pn.news.Fragment.BaseCommonFragment
import com.pn.news.Fragment.BaseDialogFragment
import com.pn.news.Fragment.BaseViewModelDialogFragment
import com.pn.news.R
import com.pn.news.databinding.FragmentDialogTermServiceBinding
import com.pn.news.utils.DefaultPreferenceUtil

/**
 * 服务隐私协议对话框fragment
 */
class TermServiceDialogFragment:BaseViewModelDialogFragment<FragmentDialogTermServiceBinding>() {
    private lateinit var onAgreementClickListener: View.OnClickListener

    override fun initViews() {
        super.initViews()
        //点击fragment外部不会关闭该fragment
        isCancelable = false
        //SuperTextUtil.setLinkColor(contentView,R.color.red)
        /**
         * SuperTextUtil:实现超链接点击，超链接颜色
         */
        SuperTextUtil.setLinkColor(binding.content,getColor(requireContext(),R.color.link))


    }

    override fun initDatum() {
        super.initDatum()
        //实现富文本格式
        val content =Html.fromHtml(getString(R.string.term_service_privacy_content))
        binding.content.text=content
    }

    override fun initListeners() {
        super.initListeners()
        //同意按钮点击
        binding.primary.setOnClickListener{
            dismiss()    //关闭对话框fragment
            onAgreementClickListener.onClick(it)  //回调给外部,外部就可以通过监听器监听到内部的事件然后做出相应处理
        }
        //不同意按钮点击
        binding.disagree.setOnClickListener{
            dismiss()    //关闭对话框fragment
            //杀死当前应用
           SuperProcessUtil.killApp()
        }
    }

    /**
     * 宽度修改为屏幕宽度的90％
     * 高度是包裹内容
     * ScreenUtil:获取屏幕宽度
     */
    override fun onResume() {
        super.onResume()
        //修改fragment宽度，默认比AlertDialog.Builder显示对话框宽度窄，看着不好看
        //参考：https://stackoverflow.com/questions/12478520/how-to-set-dialogfragments-width-and-height
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ((ScreenUtil.getScreenWith(requireContext()) * 0.9).toInt())
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams  //进行设置
    }


    companion object {
        /**
         * 显示对话框
         * @param：fragmentManager:填入supportFragmentManager可以展示当前fragment
         * @param：onAgreementClickListener: 进行点击事件回调
         */
        fun show(fragmentManager: FragmentManager ,onAgreementClickListener: View.OnClickListener) {
            val dialogFragment = TermServiceDialogFragment()
            dialogFragment.onAgreementClickListener=onAgreementClickListener

            dialogFragment.show(fragmentManager,"TermServiceDialogFragment")
        }
    }
}