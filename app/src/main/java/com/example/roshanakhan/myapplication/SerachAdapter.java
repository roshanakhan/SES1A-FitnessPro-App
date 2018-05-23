package com.example.roshanakhan.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SerachAdapter extends RecyclerView.Adapter<SerachAdapter.ViewHolder> {
    private Context mContext;
    //承载上下文
    //动态数组承载数据使用


    private List<Video> mDataList;

    private LayoutInflater mLayoutInflater;

    public SerachAdapter(Context mContext, List<Video> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.from(parent.getContext()).inflate(R.layout.item_vedio, parent, false);
        return new ViewHolder(v);
    }

    //将数据绑定到控件
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Video entity = mDataList.get(position);
        holder.tv_title.setText(entity.getTitle());
        holder.tv_detail.setText(entity.getDes());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_img;
        private TextView tv_title;
        private TextView tv_detail;

        public ViewHolder(View view) {
            super(view);
            iv_img = (ImageView) view.findViewById(R.id.iv_img);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_detail = (TextView) view.findViewById(R.id.tv_detail);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

