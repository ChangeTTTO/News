package com.example.nav_v_model;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.nav_v_model.databinding.FragmentABinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link aFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class aFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public aFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment aFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static aFragment newInstance(String param1, String param2) {
        aFragment fragment = new aFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel=new ViewModelProvider(getActivity()).get(MyViewModel.class);
        //在Fragments中写这一段
        FragmentABinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_a, container, false);
        binding.setData(myViewModel);
        //如果是在activity中直接this,如果实在Fragments的话需要getActivity()
        //getActivity() 返回的是 Fragment 所关联的 Activity 的实例。
        binding.setLifecycleOwner(getActivity());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //view指当前视图的实例Fragments
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_aFragment_to_bFragment);
            }
        });
        //当进入这个页面时，将v-mod中的数字先写入进来
        binding.seekBar.setProgress(myViewModel.getNumber().getValue());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //滑动时将i的值写入进去
               myViewModel.getNumber().setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        //返回binding的根节点，view类型的。
        return binding.getRoot();
    }

}