package mvp.model.impl;

import android.content.Context;

/**
 * 实际使用的类
 * Created by xiaoling on 2017/2/16.
 */
public abstract class BaseModel extends MvpBaseModel {
    private Context context;

    public BaseModel(Context context) {
        this.context = context;
    }
}
