package com.luis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;

import com.luis.view.databinding.ActivityGestureAndScrollerBinding;

public class GestureAndScrollerActivity extends AppCompatActivity {

    private static final String TAG = GestureAndScrollerActivity.class.getSimpleName();
    private ActivityGestureAndScrollerBinding mBinding;
    private VelocityTracker mVelocityTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGestureAndScrollerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //1.移动速度追踪 velocityTracker
        //2.手势识别
        //3.滑动实现方法


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent: ACTION_DOWN" );
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent: ACTION_MOVE" );
                //计算移动速度
                mVelocityTracker = VelocityTracker.obtain();
                mVelocityTracker.addMovement(event);

                mVelocityTracker.computeCurrentVelocity(1000);//一个时间单元，单位是ms
                float xVelocity = mVelocityTracker.getXVelocity();//1000ms手指划过的像素数，从右往左滑动的时候速度为负数
                float YVelocity = mVelocityTracker.getYVelocity();
                Log.e(TAG, "onTouchEvent: "+"横向移动速度："+xVelocity+"纵向移动速度："+YVelocity );
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent: ACTION_UP" );
                mVelocityTracker.clear();//不需要使用的时候需要重置来回收内存
                mVelocityTracker.recycle();
                break;
            default:
                break;
        }


        return super.onTouchEvent(event);
    }
}