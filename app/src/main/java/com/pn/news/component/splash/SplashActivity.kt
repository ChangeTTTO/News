package com.pn.news.component.splash

import android.Manifest
import android.os.Build
import android.util.Log
import com.pn.news.activity.BaseViewModelActivity
import com.permissionx.guolindev.PermissionX
import com.pn.SuperUi.util.SuperDarkUtil
import com.pn.news.databinding.ActivitySplashBinding
import com.pn.news.utils.DefaultPreferenceUtil
import com.qmuiteam.qmui.util.QMUIStatusBarHelper


/**
 * 启动界面
 */
class SplashActivity : BaseViewModelActivity<ActivitySplashBinding>() {
    /**
     * 下面三个基函数都是在onCreate之后调用,在 setContentView(R.layout.activity_splash)之后
     */
    override fun initViews() {
        super.initViews()
        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this)
        //如果系统为深色模式
        if (SuperDarkUtil.isDark(this)){
            //状态栏文字为黑色
            QMUIStatusBarHelper.setStatusBarLightMode(this)
        }else{
            //状态栏文字为白色
            QMUIStatusBarHelper.setStatusBarDarkMode(this)
        }
    }

    override fun initDatum() {
        super.initDatum()
        if(DefaultPreferenceUtil.getInstance(this).isAcceptTermsServiceAgreement){
            //已经同意了用户协议
            requestPermission()  //进行动态权限获取，如果已经获取了将不会再次获取
        }else{
            //显示对话框
            showTermsServiceAgreementDialog()
        }
        //设置版本年份
       /* val currentYear = SuperDateUtil.currentYear()
         val copyright = findViewById<TextView>(R.id.copyright)
        copyright.text = "Copyright @${currentYear}"*/


    }

    /**
     * 进行动态权限获取，如果已经获取了将不会再次获取
     */
    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            PermissionX.init(this).permissions(
                Manifest.permission.CAMERA,   //相机
                Manifest.permission.RECORD_AUDIO,//麦克风
                Manifest.permission.ACCESS_COARSE_LOCATION,  //模糊定位
                Manifest.permission.ACCESS_FINE_LOCATION,  //高精度定位
                Manifest.permission.READ_PHONE_STATE,
                //当前手机系统版本大于Build.VERSION_CODES.TIRAMISU使用一下权限
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO,
            )
        } else {
            PermissionX.init(this).permissions(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                //不大于的话使用以下权限
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
            )
        }.request { allGranted, grantedList, deniedList ->
            if (allGranted) {   //如果所有的权限都同意了
                //延迟进入下一个界面
                binding.root.postDelayed({
                    prepareNext()
                }, 1000)

            } else {
                //可以在这里弹出提示告诉用户为什么需要权限
                finish() //关闭应用
            }
        }
    }

    private fun prepareNext() {

    }


    /* private fun showTermsServiceAgreementDialog() {
         TermServiceDialogFragment.show(supportFragmentManager,object: View.OnClickListener{
             override fun onClick(v: View?) {
                 Log.d(TAG,"primary onClick")   //点击同意之后打印日志
             }
         })
     }*/
    /**
     * 显示对话框并进行点击回调，也就是说进行点击事件之后要发生的事
     */
    private fun showTermsServiceAgreementDialog() {
        TermServiceDialogFragment.show(supportFragmentManager) {
            Log.d(TAG, "primary onClick")   //点击同意之后打印日志
            //保存用户状态，设置为已点击同意
            DefaultPreferenceUtil.getInstance(this).setAcceptTermsServiceAgreement()
            requestPermission()  //进行动态权限获取
        }
    }
    companion object{
        const val TAG="SplashActivity"
    }
}