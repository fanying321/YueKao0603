package com.fy.fanying20190603.view;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

import io.reactivex.annotations.NonNull;

public final class MyGlide extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        int menoryCacheSizeBytes=1024*1024*20;
        builder.setMemoryCache(new LruResourceCache(menoryCacheSizeBytes));
        //打印一下
        Log.i("lnk", context.getCacheDir().getAbsolutePath() );

        ExternalPreferredCacheDiskCacheFactory cacheDiskCacheFactory=new ExternalPreferredCacheDiskCacheFactory(context,"GoodsGlide",menoryCacheSizeBytes);
        builder.setDiskCache(cacheDiskCacheFactory);

    }
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

}
