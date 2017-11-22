package com.cz.meizi.base;

import android.os.Bundle;

import com.caozheng.xfastmvp.mvp.BaseActivity;

/**
 * @author 10744
 * @date 2017/11/22
 * <p>
 * describe:
 */

public abstract class BaseAppActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppActivityManager.getInstance().addActivity(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AppActivityManager.getInstance().finishActivity();
    }
}
