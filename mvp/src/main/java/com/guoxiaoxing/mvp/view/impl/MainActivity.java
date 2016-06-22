package com.guoxiaoxing.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.R;
import com.guoxiaoxing.mvp.view.MainView;
import com.guoxiaoxing.mvp.presenter.BasePresenter;
import com.guoxiaoxing.mvp.presenter.MainPresenter;
import com.guoxiaoxing.mvp.injection.AppComponent;
import com.guoxiaoxing.mvp.injection.MainViewModule;
import com.guoxiaoxing.mvp.injection.DaggerMainViewComponent;

import javax.inject.Inject;

public final class MainActivity extends BaseActivity implements MainView {
    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected BasePresenter getBasePresenter() {
        return mPresenter;
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerMainViewComponent.builder()
                .appComponent(parentComponent)
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);
    }
}
