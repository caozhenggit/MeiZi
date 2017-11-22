package com.caozheng.xfastmvp.adapter.recyclerview.base;

/**
 * @author caozheng
 * @date 2017/10/22
 * <p>
 * describe:
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);
}
