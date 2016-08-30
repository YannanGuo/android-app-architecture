package com.guoyannan.architecture.presenter.loader;

import android.support.annotation.NonNull;

import com.guoyannan.architecture.presenter.BasePresenter;

/**
 * Factory to implement to create a presenter
 */
public interface PresenterFactory<T extends BasePresenter> {
    @NonNull
    T create();
}
