package com.cz.meizi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cz.meizi.R;
import com.cz.meizi.module.bean.MeiZiBean;

import java.util.ArrayList;

/**
 * @author 10744
 * @date 2017/11/26
 * <p>
 * describe:
 */

public class MeiZiDetailAdapter extends PagerAdapter {

    private ArrayList<MeiZiBean.ResultsBean> mList;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private View mCurrentView;

    public MeiZiDetailAdapter(Context context, ArrayList<MeiZiBean.ResultsBean> list) {
        mContext = context;
        mList = list;
        layoutInflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentView = (View) object;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        final String imageUrl = mList.get(position).getUrl();
        View view = layoutInflater.inflate(R.layout.item_meizi_detail, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imv_meizi);
        Glide.with(mContext)
                .load(imageUrl)
                .thumbnail(0.2f)
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
