package com.yaowen.surfaceviewandview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by HelloWorld on 2015/10/27.
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    SurfaceHolder surfaceHolder;
    int count = 0;
    int r = 10;

    public MySurfaceView(Context context) {
        super(context);
        //实例化SurfaceHolder对象
        surfaceHolder = this.getHolder();
        //为surfaceHolder添加一个回调函数
        surfaceHolder.addCallback(this);
        this.setFocusable(true);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //在surface创建时激发
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //开启视图线程
        new Thread(this).start();
    }

    //在surface大小改变时激发
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (surfaceHolder) {
                Draw();
            }
        }
    }

    public void Draw() {
        //锁定画布
        Canvas canvas = surfaceHolder.lockCanvas();
        if (surfaceHolder == null || canvas == null) {
            return;
        }
        if (count <= 100) {
            count++;
        } else {
            count = 0;
        }
        Paint paint = new Paint();
        switch (count % 4) {
            case 0:
                paint.setColor(Color.BLUE);
                break;
            case 1:
                paint.setColor(Color.YELLOW);
                break;
            case 2:
                paint.setColor(Color.GRAY);
                break;
            case 3:
                paint.setColor(Color.RED);
                break;
            default:
                paint.setColor(Color.WHITE);
                break;
        }
        canvas.drawCircle((320 + r) / 2, (480 + r) / 2, r, paint);
        surfaceHolder.unlockCanvasAndPost(canvas);//解锁画布
    }

}
