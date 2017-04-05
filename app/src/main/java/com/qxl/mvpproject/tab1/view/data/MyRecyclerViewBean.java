package com.qxl.mvpproject.tab1.view.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.qxl.mvpproject.BR;

/**
 * Created by xiaoling on 2017/2/16.
 */
public class MyRecyclerViewBean extends BaseObservable {
    private String function;//功能名字
    private int indext;//功能对应的序号
    /**
     * 假设RecyclerView的显示结果不是bean本身的function和index字段,而是要求该两个字段合并后再渲染颜色,最终用在列表上
     * 应对这样的需求,可以在bean中添加一个需要的字段,如functionWithIndext
     */
    private SpannableString functionWithIndext;

    public MyRecyclerViewBean(int indext, String function) {
        this.function = function;
        this.indext = indext;
    }
    @Bindable
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
        notifyPropertyChanged(BR.function);
    }
    @Bindable
    public int getIndext() {
        return indext;
    }

    public void setIndext(int indext) {
        this.indext = indext;
        notifyPropertyChanged(BR.indext);
    }
    @Bindable
    public SpannableString getFunctionWithIndext() {
        return getMySpan();
    }

    public void setFunctionWithIndext(SpannableString functionWithIndext) {
        this.functionWithIndext = functionWithIndext;
        notifyPropertyChanged(BR.functionWithIndext);
    }

    /**
     * 按需求吧function和index合并后,假设变换颜色,得到SpannableString类型结果返回
     */
    public SpannableString getMySpan() {
        String str = indext + function;
        SpannableString span = new SpannableString(str);
        if (!TextUtils.isEmpty(function)) {
            span.setSpan(new ForegroundColorSpan(Color.parseColor("#5A246F")),(indext+"").length(),str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        functionWithIndext = span;
        return functionWithIndext;
    }
}
