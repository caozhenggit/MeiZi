package com.cz.meizi.module.fragment;

import android.content.Context;
import android.view.View;

import com.cz.meizi.R;
import com.cz.meizi.base.AppFragment;
import com.cz.meizi.module.presenter.GifItemPresenter;
import com.cz.meizi.module.view.GifItemView;

/**
 * @author caozheng
 * @date 2017/11/25
 *
 * describe:
 */

public class GifFragment extends AppFragment<GifItemPresenter> implements GifItemView {

    @Override
    protected GifItemPresenter createPresenter() {
        return new GifItemPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_gif;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness() {

    }
}
