package com.pn.news


import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.pn.news.activity.BaseViewModelActivity
import com.pn.news.component.login.LoginHomeActivity
import com.pn.news.databinding.ActivityMainBinding
import com.pn.news.utils.Constant

class MainActivity : BaseViewModelActivity<ActivityMainBinding>() {
    override fun initDatum() {
        super.initDatum()
        val action = intent.action
        if (Constant.ACTION_LOGIN==action){
            //跳转到主页
            val intent = Intent(this,LoginHomeActivity::class.java)
            startActivity(intent)
        }
    }
}