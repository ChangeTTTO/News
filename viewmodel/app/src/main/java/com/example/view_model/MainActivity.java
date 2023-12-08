package com.example.view_model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
viewmodel viewmodel;
TextView textView;
Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取ViewModel实例
        viewmodel= new ViewModelProvider(this).get(viewmodel.class);

        textView=findViewById(R.id.textView);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        textView.setText(String.valueOf(viewmodel.num));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewmodel.num++;
                textView.setText(String.valueOf(viewmodel.num));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewmodel.num--;
                textView.setText(String.valueOf(viewmodel.num));
            }
        });
    }
}