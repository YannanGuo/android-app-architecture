package com.guoyannan.architecture.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.guoyannan.architecture.R;
import com.guoyannan.architecture.view.MainView;
import com.guoyannan.architecture.presenter.loader.PresenterFactory;
import com.guoyannan.architecture.presenter.MainPresenter;
import com.guoyannan.architecture.injection.AppComponent;
import com.guoyannan.architecture.injection.MainViewModule;
import com.guoyannan.architecture.injection.DaggerMainViewComponent;

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
