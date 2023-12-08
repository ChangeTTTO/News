package com.pn.bottomnavigationdemo2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class threeFragment extends Fragment {

    private ThreeViewModel mViewModel;
    private ImageView imageView;
    public static threeFragment newInstance() {
        return new threeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_three, container, false);
        imageView=view.findViewById(R.id.imageView);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ThreeViewModel.class);
        imageView.setX(imageView.getX()+mViewModel.dx);
        // TODO: Use the ViewModel
        ObjectAnimator objectAnimator =ObjectAnimator.ofFloat(imageView,"x",0,0);
        objectAnimator.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!objectAnimator.isRunning()){
                    float dx = new Random().nextBoolean()?100:-100;
                    objectAnimator.setFloatValues(imageView.getX(),imageView.getX()+dx);
                    mViewModel.dx+=dx;
                    objectAnimator.start();
                }
            }
        });
    }

}