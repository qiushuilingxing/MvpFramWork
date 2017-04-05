package com.qxl.mvpproject.apiServer;

import com.qxl.mvpproject.tab1.view.data.UploadBean;
import com.qxl.mvpproject.utils.Constant;
import com.qxl.mvpproject.utils.netUtils.ApiResult;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * tab1指的是第一个模块. tab1Api指第一个模块所有的网络请求接口
 *
 * Created by xiaoling on 2017/2/20.
 */
public interface Tab1Api {
    /**
     * 1修改昵称
     */
    interface ModifyNickNameApi {
        @FormUrlEncoded
        @POST(Constant.EDITNICK)
        Observable<ApiResult<Object>> commitNick(@Field("uid") String uid, @Field("nick") String nick);
    }
    /**
     * 上传文件
     */
    interface upload {
        @Multipart
        @POST(Constant.UPLOAD)
        Observable<ApiResult<UploadBean>> uploade(@Field("uid") String uid, @Field("upload") String filename, @PartMap() Map<String, RequestBody> map);
    }
}
