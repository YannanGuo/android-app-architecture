package com.guoxiaoxing.mvp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.injection.AppComponent;
import com.guoxiaoxing.mvp.injection.AppModule;
import com.guoxiaoxing.mvp.injection.DaggerAppComponent;

public final class MvpApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}