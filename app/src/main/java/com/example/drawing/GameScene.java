package com.example.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GameScene extends View {

    private Rect mRect;
    private int shapeColour;
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
            shapeColour = Color.CYAN;
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            mPaint.setStrokeWidth(7);
            mRect = new Rect();
        }
        mPaint.setColor(shapeColour);
        int W = getWidth(); //game scene width
        int H = getHeight();
        mRect.left = W/2 - 200/2; //x1
        mRect.top = H/2 - 100/2; //y1
        mRect.right = W/2 + 200/2; //x2
        mRect.bottom = H/2 + 100/2; //y2

        canvas.drawRect(mRect, mPaint);
    }

    //Todo 2a: Get the touched location and check if it is inside the rect
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        Point touchedPoint = new Point();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                touchedPoint.set((int)event.getX(), (int) event.getY());
                if (isTouch(mRect, touchedPoint)) {
                    //change colour and force redraw
                    shapeColour = Color.rgb(128, 0, 128);
                } else {
                    shapeColour = Color.BLACK;
                }
                invalidate();
                break;
        }

        return true;

    }

    /**
     * @param rect
     * @param touchedPoint
     * @return true if touched inside
     */

    private boolean isTouch(Rect rect, Point touchedPoint) {
        if(rect.left < touchedPoint.x && touchedPoint.x < rect.right //Xa < Xo < Xb
        && rect.top < touchedPoint.y && touchedPoint.y < rect.bottom //Ya < Yo < Yb
        ) {
            return true;
        }
        return false;
    }

    //Todo 2: 200x100 (w1xh2) mRect, calculate the top, left / bottom, right (4 params) of the Rectangle
    //Todo 3: Draw the mRect using Canvas, Paint, mRect
    //Todo 3a: Change the colour if touched and force redrawing
}
