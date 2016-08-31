package com.guoyannan.mvp.injection;

import android.support.annotation.NonNull;

import com.guoyannan.mvp.interactor.MainInteractor;
import com.guoyannan.mvp.interactor.impl.MainInteractorImpl;
import com.guoyannan.mvp.presenter.loader.PresenterFactory;
import com.guoyannan.mvp.presenter.MainPresenter;
import com.guoyannan.mvp.presenter.impl.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainViewModule {
    @Provides
    public MainInteractor provideInteractor() {
        return new MainInteractorImpl();
    }

    @Provides
    public PresenterFactory<MainPresenter> providePresenterFactory(@NonNull final MainInteractor interactor) {
        return new PresenterFactory<MainPresenter>() {
            @NonNull
            @Override
            public MainPresenter create() {
                return new MainPresenterImpl(interactor);
            }
        };
    }
}
