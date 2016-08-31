package com.guoyannan.architecture.injection;

import android.support.annotation.NonNull;

import com.guoyannan.architecture.interactor.MainInteractor;
import com.guoyannan.architecture.interactor.impl.MainInteractorImpl;
import com.guoyannan.architecture.presenter.loader.PresenterFactory;
import com.guoyannan.architecture.presenter.MainPresenter;
import com.guoyannan.architecture.presenter.impl.MainPresenterImpl;

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
