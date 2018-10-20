package com.land.ch.redpacketrain.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.land.ch.redpacketrain.R;
import com.land.ch.redpacketrain.fragment.加号;
import com.land.ch.redpacketrain.fragment.发现;
import com.land.ch.redpacketrain.fragment.我的;
import com.land.ch.redpacketrain.fragment.欢乐街;
import com.land.ch.redpacketrain.fragment.生活;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH
 * on 2018/10/9 17:50
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "HomeActivity";
    private FragmentTabHost mTabHost;
    private LinearLayout 欢乐街ll, 生活ll, 加号ll, 发现ll, 我的ll;
    //初始化标签数组
    String tabs[] = {"欢乐街", "生活", "加号", "发现", "我的"};
    //初始化界面数组
    Class cls[] = {欢乐街.class, 生活.class, 加号.class, 发现.class, 我的.class};
    private ImageView 欢乐街Img, 生活Img, 加号Img, 发现Img, 我的Img;
    private TextView 欢乐街Tv, 生活Tv, 加号Tv, 发现Tv, 我的Tv;
    private int userId;
    //清除sp
    private SharedPreferences npt;
    private boolean isExit;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }

    };
    private SharedPreferences readInfo;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.READ_PHONE_STATE) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(HomeActivity.this, permissions, 1);
        } else {
            Log.d("homeA", "已授权");
        }
        npt = getSharedPreferences("user_npt", MODE_PRIVATE);
        userId = npt.getInt("userId", 0);
        mHandler = new Handler();
        addView();
        Intent intent = getIntent();
        int index = intent.getIntExtra("huan", -1);
        readInfo = getSharedPreferences("save_update", Context.MODE_PRIVATE);
        editor = readInfo.edit();
        Log.d("home_index", String.valueOf(index));
        if (String.valueOf(index).equals("1")) {
            setLayoutButton1();
            mTabHost.setCurrentTabByTag(tabs[0]);
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            Toast.makeText(this, "网络已断开,请检查网络", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("tag", "网络已连接");
        }


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }

    private void addView() {
        //实例化控件
        this.欢乐街Img = findViewById(R.id.欢乐街image);
        this.生活Img = findViewById(R.id.生活image);
        this.加号Img = findViewById(R.id.加号image);
        this.发现Img = findViewById(R.id.发现image);
        this.我的Img = findViewById(R.id.我的image);
        this.欢乐街Tv = findViewById(R.id.欢乐街text);
        this.生活Tv = findViewById(R.id.生活text);
        this.加号Tv = findViewById(R.id.加号text);
        this.发现Tv = findViewById(R.id.发现text);
        this.我的Tv = findViewById(R.id.我的text);
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setVisibility(View.GONE);//隐藏顶部切换菜单
        for (int i = 0; i < tabs.length; i++) {
            //向 FragmentTabHost 添加标签以及 Fragment 界面
            mTabHost.addTab(mTabHost.newTabSpec(tabs[i]).setIndicator(tabs[i]),
                    cls[i], null);

        }
        npt = getSharedPreferences("user_npt", MODE_PRIVATE);

        欢乐街ll = findViewById(R.id.欢乐街ll);
        生活ll = findViewById(R.id.生活ll);
        加号ll = findViewById(R.id.加号ll);
        发现ll = findViewById(R.id.发现ll);
        我的ll = findViewById(R.id.我的ll);

        //设置监听事件
        this.欢乐街ll.setOnClickListener(this);
        this.生活ll.setOnClickListener(this);
        this.加号ll.setOnClickListener(this);
        this.发现ll.setOnClickListener(this);
        this.我的ll.setOnClickListener(this);

        //设置默认选中标签
        mTabHost.setCurrentTabByTag(tabs[0]);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.欢乐街ll:
                setLayoutButton0();
                mTabHost.setCurrentTabByTag(tabs[0]);
                break;
            case R.id.生活ll:
                setLayoutButton1();
                mTabHost.setCurrentTabByTag(tabs[1]);
                break;
            case R.id.加号ll:
                setLayoutButton2();
                mTabHost.setCurrentTabByTag(tabs[2]);
                break;
            case R.id.发现ll:
                setlayoutbutton3();
                mTabHost.setCurrentTabByTag(tabs[3]);
                break;
            case R.id.我的ll:
                setlayoutbutton4();
                mTabHost.setCurrentTabByTag(tabs[4]);
                break;

        }
    }

    //设置点击切换标签字体颜色与背景图片的切换

    private void setLayoutButton0() {
        欢乐街Img.setBackgroundResource(R.mipmap.ic_launcher);
        生活Img.setBackgroundResource(R.mipmap.ic_launcher);
        加号Img.setBackgroundResource(R.mipmap.ic_launcher);
        发现Img.setBackgroundResource(R.mipmap.ic_launcher);
        我的Img.setBackgroundResource(R.mipmap.ic_launcher);
        欢乐街Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        生活Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        加号Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        发现Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        我的Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
    }

    private void setLayoutButton1() {
        欢乐街Img.setBackgroundResource(R.mipmap.ic_launcher);
        生活Img.setBackgroundResource(R.mipmap.ic_launcher);
        加号Img.setBackgroundResource(R.mipmap.ic_launcher);
        发现Img.setBackgroundResource(R.mipmap.ic_launcher);
        我的Img.setBackgroundResource(R.mipmap.ic_launcher);
        欢乐街Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        生活Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        加号Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        发现Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        我的Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
    }

    private void setLayoutButton2() {
        欢乐街Img.setBackgroundResource(R.mipmap.ic_launcher);
        生活Img.setBackgroundResource(R.mipmap.ic_launcher);
        加号Img.setBackgroundResource(R.mipmap.ic_launcher);
        发现Img.setBackgroundResource(R.mipmap.ic_launcher);
        我的Img.setBackgroundResource(R.mipmap.ic_launcher);
        欢乐街Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        生活Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        加号Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        发现Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        我的Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
    }

    private void setlayoutbutton3() {
        欢乐街Img.setBackgroundResource(R.mipmap.ic_launcher);
        生活Img.setBackgroundResource(R.mipmap.ic_launcher);
        加号Img.setBackgroundResource(R.mipmap.ic_launcher);
        发现Img.setBackgroundResource(R.mipmap.ic_launcher);
        我的Img.setBackgroundResource(R.mipmap.ic_launcher);
        欢乐街Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        生活Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        加号Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        发现Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        我的Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
    }

    private void setlayoutbutton4() {
        欢乐街Img.setBackgroundResource(R.mipmap.ic_launcher);
        生活Img.setBackgroundResource(R.mipmap.ic_launcher);
        加号Img.setBackgroundResource(R.mipmap.ic_launcher);
        发现Img.setBackgroundResource(R.mipmap.ic_launcher);
        我的Img.setBackgroundResource(R.mipmap.ic_launcher);
        欢乐街Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        生活Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        加号Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        发现Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
        我的Tv.setTextColor(this.getResources().getColor(R.color.text_grays));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            System.gc();

            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            editor.clear();
            editor.apply();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }

}


