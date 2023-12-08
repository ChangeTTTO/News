package com.example.v_model_shp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/** @noinspection ALL*/
public class ViewModel extends AndroidViewModel {
    SavedStateHandle handle;
    public ViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;


        if (!handle.contains("key")) {
            load();
        }
    }
    public LiveData<Integer> getnumber(){
        return handle.getLiveData("key");
    }
    //从SharedPreference读取数据
    public void load(){
        //因为继承了AndroidViewModel所以可以直接获取全局资源getApplication
        //通过调用 getApplication() 方法，你可以获取到当前应用程序的 Application 对象，从而访问应用程序级别的资源
        //getApplication是Context的一个子类
        SharedPreferences shp=getApplication().getSharedPreferences("data",Context.MODE_PRIVATE);
        int x = shp.getInt("key",0);//从SharedPreferences读取数据
        handle.set("key",x);   //写入v-mod的handle中
    }
  public void save(){
      SharedPreferences shp = getApplication().getSharedPreferences("data", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = shp.edit();
      editor.putInt("key", getnumber().getValue());
      editor.apply();
  }

    public void add(int x) {
    handle.set("key",getnumber().getValue()+x);
    save();
    }
}
