package mvp.presenter.impl;

import android.content.Context;

import mvp.model.MvpModel;
import mvp.model.impl.MvpBaseModel;
import mvp.presenter.MvpPresenter;
import mvp.view.MvpView;

/**
 * Created by xiaoling on 2017/2/16.
 */
public abstract class MvpBasePresenter<V extends MvpView,M extends MvpModel> implements MvpPresenter<V,M> {
    private V view;
    private M model;
    private Context context;

    public MvpBasePresenter(Context context) {
        this.context = context;
        this.model = bindModel();
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void destroyView() {
        if (view != null) {
            view = null;
        }
    }

    /**
     * 视图是否被销毁
     * @return
     */
    public boolean isDestroyView(){
        return view == null;
    }

    /**
     * 设计要求model必须被重写,所以写成抽象方法要求子类必须实现
     * @return
     */
    public abstract M bindModel();

    public V getView() {
        return view;
    }

    public M getModel() {
        if (model == null) {
            throw new NullPointerException("model未绑定,无法使用");
        }
        return model;
    }

    public Context getContext() {
        return context;
    }
}
