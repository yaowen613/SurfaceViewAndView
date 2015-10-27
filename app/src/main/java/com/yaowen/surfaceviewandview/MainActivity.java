package com.yaowen.surfaceviewandview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity {
    private MySurfaceView mySurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySurfaceView=new MySurfaceView(this);
        setContentView(mySurfaceView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mySurfaceView.r+=2;
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
