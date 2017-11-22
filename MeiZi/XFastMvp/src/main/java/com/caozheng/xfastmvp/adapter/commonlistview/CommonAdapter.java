package com.caozheng.xfastmvp.adapter.commonlistview;

import android.content.Context;

import com.caozheng.xfastmvp.adapter.commonlistview.base.ItemViewDelegate;

import java.util.List;

/**
 * @author caozheng
 * @date 2017/10/22
 *
 * describe:
 */
public abstract class CommonAdapter<T> extends CommonMultiItemTypeAdapter<T> {

    public CommonAdapter(Context context, final int layoutId, List<T> datas) {
        super(context, datas);

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder viewHolder, T item, int position);

}
