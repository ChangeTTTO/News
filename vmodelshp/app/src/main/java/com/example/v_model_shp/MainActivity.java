package com.example.v_model_shp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.v_model_shp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel=new ViewModelProvider(this).get(ViewModel.class);

        binding.setData(viewModel);
        binding.setLifecycleOwner(this);  //实现livedata的自我监听
    }

}