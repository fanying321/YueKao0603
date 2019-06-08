package com.fy.fanying20190603.util;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 13:40
 * @Description：描述信息
 */
public class OkHttpUtil {
    static OkHttpUtil okHttpUtil;
    private final Retrofit retrofit;

    private OkHttpUtil(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(50,TimeUnit.SECONDS)
                .readTimeout(50,TimeUnit.SECONDS)
                .connectTimeout(50,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request  =chain.request();
                        Log.e("aaa",request.toString());
                        Response response = chain.proceed(request);
                        Log.e("aaa",response.toString());
                        return response;
                    }
                }).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/small/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static OkHttpUtil getContencea(){
        if (okHttpUtil ==null){
            okHttpUtil= new OkHttpUtil();
        }
        return okHttpUtil;
    }


    public <T>T RequestData(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
