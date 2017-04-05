package com.qxl.mvpproject.tab1.presenter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.qxl.mvpproject.tab1.view.activity.MyTabLayoutActivity;
import com.qxl.mvpproject.tab1.view.adapter.TabLayoutAdapter;
import com.qxl.mvpproject.tab1.view.fragment.TabLayoutFragment;

import java.util.ArrayList;
import java.util.List;

import mvp.model.impl.BaseModel;
import mvp.presenter.impl.BasePresenter;

/**
 * Created by xiaoling on 2017/2/17.
 */
public class MyTabLayoutPresenter extends BasePresenter<MyTabLayoutActivity,BaseModel> {
    private TabLayoutAdapter adapter;

    public MyTabLayoutPresenter(Context context) {
        super(context);
    }

    @Override
    public BaseModel bindModel() {
        return null;
    }

    public TabLayoutAdapter getAdapter(FragmentManager fm) {
        if (adapter == null) {
            adapter = new TabLayoutAdapter(fm, getTabTextList(), getFragmentList());
        }
        return adapter;
    }

    public void setAdapter(TabLayoutAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * 获取导航栏文字列表
     * @return
     */
    public List<String> getTabTextList() {
        List<String> tabTextList = new ArrayList<>();
        tabTextList.add("草莓");
        tabTextList.add("桂圆");
        tabTextList.add("荔枝");
        tabTextList.add("芦柑");
        tabTextList.add("樱桃");
        tabTextList.add("小西红柿");
        tabTextList.add("丑橘");
        return tabTextList;
    }

    /**
     * 获取导航栏对应的fragment列表
     * @return
     */
    public List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        int size = getTabTextList().size();
        for (int i = 0; i < size; i++) {
            fragmentList.add(new TabLayoutFragment());
        }
        return fragmentList;
    }

}
