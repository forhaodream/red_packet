package com.land.ch.redpacketrain.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zhy.autolayout.AutoRelativeLayout;

/**
 * Created by CH
 * on 2018/10/11 10:32
 */
public class TitleLayout extends AutoRelativeLayout {
    private String textString;
    private int textColor;
    private int textSize;
    private TextView titleTv;
    private AutoRelativeLayout mLayout;


    public TitleLayout(Context context) {
        super(context);
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


    }

//    /**
//     * 初始化各个控件
//     */
//    public TitleLayout init(String text, int textSize, int textColor) {
//        //引入之前的xml布局
//        LayoutInflater.from(getContext()).inflate(R.layout.layout_title, this, true);
//        mLayout = findViewById(R.id.layout_title_rlc);
//        titleTv = findViewById(R.id.layout_title_tv);
//        titleTv.setText(text);
//        titleTv.setTextSize(textSize);
//        titleTv.setTextColor(textColor);
//        return this;
//    }


}