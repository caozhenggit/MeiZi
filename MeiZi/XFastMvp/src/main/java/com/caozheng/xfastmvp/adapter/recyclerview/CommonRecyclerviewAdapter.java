package com.caozheng.xfastmvp.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;

import com.caozheng.xfastmvp.adapter.recyclerview.base.ItemViewDelegate;
import com.caozheng.xfastmvp.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * @author caozheng
 * @date 2017/10/22
 *
 * describe:
 */
public abstract class CommonRecyclerviewAdapter<T> extends CommonRecyclerviewMultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonRecyclerviewAdapter(final Context context, final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                CommonRecyclerviewAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);
}
