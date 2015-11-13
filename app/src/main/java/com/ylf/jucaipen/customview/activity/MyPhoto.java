package com.ylf.jucaipen.customview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ylf.jucaipen.customview.R;
import com.ylf.jucaipen.customview.adapter.RecycleAdapter;

/**
 * Created by Administrator on 2015/11/12.
 */
public class MyPhoto extends Activity {
    private RecyclerView recycle;
    private RecycleAdapter adapter;
    private  int position;
    private ImageView image;
    private int images[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.hit,R.mipmap.load,R.mipmap.ic_launcher,R.mipmap.hit,R.mipmap.load,R.mipmap.robot,R.mipmap.ic_launcher,R.mipmap.hit,R.mipmap.load};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_photo);
        initView();
    }

    private void initView() {
        recycle= (RecyclerView) findViewById(R.id.recycle);
        image= (ImageView) findViewById(R.id.image);
        //设置RecycleView 的布局
        //LinearLayoutManager     线性布局
        //GridLayoutManager       网格布局
        //StaggeredGridLayoutManager  瀑布流布局
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(linearLayoutManager);
        adapter=new RecycleAdapter(images);
        //item 高度统一   优化
        recycle.setHasFixedSize(true);
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(View view, String date) {
                position=Integer.parseInt(date);
                image.setImageResource(images[position]);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
