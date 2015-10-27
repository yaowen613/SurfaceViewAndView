package com.yaowen.surfaceviewandview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity {
    private MyView myView;
    private  int REFRESH;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==REFRESH){
                myView.invalidate();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView=new MyView(this);
        setContentView(myView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(200);
                    }catch (InterruptedException  e){
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(REFRESH);
                    //使用postIvalidate可以直接在线程中更新UI界面
                    //myView.postInvalidate（）；
                }
            }
        }).start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        myView.r+=2;
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
