package com.qxl.mvpproject.tab1.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.qxl.mvpproject.R;
import com.qxl.mvpproject.databinding.ActivityMainBinding;
import com.qxl.mvpproject.tab1.presenter.MainActivityPresenter;

import mvp.view.impl.BaseActivity;

public class MainActivity extends BaseActivity<MainActivityPresenter> {

    private String tag = getClass().getSimpleName();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {
        binding.mainActivityRxBindingTv.setOnClickListener(view -> getPresenter().showRxBinding(MainActivity.this,binding.mainActivityRxBindingTv));
        binding.mainActivityRxPermissionTv.setOnClickListener(view -> getPresenter().showRxPermission(MainActivity.this));
        binding.mainActivityAdapterLibTv.setOnClickListener(view -> getPresenter().showRecyclerViewAndAdapterLib(MainActivity.this));
        binding.mainActivityTabLayoutTv.setOnClickListener(view -> getPresenter().showTabLayout(MainActivity.this));
        binding.mainActivityNetTv.setOnClickListener(view -> getPresenter().netRequest());
    }

    @Override
    public MainActivityPresenter bindPresenter() {
        return new MainActivityPresenter(MainActivity.this);
    }

}
