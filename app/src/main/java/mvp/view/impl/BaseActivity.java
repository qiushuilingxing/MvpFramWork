package mvp.view.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import mvp.presenter.MvpPresenter;

/**
 * 实际使用类,添加的功能如下:
 * 指定主题
 * 指定app显示方向
 * 友盟统计的方法入口也可以在此添加,因为涉及appkey,就不单独集成了
 * Created by xiaoling on 2017/2/16.
 */
public abstract class BaseActivity<P extends MvpPresenter> extends MvpBaseActivity<P>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//指定主题
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//app竖屏显示
    }


    public abstract P bindPresenter();

    public void onBackaPressed(){
        finish();
    }

}
