package com.luis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewAnimationUtils;
import android.view.ViewConfiguration;
import android.widget.Toast;

import com.luis.view.databinding.ActivityMotionEventAndTouchSlopBinding;

public class MotionEventAndTouchSlopActivity extends AppCompatActivity {

    private static final String TAG = MotionEventAndTouchSlopActivity.class.getSimpleName();
    private ActivityMotionEventAndTouchSlopBinding mBinding;
    private int mX1;
    private int mY1;
    private int mX2;
    private int mY2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMotionEventAndTouchSlopBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //TouchSlop 系统所能识别出的被认为是滑动的最小距离。
        int scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        Log.e(TAG, "onCreate:系统所能识别出的被认为是滑动的最小距离: "+scaledTouchSlop );


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();//返回的是当前view左上角的X和Y坐标。
        int y = (int) event.getY();

        int rawX = (int) event.getRawX();//返回的是相对于手机屏幕左上角的X和Y坐标
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mX1 = (int) event.getX();
                mY1 = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //返回的是当前view左上角的X和Y坐标。
                mX2 = (int) event.getX();
                mY2 = (int) event.getY();

                if(mY1 - mY2 > 50) {
                    Toast.makeText(MotionEventAndTouchSlopActivity.this, "向上滑", Toast.LENGTH_SHORT).show();
                } else if(mY2 - mY1 > 50) {
                    Toast.makeText(MotionEventAndTouchSlopActivity.this, "向下滑", Toast.LENGTH_SHORT).show();
                } else if(mX1 - mX2 > 50) {
                    Toast.makeText(MotionEventAndTouchSlopActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
                } else if(mX2 - mX1 > 50) {
                    Toast.makeText(MotionEventAndTouchSlopActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return super.onTouchEvent(event);
    }
}