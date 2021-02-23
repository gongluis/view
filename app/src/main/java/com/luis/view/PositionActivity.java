package com.luis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.luis.view.databinding.ActivityPositionBinding;

public class PositionActivity extends AppCompatActivity {

    private static final String TAG = PositionActivity.class.getSimpleName();
    private ActivityPositionBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityPositionBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        int top = mBinding.tvHaha.getTop();
        int left = mBinding.tvHaha.getLeft();
        int bottom = mBinding.tvHaha.getBottom();
        int right = mBinding.tvHaha.getRight();
        Log.e(TAG, "onCreate: "+"top: "+top+"left: "+left+"bottom: "+bottom+"right: "+right);//一个view要在界面上显示，要经过Measure，Layout，Draw三个步骤，view的位置确定是在Measure和Layout之后才被赋予的，所以要在view完成上述两个步骤之后才能正确获取到相应的数值


        mBinding.tvHaha.post(new Runnable() {
            @Override
            public void run() {
                int top = mBinding.tvHaha.getTop();//左上角顶点距离x轴距离,view在平移的过程中top\left\right\bottom表示原始位置，其值不会发生改变。发生改变的是X\Y\translationX\translationY
                int left = mBinding.tvHaha.getLeft();//左上角顶点距离左边y轴距离
                int bottom = mBinding.tvHaha.getBottom();//右下角距离顶部x轴的距离
                int right = mBinding.tvHaha.getRight();//右下角顶点距离左边y轴距离
                Log.e(TAG, "onCreate: post中： "+"top: "+top+"left: "+left+"bottom: "+bottom+"right: "+right);

                int wide = right-left;//view的宽度
                int height = bottom-top;//view的高度
                Log.e(TAG, "run: "+"view宽度："+wide+ "view高度："+height);
                //android3.0新加入的x y translationX translationY

                float x = mBinding.tvHaha.getX();
                float y = mBinding.tvHaha.getY();
                Log.e(TAG, "run: "+"左上角的横坐标："+x+"左上角的纵坐标："+y );

                float translationX = mBinding.tvHaha.getTranslationX();//左上角相当于父容器的偏移量
                float translationY = mBinding.tvHaha.getTranslationY();//左上角相当于父容器的偏移量
                x=left+translationX;
                y=top+translationY;

            }
        });


    }
}