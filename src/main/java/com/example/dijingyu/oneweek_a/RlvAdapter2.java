package com.example.dijingyu.oneweek_a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * 作者：邸某某
 * 时间：2019/3/31
 */

class RlvAdapter2 extends RecyclerView.Adapter{


    private final ArrayList<Bean.T1348654151579Bean> list;
    private OnClickListener listener;
    private Context mContext;

    public RlvAdapter2(ArrayList<Bean.T1348654151579Bean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mName.setText(list.get(position).getTitle());
        viewHolder.mTitle.setText(list.get(position).getSource());
        Glide.with(mContext).load(list.get(position).getImgsrc()).into(viewHolder.mIv);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v,position);
            }
        });
    }

    public void addData(ArrayList<Bean.T1348654151579Bean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public interface OnClickListener{
        void onClick(View view, int position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }
    public ArrayList<Bean.T1348654151579Bean> getList() {
        return list;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;
        private final TextView mName;
        private final TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv);
            mName = itemView.findViewById(R.id.tv_name);
            mTitle = itemView.findViewById(R.id.tv_title);
        }
    }

}
