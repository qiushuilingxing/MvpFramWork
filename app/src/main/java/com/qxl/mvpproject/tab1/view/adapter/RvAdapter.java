package com.qxl.mvpproject.tab1.view.adapter;

import android.content.Context;

import com.mcxtzhang.commonadapter.databinding.rv.BaseBindingAdapter;
import com.qxl.mvpproject.databinding.ItemMyRecyclerviewBinding;
import com.qxl.mvpproject.tab1.view.data.MyRecyclerViewBean;

import java.util.List;

/**
 * Created by xiaoling on 2017/2/16.
 */
public class RvAdapter extends BaseBindingAdapter<MyRecyclerViewBean, ItemMyRecyclerviewBinding> {

    public RvAdapter(Context mContext, List mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
    }
}
