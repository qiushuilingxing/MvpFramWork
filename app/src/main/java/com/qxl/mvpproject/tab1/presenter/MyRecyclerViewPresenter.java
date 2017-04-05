package com.qxl.mvpproject.tab1.presenter;

import android.content.Context;
import android.widget.Toast;

import com.qxl.mvpproject.R;
import com.qxl.mvpproject.tab1.view.activity.MyRecyclerViewActivity;
import com.qxl.mvpproject.tab1.view.adapter.RvAdapter;
import com.qxl.mvpproject.tab1.view.data.MyRecyclerViewBean;

import java.util.ArrayList;
import java.util.List;

import mvp.model.impl.BaseModel;
import mvp.presenter.impl.BasePresenter;

/**
 * Created by xiaoling on 2017/2/16.
 */
public class MyRecyclerViewPresenter extends BasePresenter<MyRecyclerViewActivity,BaseModel> {
    RvAdapter adapter;

    public MyRecyclerViewPresenter(Context context) {
        super(context);
    }

    @Override
    public BaseModel bindModel() {
        return null;
    }

    public RvAdapter getAdapter() {
        if (adapter == null) {
            adapter = new RvAdapter(getContext(), getList(), R.layout.item_my_recyclerview);
        }
        adapter.setItemPresenter(new ItemClickPresenter());//添加item点击事件
        return adapter;
    }

    public void setAdapter(RvAdapter adapter) {
        this.adapter = adapter;
    }

    public List<MyRecyclerViewBean> getList() {
        List<MyRecyclerViewBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            char c = (char) ((char) i+ 60);
            list.add(new MyRecyclerViewBean(i," 小玲玲"+c));
        }
        return list;
    }
    public class ItemClickPresenter{
        public void onItemClickListner(MyRecyclerViewBean bean) {
            Toast.makeText(getContext(),"点击了"+bean.getFunctionWithIndext(),Toast.LENGTH_LONG).show();
        }
    }
}
