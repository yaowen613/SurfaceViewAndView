package com.yaowen.surfaceviewandview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HelloWorld on 2015/10/27.
 */
public class MyView extends View {
    private Context context;
    int count=0;
    public int r=10;//圆的半径

    public MyView(Context context) {
        super(context);
        this.context=context;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (count<=100){
            count++;
        }else count=0;
        //绘图
        Paint paint=new Paint();
        switch (count%4){
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
                paint.setColor(Color.BLACK);
                break;
        }
        canvas.drawCircle((320+r)/2,(480+r)/2,r,paint);
    }
}
