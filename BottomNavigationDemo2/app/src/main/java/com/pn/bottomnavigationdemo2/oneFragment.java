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

public class oneFragment extends Fragment {

    private OneViewModel mViewModel;
    private ImageView imageView;
    public static oneFragment newInstance() {
        return new oneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_one, container, false);
       imageView=view.findViewById(R.id.imageView);
       return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(OneViewModel.class);
        //界面切换数据就不在了所以将数据存在v-model中，视图创建时刷新一下
        imageView.setRotation(mViewModel.rotationPosition);
        // TODO: Use the ViewModel
        //为imageView做一个旋转的浮点动画，从0到0
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"rotation",0,0);
        objectAnimator.setDuration(500);//动画时间500毫秒
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果当前并没有在进行动画，那么才执行
                if (!objectAnimator.isRunning()){
                    //当前角度，到当前角度加100度
                    objectAnimator.setFloatValues(imageView.getRotation(),imageView.getRotation() + 100);
                    mViewModel.rotationPosition+=100;
                    objectAnimator.start();
                }

            }
        });
    }

}