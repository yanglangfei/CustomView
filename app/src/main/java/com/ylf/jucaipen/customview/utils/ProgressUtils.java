package com.ylf.jucaipen.customview.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ProgressBar;

import com.ylf.jucaipen.customview.R;

/**
 * Created by Administrator on 2015/11/12.
 */
public class ProgressUtils {


    public  static ProgressBar createProgressBar(Context context,Activity activity){
        ProgressBar bar= (ProgressBar) activity.findViewById(R.id.pro);
        return  bar;
    }
}
