package com.qxl.mvpproject.utils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * 常用的ui工具,比如键盘,字体
 * Created by xiaoling on 2017/2/16.
 */
public class UIUtils {
    /**
     * 隐藏软键盘
     */
    public void hideKeyboard(Context context) {
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (((Activity)context).getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (((Activity)context).getCurrentFocus() != null)
                manager.hideSoftInputFromWindow(((Activity)context).getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
