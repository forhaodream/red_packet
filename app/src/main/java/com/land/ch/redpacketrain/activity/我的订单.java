package com.land.ch.redpacketrain.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.redpacketrain.R;
import com.land.ch.redpacketrain.bean.MineBean;

import java.util.List;

import ch.chtool.base.BaseActivity;
import ch.chtool.base.BaseRecyclerHolder;
import ch.chtool.base.BaseRecyclerViewAdapter;

/**
 * Created by CH
 * on 2018/10/11 09:50
 */
public class 我的订单 extends BaseActivity {
    private RecyclerView mRecyclerView;
    private BaseRecyclerViewAdapter<MineBean.MineData> mAdapter;
    private List<MineBean.MineData> mData;
    private ImageView returnImg;

    @Override
    public int initLayout() {
        return R.layout.activity_my_order;
    }

    @Override
    public void initView() {
        mRecyclerView = findViewById(R.id.activity_order_recycle);
        returnImg = findViewById(R.id.title_back);

    }

    TextView mTextView;

    @Override
    public void initData() {
        mAdapter = new BaseRecyclerViewAdapter<MineBean.MineData>(this, mData, R.layout.item_my_order) {

            //this.m订单编号 = (TextView) view.findViewById(R.id.订单编号);
            //this.mItemMyOrderState = (TextView) view.findViewById(R.id.item_my_order_state);
            //this.mItemOrderHead = (ImageView) view.findViewById(R.id.item_order_head);
            //this.mItemOrderTitle = (TextView) view.findViewById(R.id.item_order_title);
            //this.mItemOrderPrice = (TextView) view.findViewById(R.id.item_order_price);
            //this.mItemOrderDetialRl = (AutoRelativeLayout) view.findViewById(R.id.item_order_detial_rl);
            //this.mItemOrderDetail = (TextView) view.findViewById(R.id.item_order_detail);
            //this.mItemOrderPayRl = (AutoRelativeLayout) view.findViewById(R.id.item_order_pay_rl);
            //this.mItemOrderClose = (TextView) view.findViewById(R.id.item_order_close);
            //this.mItemOrderPayment = (TextView) view.findViewById(R.id.item_order_payment);
            //this.mItemOrderNoPayRl = (AutoRelativeLayout) view.findViewById(R.id.item_order_no_pay_rl);


            @Override
            public void convert(BaseRecyclerHolder baseRecyclerHolder, MineBean.MineData mineData, int i, boolean b) {
                baseRecyclerHolder.setText(R.id.订单编号, "");


            }
        };
    }

    private void order() {
        String url = "";


    }


}
