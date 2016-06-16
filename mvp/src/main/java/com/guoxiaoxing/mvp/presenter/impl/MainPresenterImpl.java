package com.guoxiaoxing.mvp.presenter.impl;

import android.os.Bundle;

import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.presenter.MainPresenter;
import com.guoxiaoxing.mvp.view.MainView;
import com.guoxiaoxing.mvp.interactor.MainInteractor;

import javax.inject.Inject;

public final class MainPresenterImpl implements MainPresenter {
    /**
     * The view
     */
    @NonNull
    private final MainView mView;
    /**
     * The interactor
     */
    @NonNull
    private final MainInteractor mInteractor;

    @Inject
    public MainPresenterImpl(@NonNull MainView view, @NonNull MainInteractor interactor) {
        mView = view;
        mInteractor = interactor;
    }

    @Override
    public void onRestoreState(@NonNull Bundle savedInstanceState) {

    }

    @Override
    public void onStart(boolean firstStart) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }
}