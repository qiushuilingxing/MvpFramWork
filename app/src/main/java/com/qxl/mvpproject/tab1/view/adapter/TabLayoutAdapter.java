package com.qxl.mvpproject.tab1.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoling on 2017/2/17.
 */
public class TabLayoutAdapter extends FragmentPagerAdapter {
    private List<String> tabTextList = new ArrayList<>();
    private List<Fragment>fragmentList = new ArrayList<>();

    public TabLayoutAdapter(FragmentManager fm,List<String> tabTextList,List<Fragment>fragmentList) {
        super(fm);
        this.tabTextList = tabTextList;
        this.fragmentList = fragmentList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTextList.get(position % tabTextList.size());
    }
}
