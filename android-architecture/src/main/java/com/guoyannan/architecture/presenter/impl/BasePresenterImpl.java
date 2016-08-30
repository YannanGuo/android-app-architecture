package com.guoyannan.architecture.presenter.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.guoyannan.architecture.presenter.BasePresenter;

/**
 * BasePresenter的抽象实现类, 包含类其他Presenters的基础实现, 子类需要调用super方法
 *
 * @param <V>
 */
public abstract class BasePresenterImpl<V> implements BasePresenter<V> {
    /**
     * The view
     */
    @Nullable
    protected V mView;

    @Override
    public void onViewAttached(@NonNull V view) {
        mView = view;
    }

    @Override
    public void onStart(boolean firstStart) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onViewDetached() {
        mView = null;
    }

    @Override
    public void onPresenterDestroyed() {

    }
}
