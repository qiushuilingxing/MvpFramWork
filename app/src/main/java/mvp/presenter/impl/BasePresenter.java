package mvp.presenter.impl;

import android.content.Context;

import com.qxl.mvpproject.utils.rxjava.LifeManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import mvp.model.MvpModel;
import mvp.view.MvpView;

/**
 * 实际使用类
 * Created by xiaoling on 2017/2/16.
 */
public abstract class BasePresenter<V extends MvpView,M extends MvpModel> extends MvpBasePresenter<V,M> implements LifeManager{
    /**
     * 管理Subscription的回收,防止内存泄漏
     */
    private CompositeDisposable disposables;

    public BasePresenter(Context context) {
        super(context);
        disposables = new CompositeDisposable();
    }

    public void addObserver(Disposable disposable){
        disposables.add(disposable);
    }

    @Override
    public void destroyView() {
        super.destroyView();
        disposables.dispose();
    }
}
