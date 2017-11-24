package com.cz.meizi.module.presenter;

import com.caozheng.xfastmvp.mvp.BasePresenter;
import com.cz.meizi.module.view.MainView;

/**
 * @author caozheng
 * Created time on 2017/11/24
 * description:
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view){
        attachView(view);
    }
}
