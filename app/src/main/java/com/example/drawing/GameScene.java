package com.example.drawing;

import android.graphics.Canvas;
import android.graphics.Color;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class GameScene extends View {

    private Rect mRect;
    private Paint mPaint;

    public GameScene(Context context) {
        super(context);
    }

    public GameScene(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    //Todo 1: Override onDraw method and setup Paint and Rect if they are null
    @Override
    protected void onDraw(Canvas canvas) {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setColor(Color.CYAN);
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            mPaint.setStrokeWidth(7);
            mRect = new Rect();
        }
        int W = getWidth(); //game scene width
        int H = getHeight();
        mRect.left = W/2 - 200/2;
        mRect.top = H/2 - 100/2;
        mRect.right = W/2 + 200/2;
        mRect.bottom = H/2 + 100/2;

        canvas.drawRect(mRect, mPaint);
    }

    //Todo 2: 200x100 (w1xh2) mRect, calculate the top, left / bottom, right (4 params) of the Rectangle
    //Todo 3: Draw the mRect using Canvas, Paint, mRect
}
