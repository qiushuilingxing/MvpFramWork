package mvp.presenter;

/**
 * Created by xiaoling on 2017/2/16.
 */
public interface MvpPresenter<V,M> {
    void attachView(V view);
    void destroyView();
    M bindModel();

}
