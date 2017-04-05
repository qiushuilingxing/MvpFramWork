package com.qxl.mvpproject.utils.netUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaoling on 2017/2/20.
 */
public class Api {
    private final String BASE_URL = "http://101.200.146.232:8080/GuiChong/";
    public Retrofit retrofit;
    public static Api instance;

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    private Api(){
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(interceptor) //添加log拦截器
//                .addInterceptor(chain -> { //添加请求头信息
//                    Request request = chain.request();
//                    Request.Builder builder1 = request.newBuilder();
//                    //这里添加请求头信息
////                    Request build = builder1.addHeader("apikey", "3c00d3dcb492f7098699aae47b08c468").build();
////                    Request build = builder1.addHeader("apikey", "ac7c302dc489a69082cbee6a89e3646c").build();
//                    builder1.addHeader("Req_devId", MyUtils.getUUid(MyApp.appContext));
//                    if (!TextUtils.isEmpty(MyUtils.getDeviceToken())) {
//                        builder1.addHeader("Req_devicetoken", MyUtils.getDeviceToken());
//                    }
//                    if (!TextUtils.isEmpty(SingleUser.getInstance().getLoginToken())) {
//                        builder1.addHeader("Reg_logintoken", SingleUser.getInstance().getLoginToken());
//                    }
//                    Request build = builder1.build();
//                    Response response = chain.proceed(build);
//                    //这里获取响应头信息
//                    String req_devicetoken = response.header("Req_devicetoken");
//                    if (!TextUtils.isEmpty(req_devicetoken)) {
//                        MyUtils.setDeviceToken(req_devicetoken);
//                    }
//                    String reg_logintoken = response.header("Reg_logintoken");
//                    if (!TextUtils.isEmpty(reg_logintoken)) {
//                        SingleUser.getInstance().setLoginToken(reg_logintoken);
//                    }
//
//
//                    return response;
//                })

                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(io.reactivex.schedulers.Schedulers.io()))
                .addConverterFactory(MyRetrofitConverterFactory.create())
                .client(client)
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
