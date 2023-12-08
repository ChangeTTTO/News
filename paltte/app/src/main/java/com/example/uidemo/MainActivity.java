package com.example.uidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Button buttonleft,buttonright,button3;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox yuwen,shuxue,yingyu;
    RatingBar ratingBar;
    String yu=" ";
    String shu= " ";
    String ying = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState!=null){
            String s=savedInstanceState.getString("KEY");
            editText.setText(s);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.text);
        buttonleft=findViewById(R.id.button1);
        buttonright=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        aSwitch=findViewById(R.id.switch1);
        progressBar=findViewById(R.id.progressBar4);
        editText=findViewById(R.id.editTextNumber);
        radioGroup=findViewById(R.id.group);
        imageView=findViewById(R.id.imageView2);
        seekBar=findViewById(R.id.seekBar);
        yuwen=findViewById(R.id.checkBox);
        shuxue=findViewById(R.id.checkBox2);
        yingyu=findViewById(R.id.checkBox3);
        ratingBar=findViewById(R.id.ratingBar);

        buttonleft.setOnClickListener(view->display.setText("左"));
        buttonright.setOnClickListener(view->display.setText("右"));
        aSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b){
                display.setText("开");
            }else {
                display.setText("关");
            }
        });
        button3.setOnClickListener(view -> {
            String s= editText.getText().toString();  //从输入框中获取一个值
            if(TextUtils.isEmpty(s)){
                s="0";    //如果这个值为空，那么就给一个默认值
            }
            progressBar.setProgress(Integer.valueOf(s));//将字符串转为整型，并将该值给到progressBar,后面的参数可以给个true，有过渡动画
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            //i表示选中的是第几号Radio
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.radioButton){
                    imageView.setImageResource(R.drawable.x);
                }else {
                    imageView.setImageResource(R.drawable.y);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //当滑动值改变时，i为改变的值，b表示进度的变化是否是由用户手动操作触发的。
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    display.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        yuwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    yu="语文";
                }
                else {
                    yu=" ";
                }
                display.setText(yu+shu+ying);
            }
        });
        shuxue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    shu="数学";
                }
                else {
                    shu=" ";
                }
                display.setText(yu+shu+ying);
            }
        });
        yingyu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ying="英语";
                }else {
                    ying=" ";
                }
                display.setText(yu+shu+ying);
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(),String.valueOf(v),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY",editText.getText().toString());
    }
}