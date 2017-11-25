package com.cz.meizi.module.fragment;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.cz.meizi.adapter.MeiZiAdapter;
import com.cz.meizi.R;
import com.cz.meizi.base.AppFragment;
import com.cz.meizi.module.bean.MeiZiBean;
import com.cz.meizi.module.presenter.ImageItemPresenter;
import com.cz.meizi.module.view.ImageItemView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */

public class ImageFragment extends AppFragment<ImageItemPresenter> implements ImageItemView, RecyclerArrayAdapter.OnLoadMoreListener{

    @BindView(R.id.recycler_view_meizi)
    EasyRecyclerView recyclerViewMeizi;

    private int page = 1;
    private int size = 20;

    private MeiZiAdapter mAdapter;
    private List<MeiZiBean.ResultsBean> mMeiZiList = new ArrayList<MeiZiBean.ResultsBean>();

    @Override
    protected ImageItemPresenter createPresenter() {
        return new ImageItemPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_image;
    }

    @Override
    public void initView(View view) {
        initRecyclerView();
    }

    @Override
    public void doBusiness() {
        mPresenter.getMeiZi(page, size);
    }

    @Override
    public void getMeiZiDone(MeiZiBean meiZiBean) {
        if (meiZiBean.isError()) {
            recyclerViewMeizi.showError();
        } else {
            mMeiZiList.addAll(meiZiBean.getResults());
            page++;
        }

        if (mAdapter != null) {
            mAdapter.addAll(meiZiBean.getResults());
        }
    }

    @Override
    public void getError(String msg) {
        recyclerViewMeizi.showError();
    }

    @Override
    public void onLoadMore() {
        mPresenter.getMeiZi(page, size);
    }

    private void initRecyclerView(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewMeizi.setLayoutManager(staggeredGridLayoutManager);

        mAdapter = new MeiZiAdapter(getActivity());
        recyclerViewMeizi.setAdapterWithProgress(mAdapter);

        mAdapter.setMore(R.layout.load_more_layout, this);
        mAdapter.setNoMore(R.layout.no_more_layout);
        mAdapter.setError(R.layout.error_layout);
    }
}
