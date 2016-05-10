package com.guoxiaoxing.mvp.di;

import com.guoxiaoxing.mvp.interfaces.ITask;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Author: guoxiaoxing
 * Email: guoxiaoxingv@163.com
 * Site:  https://github.com/guoxiaoxing
 * Date: 16/5/10 下午3:32
 * Function: TaskPresenterModule，用来传递ITask.View依赖给TaskPresenter
 * <p/>
 * Modification history:
 * Date                 Author              Version             Description
 * --------------------------------------------------------------------------
 * 16/5/10 下午3:32     guoxiaoxing           1.0
 */
@Module
public class TaskPresenterModule {

    private final ITask.IView mTaskView;

    public TaskPresenterModule(ITask.IView taskView) {
        mTaskView = taskView;
    }

    @Provides
    ITask.IView provideTaskView() {
        return mTaskView;
    }
}