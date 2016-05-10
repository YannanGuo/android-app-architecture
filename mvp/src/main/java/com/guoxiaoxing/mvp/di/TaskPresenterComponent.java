package com.guoxiaoxing.mvp.di;

import com.guoxiaoxing.mvp.presenter.TaskPresenter;

import dagger.Component;
import dagger.Provides;

/**
 * Author: guoxiaoxing
 * Email: guoxiaoxingv@163.com
 * Site:  https://github.com/guoxiaoxing
 * Date: 16/5/10 下午3:32
 * Function:
 * <p/>
 * Modification history:
 * Date                 Author              Version             Description
 * --------------------------------------------------------------------------
 * 16/5/10 下午3:32     guoxiaoxing           1.0
 */
@FragmentScope
@Component(modules = TaskPresenterModule.class)
public interface TaskPresenterComponent {
    TaskPresenter getTaskPresenter();
}
