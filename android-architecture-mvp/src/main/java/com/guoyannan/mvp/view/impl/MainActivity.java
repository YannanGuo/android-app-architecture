package com.guoyannan.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.guoyannan.mvp.R;
import com.guoyannan.mvp.injection.AppComponent;
import com.guoyannan.mvp.injection.DaggerMainViewComponent;
import com.guoyannan.mvp.injection.MainViewModule;
import com.guoyannan.mvp.presenter.MainPresenter;
import com.guoyannan.mvp.presenter.loader.PresenterFactory;
import com.guoyannan.mvp.view.MainView;

import javax.inject.Inject;

public final class MainActivity extends BaseActivity<MainPresenter, MainView> implements MainView {

    @Inject
    PresenterFactory<MainPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerMainViewComponent.builder()
                .appComponent(parentComponent)
                .mainViewModule(new MainViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<MainPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
