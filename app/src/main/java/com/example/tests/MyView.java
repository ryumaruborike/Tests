package com.example.tests;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.Random;

public class MyView extends View{
    int N = 30;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    public MyView(Context context) {
        super(context);
    }
    boolean started;
    Paint paint = new Paint();
    Random rand = new Random();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!started){
            for (int i = 0; i < N; i++){
                x[i] = (float)(Math.random() * getWidth());
                y[i] = (float)(Math.random() * getHeight());
                vx[i] = (float)(Math.random() * 10 - 5);
                vy[i] = (float)(Math.random() * 10 - 5);
            }
            started = true;
        }
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 30, paint);
        }
        for (int i = 0; i < N; i++) {
            if (x[i] > getWidth() || x[i] < 0)
            {
                vx[i] = (float)(-vx[i] * 1.1);
                int r = (int)(rand.nextFloat()*255);
                int g = (int)(rand.nextFloat()*255);
                int b = (int)(rand.nextFloat()*255);
                paint.setARGB(255, r, g, b);
            }
            if (y[i] > getHeight() || y[i] < 0)
            {
                vy[i] = (float)(-vy[i] * 1.1);
                int r = (int)(rand.nextFloat()*255);
                int g = (int)(rand.nextFloat()*255);
                int b = (int)(rand.nextFloat()*255);
                paint.setARGB(255, r, g, b);
            }
            x[i] += vx[i];
            y[i] += vy[i];
        }
        invalidate();
    }
}
