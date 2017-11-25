package com.cz.meizi.module.presenter;

import com.caozheng.xfastmvp.mvp.BasePresenter;
import com.cz.meizi.Api;
import com.cz.meizi.module.bean.MeiZiBean;
import com.cz.meizi.module.view.ImageItemView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */
public class ImageItemPresenter extends BasePresenter<ImageItemView> {

    public ImageItemPresenter(ImageItemView view){
        attachView(view);
    }

    public void getMeiZi(int page, int size){
        OkGo.<String>get(Api.URL_MEIZI + size + "/" + page)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        MeiZiBean bean = new Gson().fromJson(response.body(), MeiZiBean.class);

                        mView.getMeiZiDone(bean);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mView.getError("");
                    }
                });
    }
}
