package com.land.ch.redpacketrain.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.land.ch.redpacketrain.R;
import com.land.ch.redpacketrain.utils.WebViewUtils;

/**
 * Created by CH
 * on 2018/10/10 09:01
 */
public class 发现 extends Fragment {
    private WebViewUtils mWebView;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_find, null);
        return mView;
    }
}
