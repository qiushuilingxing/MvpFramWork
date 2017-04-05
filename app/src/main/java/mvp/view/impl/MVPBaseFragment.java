package mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvp.presenter.MvpPresenter;
import mvp.view.MvpView;

/**
 * Created by xiaoling on 2017/2/16.
 */
public abstract class MVPBaseFragment<P extends MvpPresenter> extends Fragment implements MvpView<P> {
    private P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
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
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroyView();
        }
    }
}
