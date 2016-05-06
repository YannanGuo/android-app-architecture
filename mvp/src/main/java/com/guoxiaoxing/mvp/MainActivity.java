package com.guoxiaoxing.mvp;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;

import com.guoxiaoxing.mvp.model.TaskModel;
import com.guoxiaoxing.mvp.presenter.TaskPresenter;
import com.guoxiaoxing.mvp.view.TaskFragment;

public class MainActivity extends AppCompatActivity implements TaskFragment.OnFragmentInteractionListener {

    private TaskFragment mTaskFragment;
    private TaskPresenter mTaskPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupData();
    }

    private void setupView() {
        mTaskFragment = TaskFragment.newInstance();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.ll_content, mTaskFragment);
        transaction.commit();
    }

    private void setupData() {
        //创建Presenter，这里将mTaskFragment（View）传递给Presenter，这里并没
        //有立即加载数据，这里将mTaskFragment（View）初始化完成，当mTaskFragment
        //初始化完成后，会调用Presenter中国年的方法来加载数据。
        mTaskPresenter = new TaskPresenter(new TaskModel(), mTaskFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
