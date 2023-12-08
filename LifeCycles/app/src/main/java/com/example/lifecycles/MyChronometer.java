package com.example.lifecycles;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class MyChronometer extends Chronometer implements LifecycleEventObserver {
    private long time;
    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_PAUSE) {
            // 在活动暂停时执行的代码
            time = SystemClock.elapsedRealtime() - getBase();
            stop();
        }
        if (event==Lifecycle.Event.ON_RESUME){
            setBase(SystemClock.elapsedRealtime()-time);
            start();
        }
    }
}
