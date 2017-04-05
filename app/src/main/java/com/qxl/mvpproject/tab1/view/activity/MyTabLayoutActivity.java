package com.qxl.mvpproject.tab1.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.qxl.mvpproject.R;
import com.qxl.mvpproject.databinding.ActivityMyTabLayoutBinding;
import com.qxl.mvpproject.tab1.presenter.MyTabLayoutPresenter;

import java.util.List;

import mvp.presenter.MvpPresenter;
import mvp.view.impl.BaseActivity;

/**
 * Created by xiaoling on 2017/2/17.
 */
public class MyTabLayoutActivity extends BaseActivity<MyTabLayoutPresenter> {
    ActivityMyTabLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_tab_layout);
        initView();
    }

    private void initView() {
        //设置导航栏文字
        List<String> tabTextList = getPresenter().getTabTextList();
        for (String tabText : tabTextList) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(tabText));
        }

        //设置导航栏为可滑动模式
        binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //viewPager绑定adapter
        binding.viewPager.setAdapter(getPresenter().getAdapter(getSupportFragmentManager()));

        //tabLayout绑定viewPager
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public MyTabLayoutPresenter bindPresenter() {
        return new MyTabLayoutPresenter(MyTabLayoutActivity.this);
    }

    public static void startToTabLayoutActivity(Context context) {
        Intent intent = new Intent(context,MyTabLayoutActivity.class);
        context.startActivity(intent);
    }
}
