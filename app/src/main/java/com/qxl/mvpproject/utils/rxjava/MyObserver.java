package com.qxl.mvpproject.utils.rxjava;

import android.util.Log;

import com.qxl.mvpproject.utils.netUtils.ApiException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by xiaoling on 2017/2/20.
 */
public abstract class MyObserver<T> implements Observer<T> {
    private String TAG = getClass().getSimpleName();
    private LifeManager lifeManager;

    public MyObserver(LifeManager lifeManager) {
        this.lifeManager = lifeManager;
    }

    public MyObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe: " );
        if (lifeManager != null) {
            lifeManager.addObserver(d);
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " );
        if (e instanceof ApiException) {
            onApiException((ApiException) e);
        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException || e instanceof ConnectException) {
            onNetException();
        } else {
            onUnknowException();
        }

    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: " );
    }

    /**
     * 网络连接异常
     */
    public void onNetException() {
        Log.e(TAG, "onNetException: " );

    }

    /**
     * 服务器返回的异常,如code != 200. 有些异常可以在此方法中统一处理.如: 假设客户端和服务器协议code = 888时需要强制更新.
     */
    public void onApiException(ApiException exception) {
        Log.e(TAG, "onApiException: " );
        if (exception.getCode() == 888) {
            //TODO 强制更新
        }

    }

    public void onUnknowException() {
        Log.e(TAG, "onUnknowException: ");

    }
}
