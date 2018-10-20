package com.land.ch.redpacketrain.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.redpacketrain.R;

import ch.chtool.base.BaseActivity;

/**
 * Created by CH
 * on 2018/10/10 11:51
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mActivityLoginLogo;
    private TextView mActivityLoginLogoName;
    private ImageView mLoginToQq;
    private ImageView mLoginToWechat;

    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        mActivityLoginLogo = findViewById(R.id.activity_login_logo);
        mActivityLoginLogoName = findViewById(R.id.activity_login_logo_name);
        mLoginToQq = findViewById(R.id.login_to_qq);
        mLoginToQq.setOnClickListener(this);
        mLoginToWechat = findViewById(R.id.login_to_wechat);
        mLoginToWechat.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_to_qq:
                break;
            case R.id.login_to_wechat:
                break;
        }
    }
}
