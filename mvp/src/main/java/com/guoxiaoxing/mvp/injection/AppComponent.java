package com.guoxiaoxing.mvp.injection;

import android.content.Context;

import com.guoxiaoxing.mvp.MvpApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    MvpApplication getApp();
}