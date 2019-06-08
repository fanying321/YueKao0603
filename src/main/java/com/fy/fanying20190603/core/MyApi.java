package com.fy.fanying20190603.core;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:06
 * @Description：描述信息
 */
public interface MyApi {
    @GET
    Observable<ResponseBody> toGet(@Url String url, @HeaderMap Map<String, String> hmap, @QueryMap Map<String, String> qmap);
}
