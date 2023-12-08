package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.livedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModelWithLiveData myViewModelWithLiveData;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
        myViewModelWithLiveData=new ViewModelProvider(this).get(MyViewModelWithLiveData.class);
        activityMainBinding.setData(myViewModelWithLiveData);

    }
}