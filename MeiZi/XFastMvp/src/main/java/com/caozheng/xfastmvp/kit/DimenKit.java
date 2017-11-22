package com.caozheng.xfastmvp.kit;

import android.content.Context;

/**
 * @author caozheng
 * @date 2017/10/28
 * <p>
 * describe: 单位转换
 */
public class DimenKit {

    /**
     * dp转px
     * @param context
     * @param dp
     * @return
     */
    public static float dpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    /**
     * px转dp
     * @param context
     * @param px
     * @return
     */
    public static float pxToDp(Context context, float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    /**
     * dp转px int
     * @param context
     * @param dp
     * @return
     */
    public static int dpToPxInt(Context context, float dp) {
        return (int) (dpToPx(context, dp) + 0.5f);
    }

    /**
     * px转dp int
     * @param context
     * @param px
     * @return
     */
    public static int pxToDpCeilInt(Context context, float px) {
        return (int) (pxToDp(context, px) + 0.5f);
    }
}
