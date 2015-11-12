package com.ylf.jucaipen.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylf.jucaipen.customview.R;

/**
 * Created by Administrator on 2015/11/11.
 */
public class MyView extends RelativeLayout {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int widthModel=MeasureSpec.getMode(widthMeasureSpec);

        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        int heightModel=MeasureSpec.getMode(heightMeasureSpec);
        switch (heightModel){
            case  MeasureSpec.EXACTLY:
                //填充父元素或固定尺寸
                break;
            case  MeasureSpec.AT_MOST:
                //包裹
                break;
            case  MeasureSpec.UNSPECIFIED:
                //随意尺寸  --很少用
                break;
        }
        setMeasuredDimension(widthSize,heightSize);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        TextView textView=new TextView(getContext());
        textView.setText("左上角");
        //top left         bottom   right
        textView.layout(top, left, left + 200, top + 100);
        textView.setBackgroundColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        addView(textView, 0);
        TextView textView1=new TextView(getContext());
        textView1.layout(right - 200, top, right, top + 100);
        textView1.setBackgroundColor(Color.RED);
        textView1.setText("右上角");
        textView1.setGravity(Gravity.CENTER);
        addView(textView1, 1);
        TextView textView2=new TextView(getContext());
        textView2.setText("左下角");
        textView2.setGravity(Gravity.CENTER);
        textView2.setBackgroundColor(Color.RED);
        textView2.layout(left, bottom - 100, left + 200, bottom);
        addView(textView2, 2);

        TextView textView3=new TextView(getContext());
        textView3.setBackgroundColor(Color.RED);
        textView3.setGravity(Gravity.CENTER);
        textView3.layout(right-200,bottom-100,right,bottom);
        addView(textView3,3);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
