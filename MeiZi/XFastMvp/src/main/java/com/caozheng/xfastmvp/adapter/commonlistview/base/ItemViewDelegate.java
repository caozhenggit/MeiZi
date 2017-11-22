package com.caozheng.xfastmvp.adapter.commonlistview.base;

import com.caozheng.xfastmvp.adapter.commonlistview.ViewHolder;

/**
 * @author caozheng
 * @date 2017/10/22
 *
 * describe:
 */
public interface ItemViewDelegate<T> {

    public abstract int getItemViewLayoutId();

    public abstract boolean isForViewType(T item, int position);

    public abstract void convert(ViewHolder holder, T t, int position);

}
