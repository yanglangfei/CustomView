package com.ylf.jucaipen.customview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/11/12.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyHolder> implements View.OnClickListener {

    private final int[] images;
    private  OnItemClickListener onItemClickListener;

    public RecycleAdapter(int[] images) {
        this.images=images;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener!=null){
            onItemClickListener.onClickListener(v, (String) v.getTag());
        }
    }

    public  interface  OnItemClickListener{
          void onClickListener(View view,String date);
      }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView iv=new ImageView(parent.getContext());
        MyHolder holder=new MyHolder(iv);
        iv.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(200,200);
        holder.iv.setLayoutParams(lp);
        holder.iv.setImageResource(images[position]);
        holder.iv.setTag(position+"");

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class  MyHolder extends  RecyclerView.ViewHolder{
        private ImageView iv;

        public MyHolder(ImageView itemView) {
            super(itemView);
            this.iv=itemView;
        }
    }


}
