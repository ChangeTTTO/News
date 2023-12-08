package com.pn.bottomnavigationdemo2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class twoFragment extends Fragment {

    private TwoViewModel mViewModel;
    private ImageView imageView;
    public static twoFragment newInstance() {
        return new twoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_two, container, false);
        imageView=view.findViewById(R.id.imageView);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TwoViewModel.class);
        imageView.setScaleX(mViewModel.scaleFactor);
        imageView.setScaleY(mViewModel.scaleFactor);
        // TODO: Use the ViewModel
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageView,"scaleX",0,0);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageView,"scaleY",0,0);
        //TODO 可以将这两个放进一个组里
        objectAnimatorX.setDuration(500);
        objectAnimatorY.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!objectAnimatorX.isRunning()){
                    objectAnimatorX.setFloatValues(imageView.getScaleX()+0.1f);
                    objectAnimatorY.setFloatValues(imageView.getScaleY()+0.1f);
                    mViewModel.scaleFactor+=0.1;
                    objectAnimatorX.start();
                    objectAnimatorY.start();
                }
            }
        });

    }

}