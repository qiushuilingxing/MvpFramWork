package com.qxl.mvpproject.tab1.presenter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.qxl.mvpproject.tab1.model.MainActivityModel;
import com.qxl.mvpproject.tab1.view.activity.MainActivity;
import com.qxl.mvpproject.tab1.view.activity.MyRecyclerViewActivity;
import com.qxl.mvpproject.tab1.view.activity.MyTabLayoutActivity;
import com.qxl.mvpproject.utils.netUtils.ApiException;
import com.qxl.mvpproject.utils.netUtils.ApiResult;
import com.qxl.mvpproject.utils.rxjava.MyObserver;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import mvp.presenter.impl.BasePresenter;
import mvp.view.impl.BaseActivity;

/**
 * Created by xiaoling on 2017/2/16.
 */
public class MainActivityPresenter extends BasePresenter<MainActivity, MainActivityModel> {

    private String TAG = getClass().getSimpleName();

    public MainActivityPresenter(Context context) {
        super(context);
    }

    @Override
    public MainActivityModel bindModel() {
        return new MainActivityModel(getContext());//如果有对应的model,在第一行泛型中写上具体model
    }

    /**
     * 演示Rxbinding监听控件
     *
     * @param context
     * @param view    被监听控件
     */
    public void showRxBinding(BaseActivity context, TextView view) {
//        RxTextView.textChanges(view)
//                .compose(context.bindToLifecycle())
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .subscribe(s -> Toast.makeText(context, s.toString(),Toast.LENGTH_SHORT).show());
    }

    /**
     * 演示Rxpermition管理权限,可以适配6.0以上版本
     *
     * @param context
     */
    public void showRxPermission(BaseActivity context) {
//        RxPermissions.getInstance(context)
//                .request(Manifest.permission.CALL_PHONE)
//                .compose(context.bindToLifecycle())
//                .subscribe(ok -> {
//                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                        doCallPhone(context);
//                    }else {
//                        showToast("打电话权限被拒绝,请在设置中对MvpProject打开权限");
//                    }
//                }, err->{
//                   showToast( "出错啦");
//                });
    }

    /**
     * 执行打电话
     *
     * @param context
     */
    private void doCallPhone(Context context) {
        Uri uri = Uri.parse("tel:" + 10086);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        context.startActivity(intent);
    }

    /**
     * 演示RecycerView和万能adapter
     *
     * @param context
     */
    public void showRecyclerViewAndAdapterLib(BaseActivity context) {
        MyRecyclerViewActivity.startToMyRecyclerViewActivity(context);
    }

    /**
     * 演示tabLayout + viewPager
     *
     * @param context
     */
    public void showTabLayout(Context context) {
        Intent intent = new Intent(context, MyTabLayoutActivity.class);
        context.startActivity(intent);
    }

    /**
     * 演示网络请求
     */
    public void netRequest() {
        //显示progressBar, 让用户知道正在等待页面数据的加载
        showToast("开始网络请求");
        getModel().commitNickName("10007", "xiaoling")
                .subscribe(getMyCommitNickNameObserver());

    }

    private Observer<? super ApiResult<Object>> getMyCommitNickNameObserver() {
        return new MyObserver<ApiResult<Object>>(this) {
            @Override
            public void onNext(ApiResult<Object> value) {
                //昵称提交成功
                showToast("昵称提交成功");
            }

            @Override
            public void onNetException() {
                super.onNetException();
                //网络连接出错
                showToast("网络连接出错");
            }

            @Override
            public void onApiException(ApiException exception) {
                super.onApiException(exception);
                //服务器返回结果code != 200
                showToast("服务器返回结果code != 200");
            }

            @Override
            public void onUnknowException() {
                super.onUnknowException();
                //未知错误
                showToast("未知错误");
            }
        };
    }

    /**
     * 弹吐司
     *
     * @param message
     */
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
