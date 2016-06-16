package com.guoxiaoxing.mvp.injection;

import android.support.annotation.NonNull;

import com.guoxiaoxing.mvp.view.MainView;
import com.guoxiaoxing.mvp.interactor.MainInteractor;
import com.guoxiaoxing.mvp.interactor.impl.MainInteractorImpl;
import com.guoxiaoxing.mvp.presenter.MainPresenter;
import com.guoxiaoxing.mvp.presenter.impl.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainViewModule {
    /**
     * Stored view
     */
    private final MainView mView;

    public MainViewModule(@NonNull MainView view) {
        mView = view;
    }

    @Provides
    public MainView provideView() {
        return mView;
    }

    @Provides
    public MainInteractor provideInteractor() {
        return new MainInteractorImpl();
    }

    @Provides
    public MainPresenter providePresenter(@NonNull MainView view, @NonNull MainInteractor interactor) {
        return new MainPresenterImpl(view, interactor);
    }
}
