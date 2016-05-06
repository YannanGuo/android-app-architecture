package com.guoxiaoxing.mvp.presenter;

import com.guoxiaoxing.mvp.interfaces.ITask;
import com.guoxiaoxing.mvp.model.TaskModel;
import com.guoxiaoxing.mvp.presenter.base.BasePresenter;

/**
 * Author: guoxiaoxing
 * Email: guoxiaoxingv@163.com
 * Site:  https://github.com/guoxiaoxing
 * Date: 16/5/6 下午3:07
 * Function: TaskPresenter
 * <p/>
 * Modification history:
 * Date                 Author              Version             Description
 * --------------------------------------------------------------------------
 * 16/5/6 下午3:07     guoxiaoxing           1.0                 TaskPresenter
 */
public class TaskPresenter extends BasePresenter implements ITask.IPresenter {


    private final TaskModel mTaskModel;
    private final ITask.IView mTaskView;

    /**
     * 用数据仓库和显示层构造Presenter层
     *
     * @param taskModel TaskModel
     * @param taskView  ITask.IView
     */
    public TaskPresenter(TaskModel taskModel, ITask.IView taskView) {
        mTaskModel = taskModel;
        mTaskView = taskView;
        mTaskView.setPresenter(this);
    }


    @Override
    public void start() {

    }
}