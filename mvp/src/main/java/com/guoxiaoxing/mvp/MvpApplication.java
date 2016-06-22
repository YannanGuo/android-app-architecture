package com.guoxiaoxing.mvp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.injection.AppComponent;
import com.guoxiaoxing.mvp.injection.AppModule;
import com.guoxiaoxing.mvp.injection.DaggerAppComponent;
import com.guoxiaoxing.mvp.injection.DaggerNetworkComponent;
import com.guoxiaoxing.mvp.injection.NetworkComponent;
import com.guoxiaoxing.mvp.injection.NetworkModule;

public final class MvpApplication extends Application {
    private AppComponent mAppComponent;
    private NetworkComponent mNetworkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mNetworkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(""))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public NetworkComponent getNetworkComponent(){
        return mNetworkComponent;
    }
}
