package com.ylf.jucaipen.customview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.ylf.jucaipen.customview.R;

public class MainActivity extends Activity {
    private ImageView load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        load= (ImageView) findViewById(R.id.load);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.loading);
        LinearInterpolator interpolator=new LinearInterpolator();
        animation.setInterpolator(interpolator);
        load.startAnimation(animation);

    }

}