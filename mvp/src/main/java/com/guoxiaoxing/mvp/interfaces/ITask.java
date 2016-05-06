package com.guoxiaoxing.mvp.interfaces;

import com.guoxiaoxing.mvp.interfaces.base.IBasePresenter;
import com.guoxiaoxing.mvp.interfaces.base.IBaseView;

/**
 * Author: guoxiaoxing
 * Email: guoxiaoxingv@163.com
 * Site:  https://github.com/guoxiaoxing
 * Date: 16/5/6 下午2:41
 * Function:登陆接口，包含VIew层和Presenter层需要实现的业务逻辑
 * <p/>
 * Modification history:
 * Date                 Author              Version             Description
 * --------------------------------------------------------------------------
 * 16/5/6 下午2:41     guoxiaoxing            1.0                 登陆接口
 */
public interface ITask {

    interface IPresenter extends IBasePresenter {

    }

    interface IView extends IBaseView<IPresenter> {

    }
}
