package com.ylf.jucaipen.customview.activity;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;

import com.ylf.jucaipen.customview.R;
import com.ylf.jucaipen.customview.utils.ProgressUtils;

/**
 * Created by Administrator on 2015/11/12.
 */
public class ViewActivity extends Activity {
    private ProgressBar bar;
    private Button state;
    private  boolean isVilable;
    private Context context=ViewActivity.this;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_recycle);
        animation= AnimationUtils.loadAnimation(context, R.anim.loading);
        LinearInterpolator linearInterpolator=new LinearInterpolator();
        animation.setInterpolator(linearInterpolator);
        bar=ProgressUtils.createProgressBar(context,ViewActivity.this);
        state= (Button) findViewById(R.id.state);
        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(isVilable){
                   bar.setVisibility(View.VISIBLE);
                   bar.startAnimation(animation);
                   isVilable=false;
                   state.setText(Html.fromHtml("<font color=\"red\" >我:</font><font color=\"green\">好的</font>"));
               }else {
                   bar.clearAnimation();
                   bar.setVisibility(View.GONE);
                   isVilable=true;
               }
            }
        });
    }
}
