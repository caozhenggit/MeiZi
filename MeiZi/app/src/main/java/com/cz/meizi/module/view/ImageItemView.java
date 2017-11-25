package com.cz.meizi.module.view;

import com.caozheng.xfastmvp.mvp.BaseView;
import com.cz.meizi.module.bean.MeiZiBean;

/**
 * @author caozheng
 * @date 2017/11/25
 * <p>
 * describe:
 */

public interface ImageItemView extends BaseView {

    /**
     * 获取妹子图
     * @param meiZiBean
     */
    void getMeiZiDone(MeiZiBean meiZiBean);

    /**
     * 发生错误
     * @param msg
     */
    void getError(String msg);
}
