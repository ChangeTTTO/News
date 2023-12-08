package com.example.nav_v_model;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nav_v_model.databinding.FragmentBBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static bFragment newInstance(String param1, String param2) {
        bFragment fragment = new bFragment();
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
        FragmentBBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_b, container, false);
        binding.setData(myViewModel);
        //如果是在activity中直接this,如果实在Fragments的话需要getActivity()
        //getActivity() 返回的是 Fragment 所关联的 Activity 的实例。
        binding.setLifecycleOwner(getActivity());
        //点击按钮返回回来
       binding.button4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavController controller = Navigation.findNavController(view);
               controller.navigate(R.id.action_bFragment_to_aFragment);
           }
       });
       return  binding.getRoot();
    }
}