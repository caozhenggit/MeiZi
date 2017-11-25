package com.cz.meizi.module.presenter;

import com.caozheng.xfastmvp.mvp.BasePresenter;
import com.cz.meizi.module.view.GifItemView;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */
public class GifItemPresenter extends BasePresenter<GifItemView> {

    public GifItemPresenter(GifItemView view){
        attachView(view);
    }
}
