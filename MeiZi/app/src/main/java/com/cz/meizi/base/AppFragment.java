package com.cz.meizi.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.caozheng.xfastmvp.mvp.BaseFragment;
import com.caozheng.xfastmvp.mvp.BasePresenter;

/**
 * @author caozheng
 * @date 2017/10/28
 *
 * describe:
 */
public abstract class AppFragment<P extends BasePresenter> extends BaseFragment {
    protected P mPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();

        doBusiness();
    }

    protected abstract P createPresenter();

    /**
     * 业务操作
     */
    public abstract void doBusiness();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
