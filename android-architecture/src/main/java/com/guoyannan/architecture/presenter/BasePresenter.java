package com.guoyannan.architecture.presenter;

import android.support.annotation.NonNull;

public interface BasePresenter<V> {
    /**
     * 当View绑定到Presenter时调用, 一般情况下Presenter不需要调用此方法, BasePresenter已经做了绑定处理。
     *
     * @param view the view
     */
    void onViewAttached(@NonNull V view);

    /**
     * 当View执行onStart()方法时调用, 此时View非空可用直到{@link #onStop()}被调用
     *
     * @param firstStart true: Presenter首次启动时为true
     */
    void onStart(boolean firstStart);

    /**
     * 当View执行onStop()时调用, 此时view一直为null直到{@link #onStart(boolean)} 方法重新被调用
     */
    void onStop();

    /**
     * 当View从Presenter分离时调用, 一般情况下Presenter不需要调用此方法, BasePresenter已经做了解绑处理。
     */
    void onViewDetached();

    /**
     * 当presenter被销毁时被调用, 此方法内应该释放相关资源(Http、DataBase等)
     */
    void onPresenterDestroyed();
}