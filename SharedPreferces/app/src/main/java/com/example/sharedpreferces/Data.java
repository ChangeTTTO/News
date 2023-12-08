package com.example.sharedpreferces;

import android.content.Context;
import android.content.SharedPreferences;

public class Data {
    private Context context;
    public int number;

    public Data(Context context) {
        this.context = context;
    }

    public void save(){
        SharedPreferences shp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =shp.edit();//如果要对其尽心写的操作执行这段话
        editor.putInt("num",number);//在SharedPreferences文件中写入数据
        editor.apply(); //apply采用非同步的方式提交，commit采用同步的方式进行提交

    }
    public int load(){
        SharedPreferences shp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        number= shp.getInt("num",0);//取值，第二个参数是如果没有的话提供一个0*/
        return number;
    }

}
