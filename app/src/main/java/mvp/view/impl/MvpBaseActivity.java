package mvp.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import mvp.presenter.MvpPresenter;
import mvp.view.MvpView;

/**
 * Created by xiaoling on 2017/2/16.
 */
public abstract class MvpBaseActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView<P>{
    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    /**
     * 设计要求必须绑定presenter,不管是否用到,以防未绑定presenter就使用的情况
     * @return
     */
    public abstract P bindPresenter();

    public P getPresenter() {
        if (presenter == null) {
            throw new NullPointerException("presenter未绑定,无法使用");
        }
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroyView();
        }
    }
}
