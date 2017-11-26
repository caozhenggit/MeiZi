package com.cz.meizi.module;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cz.meizi.R;
import com.cz.meizi.adapter.MeiZiAdapter;
import com.cz.meizi.adapter.MeiZiDetailAdapter;
import com.cz.meizi.base.BaseAppActivity;
import com.cz.meizi.module.bean.MeiZiBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author caozheng
 * @date 2017/11/26
 * <p>
 * describe:
 */

public class MeiZiDetailActivity extends BaseAppActivity {

    @BindView(R.id.viewpager_meizi)
    ViewPager viewpagerMeizi;

    private ArrayList<MeiZiBean.ResultsBean> mList;
    private int current = 0;

    @Override
    public void initParams(Intent intent) {
        mList = intent.getParcelableArrayListExtra("meizi");
        current = intent.getIntExtra("current", 0);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_meizi_detail;
    }

    @Override
    public void initView(View view) {
        initViewPager();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void initViewPager(){
        viewpagerMeizi.setAdapter(new MeiZiDetailAdapter(mActivity, mList));
        viewpagerMeizi.setCurrentItem(current);
    }
}
