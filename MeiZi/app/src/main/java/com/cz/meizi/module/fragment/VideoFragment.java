package com.cz.meizi.module.fragment;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.cz.meizi.R;
import com.cz.meizi.adapter.ListNormalAdapter;
import com.cz.meizi.base.AppFragment;
import com.cz.meizi.module.presenter.VideoItemPresenter;
import com.cz.meizi.module.view.VideoItemView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import butterknife.BindView;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */

public class VideoFragment extends AppFragment<VideoItemPresenter> implements VideoItemView {

    @BindView(R.id.lv_video)
    ListView mLvVideo;

    ListNormalAdapter listNormalAdapter;

    private boolean isPause;

    @Override
    protected VideoItemPresenter createPresenter() {
        return new VideoItemPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void initView(View view) {
        init();
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
        isPause = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
        isPause = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        if (listNormalAdapter != null) {
            listNormalAdapter.onDestroy();
        }
    }

    private void init(){
        listNormalAdapter = new ListNormalAdapter(getActivity());
        mLvVideo.setAdapter(listNormalAdapter);

        mLvVideo.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int lastVisibleItem = firstVisibleItem + visibleItemCount;
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(ListNormalAdapter.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        GSYVideoPlayer.releaseAllVideos();
                        listNormalAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
