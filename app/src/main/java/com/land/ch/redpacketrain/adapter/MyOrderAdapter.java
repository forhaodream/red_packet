package com.land.ch.redpacketrain.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.redpacketrain.R;
import com.land.ch.redpacketrain.bean.MineBean;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by CH
 * on 2018/10/11 14:31
 */
public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    public List<MineBean.MineData> mData;

    public OnItemClickListener onItemClickListener;

    private Context mContext;


    public MyOrderAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onToDetail(View view, int position);

        void toTicket(int position);

        void toComment(int position);

        void delItem(int position);

        void close(int position);

        void toPay(int position);
        //    void detailLayout(int position);

    }


    public MyOrderAdapter(List<MineBean.MineData> data) {
        this.mData = data;
        Log.d("aaaaa", data.size() + "");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        AutoUtils.autoSize(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

//        holder.mItemOrderTitle.setText(mData.get(position).getItemlist().get(0).getTitle());
//        holder.mItemOrderPrice.setText("¥" + mData.get(position).getItemlist().get(0).getPrice());
//        holder.mItemOrderGoodsNum.setText("x" + mData.get(position).getItemlist().get(0).getNum());
//        holder.mItemOrderAllMoney.setText("合计: ¥" + mData.get(position).getItemlist().get(0).getPrice());
//
//        holder.mItemOrderState.setText(mData.get(position).getTypename());
//        Glide.with(holder.mItemOrderHead.getContext())
//                .load(mData.get(position).getItemlist().get(0).getImg())
//                .into(holder.mItemOrderHead);
//        if (mData.get(position).getTypename().equals("待支付")) {
//            holder.mItemOrderNoPayRl.setVisibility(View.VISIBLE);
//            holder.mItemOrderFinishRl.setVisibility(View.GONE);
//            holder.mItemOrderTicket.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (onItemClickListener != null) {
//                        onItemClickListener.toTicket(position);
//                    }
//                }
//            });
//        } else if (mData.get(position).getTypename().equals("待评价")) {
//            holder.mItemOrderNoPayRl.setVisibility(View.VISIBLE);
//            holder.mItemOrderFinishRl.setVisibility(View.GONE);
//        } else if (mData.get(position).getTypename().equals("已完成")) {
//            holder.mItemOrderFinishRl.setVisibility(View.VISIBLE);
//            holder.mItemOrderNoPayRl.setVisibility(View.GONE);
//            holder.mItemOrderComment.setVisibility(View.GONE);
//        } else if (mData.get(position).getTypename().equals("已关闭")) {
//            holder.mItemOrderNoPayRl.setVisibility(View.GONE);
//            holder.mItemOrderFinishRl.setVisibility(View.VISIBLE);
//            holder.mItemOrderComment.setVisibility(View.GONE);
//            holder.mItemOrderTicket.setVisibility(View.GONE);
//            holder.mItemOrderDetail.setVisibility(View.GONE);
//
//        }
        // 商品详情展示
        holder.mItemOrderDetailRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
        // 关闭订单
        holder.mItemOrderClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.close(position);
            }
        });
        // 删除订单
        holder.mItemOrderDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.delItem(position);

            }
        });
//        holder.mItemOrderComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickListener.toComment(position);
//            }
//        });
        // 查看票务
        holder.mItemOrderTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.toTicket(position);
            }
        });
        // 订单详情
        holder.mItemOrderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onToDetail(v, position);
            }
        });
        // 支付订单
        holder.mItemOrderPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.toPay(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mItemOrderState;
        ImageView mItemOrderHead;
        TextView mItemOrderTitle;
        TextView mItemOrderPrice;
        TextView mItemOrderGoodsNum;
        TextView mItemOrderAllMoney;
        TextView mItemOrderAllGoods;
        TextView mItemOrderDelete;
        TextView mItemOrderComment;
        TextView mItemOrderTicket;
        TextView mItemOrderDetail;
        AutoRelativeLayout mItemOrderFinishRl;
        TextView mItemOrderClose;
        TextView mItemOrderPayment;
        AutoRelativeLayout mItemOrderNoPayRl;
        AutoRelativeLayout mItemOrderDetailRl;


        public ViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mItemOrderState = (TextView) itemView.findViewById(R.id.item_my_order_state);
            mItemOrderHead = (ImageView) itemView.findViewById(R.id.item_order_head);
            mItemOrderTitle = (TextView) itemView.findViewById(R.id.item_order_title);
            mItemOrderPrice = (TextView) itemView.findViewById(R.id.item_order_price);
            mItemOrderDetail = (TextView) itemView.findViewById(R.id.item_order_detail);
            mItemOrderNoPayRl = (AutoRelativeLayout) itemView.findViewById(R.id.item_order_no_pay_rl);
            mItemOrderClose = (TextView) itemView.findViewById(R.id.item_order_close);
            mItemOrderPayment = (TextView) itemView.findViewById(R.id.item_order_payment);
            mItemOrderDetailRl = itemView.findViewById(R.id.item_order_detial_rl);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(getPosition());
                onItemClickListener.onToDetail(v, getPosition());
                onItemClickListener.toTicket(getPosition());
                onItemClickListener.toComment(getPosition());
                onItemClickListener.delItem(getPosition());
                onItemClickListener.close(getPosition());
                onItemClickListener.toPay(getPosition());

                //   onItemClickListener.detailLayout(getPosition());
            }
        }
    }


}