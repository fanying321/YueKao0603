package com.fy.fanying20190603.presenter;

import android.util.Log;

import com.fy.fanying20190603.bean.SouBean;
import com.fy.fanying20190603.bean.XiangBean;
import com.fy.fanying20190603.core.ConteatInterfac;
import com.fy.fanying20190603.model.MyModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:35
 * @Description：描述信息
 */
public class MyPresneter <T> implements ConteatInterfac.PresenterInterfac{
    MyModel myModel;
    T tt;

    public MyPresneter(T tt) {
        this.tt = tt;
        myModel= new MyModel();
    }

    @Override
    public void getResultsss(String keyword) {
        String url = "commodity/v1/findCommodityByKeyword";
        Map<String,String> map = new HashMap<>();
        map.put("keyword",keyword);
        map.put("page","1");
        map.put("count","10");
        myModel.RequestGet(url, new HashMap<String, String>(), map, new MyModel.MyCallBack() {
            @Override
            public void stringdsadf(String json) {
                Gson gson = new Gson();
                SouBean souBean = gson.fromJson(json, SouBean.class);
                ConteatInterfac.Fragment1Interfac fragment1Interfac= (ConteatInterfac.Fragment1Interfac) tt;
                fragment1Interfac.showResultsss(souBean);
            }
        });

    }

    @Override
    public void getData(String id) {
        Log.e("aaa","getData");
        String url = "commodity/v1/findCommodityDetailsById";
        Map<String,String> map = new HashMap<>();
        map.put("commodityId",id);
        myModel.RequestGet(url, new HashMap<String, String>(), map, new MyModel.MyCallBack() {
            @Override
            public void stringdsadf(String json) {
                Gson gson = new Gson();
                Log.e("aaa",json);
                XiangBean xiangBean = gson.fromJson(json, XiangBean.class);
                ConteatInterfac.ActivityInterfac activityInterfac  = (ConteatInterfac.ActivityInterfac) tt;
                activityInterfac.showData(xiangBean);
            }
        });

    }

    @Override
    public void onDestory() {
        if(tt!=null){
            tt=null;
        }
    }
}
