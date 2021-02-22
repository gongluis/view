package com.luis.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.view.databinding.FragmentTestBinding;

/**
 */
public class TestFragment extends Fragment {


    private FragmentTestBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentTestBinding.inflate(inflater, container, false);
        return mBinding.getRoot();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mBinding=null;
    }
}