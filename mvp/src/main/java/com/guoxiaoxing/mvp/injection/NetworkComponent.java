package com.guoxiaoxing.mvp.injection;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Author: guoxiaoxing
 * Date: 16/6/22 上午10:54
 * Function: For more information, you can visit https://github.com/guoxiaoxing or contact me by
 * guoxiaoxingv@163.com
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    Gson getGson();

    Cache getOkHttpCache();

    OkHttpClient getOkHttpClient();

    OkHttpClient getOkHttpClientWithoutCache();

    Retrofit getRetrofit();
}
