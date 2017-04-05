package com.qxl.mvpproject.tab1.model;

import android.content.Context;

import com.qxl.mvpproject.apiServer.Tab1Api;
import com.qxl.mvpproject.utils.netUtils.Api;
import com.qxl.mvpproject.utils.netUtils.ApiResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import mvp.model.impl.BaseModel;

/**
 * Created by xiaoling on 2017/2/20.
 */
public class MainActivityModel extends BaseModel {
    public MainActivityModel(Context context) {
        super(context);
    }

    public Observable<ApiResult<Object>> commitNickName(String uid, String nickName) {
        return  Api.getInstance().getRetrofit()
                .create(Tab1Api.ModifyNickNameApi.class)
                .commitNick(uid,nickName)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
