package com.guoyannan.mvp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.guoyannan.mvp.injection.AppComponent;
import com.guoyannan.mvp.injection.AppModule;
import com.guoyannan.mvp.injection.DaggerAppComponent;

public final class App extends Application {

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