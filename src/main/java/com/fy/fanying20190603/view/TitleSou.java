package com.fy.fanying20190603.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fy.fanying20190603.R;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:22
 * @Description：描述信息
 */
public class TitleSou extends LinearLayout {
    TextView text_sou;
    EditText edit_text;
    public TitleSou(Context context) {
        super(context);
    }

    public TitleSou(Context context,  AttributeSet attrs) {
        super(context, attrs);
        View view = inflate(context,R.layout.layout_titlesou,this);
        text_sou = view.findViewById(R.id.text_sou);
        edit_text = view.findViewById(R.id.edit_text);
        text_sou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String cunt = edit_text.getText().toString();
                myCallBack.stringdsadf(cunt);
            }
        });
    }

    public TitleSou(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    MyCallBack myCallBack;

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public interface MyCallBack{
        public void stringdsadf(String json);
    }
}
