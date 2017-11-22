package com.caozheng.xfastmvp.mvp;

/**
 * @author caozheng
 * @date 2017/10/28
 *
 * describe:
 */
public class BasePresenter<V> {
    public V mView;

    public void attachView(V mView) {
        this.mView = mView;
    }

    public void detachView() {
        this.mView = null;
    }
}
