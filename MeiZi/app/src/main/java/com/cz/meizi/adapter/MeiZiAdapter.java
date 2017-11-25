package com.cz.meizi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cz.meizi.R;
import com.cz.meizi.module.bean.MeiZiBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */

public class MeiZiAdapter extends RecyclerArrayAdapter<MeiZiBean.ResultsBean> {

    public OnMyItemClickListener mOnItemClickListener;

    public MeiZiAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlsViewHolder(parent);
    }

    @Override
    public void OnBindViewHolder(final BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, holder);
                }
            }
        });
    }

    public interface OnMyItemClickListener {
        void onItemClick(int position, BaseViewHolder holder);
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public class GirlsViewHolder extends BaseViewHolder<MeiZiBean.ResultsBean> {

        private ImageView image;

        public GirlsViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_meizi);
            image = $(R.id.img_meizi);
        }

        @Override
        public void setData(MeiZiBean.ResultsBean bean) {
            super.setData(bean);
            Glide.with(getContext())
                    .load(bean.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(image);
        }
    }
}
