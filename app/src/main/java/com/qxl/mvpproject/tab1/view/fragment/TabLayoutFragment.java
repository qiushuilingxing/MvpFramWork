package com.qxl.mvpproject.tab1.view.fragment;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qxl.mvpproject.R;
import com.qxl.mvpproject.databinding.ActivityMyRecyclerviewBinding;
import com.qxl.mvpproject.tab1.presenter.MyRecyclerViewPresenter;
import com.qxl.mvpproject.tab1.presenter.TabLayoutFragmentPresenter;

import mvp.view.impl.BaseFragment;

/**
 * Created by xiaoling on 2017/2/17.
 */
public class TabLayoutFragment extends BaseFragment<TabLayoutFragmentPresenter> {
    ActivityMyRecyclerviewBinding binding;

    @Override
    public View getRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_my_recyclerview,container,false);
        return binding.getRoot();
    }

    @Override
    public void initView(View view) {
        binding.myRecyclerViewActivityRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.myRecyclerViewActivityRv.setAdapter(getPresenter().getAdapter());
    }

    @Override
    public TabLayoutFragmentPresenter bindPresenter() {
        return new TabLayoutFragmentPresenter(getActivity());
    }
}
