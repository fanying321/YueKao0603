package com.fy.fanying20190603.model;

import com.fy.fanying20190603.core.MyApi;
import com.fy.fanying20190603.util.OkHttpUtil;

import java.io.IOException;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:08
 * @Description：描述信息
 */
public class MyModel {
    MyCallBack myCallBack;
    public void  RequestGet(String url, Map<String,String> hmap, Map<String,String> qmap, final MyCallBack myCallBack){
        this.myCallBack = myCallBack;
        OkHttpUtil okHttpUtil = OkHttpUtil.getContencea();
        MyApi myApi = okHttpUtil.RequestData(MyApi.class);
        Observable<ResponseBody> ob = myApi.toGet(url, hmap, qmap);
        ob.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        //成功
                        try {
                            String string = responseBody.string();
                            myCallBack.stringdsadf(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface MyCallBack{
        public void stringdsadf(String json);
    }
}
