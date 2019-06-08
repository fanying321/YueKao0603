package com.fy.fanying20190603;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fy.fanying20190603.adapter.PhotoActivity;
import com.fy.fanying20190603.bean.Result;
import com.fy.fanying20190603.bean.XiangBean;
import com.fy.fanying20190603.core.ConteatInterfac;
import com.fy.fanying20190603.presenter.MyPresneter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangQingActivity extends AppCompatActivity implements ConteatInterfac.ActivityInterfac {
    ConteatInterfac.PresenterInterfac presenterInterfac;
    List<String> list = new ArrayList<>();
    @BindView(R.id.my_banner)
    Banner myBanner;
    @BindView(R.id.xiang_price)
    TextView xiangPrice;
    @BindView(R.id.xiang_num)
    TextView xiangNum;
    @BindView(R.id.xiang_name)
    TextView xiangName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        EventBus.getDefault().register(this);

    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void zhiId(Result results) {


        long commodityId = results.getCommodityId();
        presenterInterfac = new MyPresneter<>(this);
        presenterInterfac.getData(commodityId+"");

    }

    @Override
    protected void onStart() {
        super.onStart();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showData(Object object) {
        XiangBean xiangBean = (XiangBean) object;
        String picture = xiangBean.getResult().getPicture();
        String[] split = picture.split(",");
        for (int i = 0; i <split.length ; i++) {
            list.add(split[i]);
        }
        myBanner.isAutoPlay(true);
        myBanner.setImages(list).setDelayTime(3000)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                    }
                }).start();
        myBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("aaa","onClick");
                Intent intent = new Intent(XiangQingActivity.this,PhotoActivity.class);
                startActivity(intent);
            }
        });
        xiangName.setText(xiangBean.getResult().getCategoryName());
        xiangNum.setText("已售"+xiangBean.getResult().getCommentNum()+"件");
        xiangPrice.setText(xiangBean.getResult().getPrice()+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenterInterfac!=null){
            presenterInterfac.onDestory();
        }
    }


}
