package com.qxl.mvpproject.utils.rxjava;

import io.reactivex.disposables.Disposable;

/**
 * Created by xiaoling on 2017/2/20.
 * Observer生命周期管理
 */
public interface LifeManager {
    void addObserver(Disposable d);
}
