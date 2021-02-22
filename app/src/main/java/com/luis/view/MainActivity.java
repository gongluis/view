package com.luis.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.luis.view.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());//加载该布局，声明成全局变量可以在oncreat之外其他地方使用
        setContentView(mBinding.getRoot());//调用getRoot可以得到根元素的实例


    }


}