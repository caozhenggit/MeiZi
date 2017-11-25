package com.cz.meizi.module.presenter;

import com.caozheng.xfastmvp.mvp.BasePresenter;
import com.cz.meizi.module.view.ImageItemView;
import com.cz.meizi.module.view.VideoItemView;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */
public class VideoItemPresenter extends BasePresenter<VideoItemView> {

    public VideoItemPresenter(VideoItemView view){
        attachView(view);
    }
}
