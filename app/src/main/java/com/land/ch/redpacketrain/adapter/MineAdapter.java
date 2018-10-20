package com.land.ch.redpacketrain.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.land.ch.redpacketrain.R;
import com.land.ch.redpacketrain.bean.MineBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import ch.chtool.base.BaseRecyclerHolder;
import ch.chtool.base.BaseRecyclerViewAdapter;
import ch.chtool.base.CommonAdaper;

/**
 * Created by CH
 * on 2018/10/10 16:03
 */
public class MineAdapter extends BaseAdapter {
    private List<MineBean.MineData> mData;

    public MineAdapter(List<MineBean.MineData> data) {
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_layout, null);
            holder = new ViewHolder();
            holder.mView = convertView.findViewById(R.id.item_mine_layout_view);
            holder.mItemCommentHead = convertView.findViewById(R.id.item_mine_layout_img);
            holder.mItemCommentTitle = convertView.findViewById(R.id.item_mine_layout_title);
            convertView.setTag(holder);
            AutoUtils.autoSize(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (mData.get(position).isCanDetail()) {
            holder.mView.setVisibility(View.GONE);
        } else {
            holder.mView.setVisibility(View.VISIBLE);
        }
        holder.mItemCommentTitle.setText(mData.get(position).getTitle());
        Glide.with(holder.mItemCommentHead.getContext()).load(mData.get(position).getIcon()).into(holder.mItemCommentHead);
        return convertView;

    }


    static class ViewHolder {
        ImageView mItemCommentHead;
        TextView mItemCommentTitle;
        boolean isCanDetail;
        View mView;

    }


}