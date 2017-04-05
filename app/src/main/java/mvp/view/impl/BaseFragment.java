package mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import mvp.presenter.MvpPresenter;

/**
 * 实际使用类
 * Created by xiaoling on 2017/2/16.
 */
public abstract class BaseFragment<P extends MvpPresenter> extends MVPBaseFragment<P> {
    private static String TAG = "";
    public View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (view == null) {
            view = getRootView(inflater, container);
            initView(view);
            Log.e(TAG, "onCreateView __ initView");
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    /**
     * 获取布局
     * @param inflater
     * @param container
     * @return
     */
    public abstract View getRootView(LayoutInflater inflater, @Nullable ViewGroup container);

    /**
     * 主要业务逻辑
     * @param view
     */
    public abstract void initView(View view);

    public abstract P bindPresenter();
}
