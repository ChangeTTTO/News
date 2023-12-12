package com.pn.news.component.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.FragmentManager
import com.pn.SuperUi.util.ScreenUtil
import com.pn.news.Fragment.BaseDialogFragment
import com.pn.news.R

/**
 * 服务隐私协议对话框fragment
 */
class TermServiceDialogFragment:BaseDialogFragment() {
    override fun initViews() {
        super.initViews()
        //点击fragment外部不会关闭该fragment
        isCancelable = false
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
    override fun getLayoutView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //将xmml布局转换为view,flase是不添加到container中
        return inflater.inflate(R.layout.fragment_dialog_term_service,container,false)
    }

    companion object {
        /**
         * 显示对话框
         */
        fun show(FragmentManager: FragmentManager) {
            val diglogFragment = TermServiceDialogFragment()
            diglogFragment.show(FragmentManager,"TermServiceDialogFragment")
        }
    }
}