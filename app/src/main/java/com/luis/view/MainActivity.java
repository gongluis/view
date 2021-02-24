package com.luis.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.luis.view.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final int QUERY = 0x123;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());//加载该布局，声明成全局变量可以在oncreat之外其他地方使用
        setContentView(mBinding.getRoot());//调用getRoot可以得到根元素的实例

        mBinding.tvPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PositionActivity.class));
            }
        });

        mBinding.tvMotionEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MotionEventAndTouchSlopActivity.class));
            }
        });


        mBinding.tvGestureandscroller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GestureAndScrollerActivity.class));
            }
        });

        HandlerThread handlerThread = new HandlerThread("query");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case QUERY:
//                        Log.e("TAG", "handleMessage: 发起查询" +msg.obj);
                        break;
                    default:
                        break;
                }

            }
        };

        int time = 6;
        while (time>0){
            Message message =Message.obtain();
            message.what =QUERY;
            message.obj = "哈哈哈";
            handler.sendMessageDelayed(message, 10000L*6);
            time--;
        }
    }


}