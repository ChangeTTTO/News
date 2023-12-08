package com.example.sharedpreferces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Data data =new Data(getApplicationContext());//不能传递this,会有一个内存泄漏
        data.number=1000;
        data.save();
        int y= data.load();
        /*SharedPreferences she =getSharedPreferences("data",Context.MODE_PRIVATE);//获取实例
        SharedPreferences.Editor editor =she.edit();//如果要对其尽心写的操作执行这段话
        editor.putInt("num",200);//在SharedPreferences文件中写入数据
        editor.apply(); //apply采用非同步的方式提交，commit采用同步的方式进行提交
        int x= she.getInt("num",0);//取值，第二个参数是如果没有的话提供一个0*/
    }
}