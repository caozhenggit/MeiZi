package com.cz.meizi.base;

import android.os.Bundle;

import com.caozheng.xfastmvp.mvp.BaseActivity;
import com.caozheng.xfastmvp.mvp.BasePresenter;

/**
 * @author caozheng
 * @date 2017/10/28
 *
 * describe:
 */
public abstract class AppActivity<P extends BasePresenter> extends BaseActivity {
    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onCreate(savedInstanceState);

        AppActivityManager.getInstance().addActivity(this);
    }

    public abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        AppActivityManager.getInstance().finishActivity();
    }
}
