package com.guoyannan.architecture;

import android.app.Application;
import android.support.annotation.NonNull;

import com.guoyannan.architecture.injection.AppComponent;
import com.guoyannan.architecture.injection.AppModule;
import com.guoyannan.architecture.injection.DaggerAppComponent;

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