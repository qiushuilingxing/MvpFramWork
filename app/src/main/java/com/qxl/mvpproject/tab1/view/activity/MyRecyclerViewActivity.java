package com.qxl.mvpproject.tab1.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.qxl.mvpproject.R;
import com.qxl.mvpproject.databinding.ActivityMyRecyclerviewBinding;
import com.qxl.mvpproject.tab1.presenter.MyRecyclerViewPresenter;

import mvp.view.impl.BaseActivity;

/**
 * Created by xiaoling on 2017/2/16.
 */
public class MyRecyclerViewActivity extends BaseActivity<MyRecyclerViewPresenter> {
    ActivityMyRecyclerviewBinding binding;

    @Override
    public MyRecyclerViewPresenter bindPresenter() {
        return new MyRecyclerViewPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_recyclerview);
        binding.myRecyclerViewActivityRv.setLayoutManager(new LinearLayoutManager(this));
        binding.myRecyclerViewActivityRv.setAdapter(getPresenter().getAdapter());
    }

    public static void startToMyRecyclerViewActivity(Context context) {
        Intent intent = new Intent(context, MyRecyclerViewActivity.class);
        context.startActivity(intent);
    }
}
