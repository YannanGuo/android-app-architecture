package com.guoxiaoxing.mvp.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.MvpApplication;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {
    @NonNull
    private final MvpApplication mApp;

    public AppModule(@NonNull MvpApplication app) {
        mApp = app;
    }

    @Provides
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    public MvpApplication provideApp() {
        return mApp;
    }
}
