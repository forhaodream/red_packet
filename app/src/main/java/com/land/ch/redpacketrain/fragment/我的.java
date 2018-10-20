package com.land.ch.redpacketrain.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.land.ch.redpacketrain.R;
import com.land.ch.redpacketrain.activity.LoginActivity;
import com.land.ch.redpacketrain.activity.我的订单;
import com.land.ch.redpacketrain.adapter.MineAdapter;
import com.land.ch.redpacketrain.bean.MineBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import ch.chtool.base.BaseFragment;
import ch.chtool.base.CommonAdaper;
import ch.chtool.base.ViewHolder;

/**
 * Created by CH
 * on 2018/10/10 09:01
 */
public class 我的 extends Fragment {
    private View mView;
    private View view;
    private RoundedImageView mRoundImageView;
    private TextView mUsername;
    private TextView mUsertype;
    private TextView m发布;
    private TextView m关注;
    private TextView m粉丝;
    private ListView mListView;
    private List<MineBean.MineData> mList;
    private MineAdapter mMineAdapter;

//    @Override
//    protected int setView() {
//        return R.layout.fragment_mine;
//    }
//
//    @Override
//    protected void init(View view) {
//        initView(view);
//    }
//
//    @Override
//    protected void initData(Bundle bundle) {
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_mine, null);
        initView(mView);
        return mView;
    }


    private void initView(final View mView) {
        mRoundImageView = (RoundedImageView) mView.findViewById(R.id.round_image_view);
        mUsername = (TextView) mView.findViewById(R.id.username);
        mUsertype = (TextView) mView.findViewById(R.id.usertype);
        m发布 = (TextView) mView.findViewById(R.id.发布);
        m关注 = (TextView) mView.findViewById(R.id.关注);
        m粉丝 = (TextView) mView.findViewById(R.id.粉丝);
        mListView = (ListView) mView.findViewById(R.id.list_view);
        View headView = View.inflate(getActivity(), R.layout.header_mine_layout, null);
        mListView.addHeaderView(headView, null, true);
        mList = new ArrayList<>();
        mList.add(new MineBean.MineData(R.mipmap.love, "钱包", true));
        mList.add(new MineBean.MineData(R.mipmap.love, "卡包", true));
        mList.add(new MineBean.MineData(R.mipmap.love, "推广", true));
        mList.add(new MineBean.MineData(R.mipmap.love, "收藏", false));
        mList.add(new MineBean.MineData(R.mipmap.love, "会员中心", false));
        mList.add(new MineBean.MineData(R.mipmap.love, "完善信息", true));
        mList.add(new MineBean.MineData(R.mipmap.love, "我的订单", true));
        mList.add(new MineBean.MineData(R.mipmap.love, "我的消息", true));
        mList.add(new MineBean.MineData(R.mipmap.love, "帮助反馈", true));
        mMineAdapter = new MineAdapter(mList);
        mListView.setAdapter(mMineAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(getActivity(), 我的订单.class));
                        break;
                }
            }
        });
    }
}
