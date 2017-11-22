package com.caozheng.xfastmvp.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;

import com.caozheng.xfastmvp.XFastConf;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * @author caozheng
 * @date 2017/10/28
 *
 * describe:
 */
public abstract class BaseActivity extends AppCompatActivity {

    public Activity mActivity;

    private SweetAlertDialog pDialog;

    /** 是否沉浸状态栏 **/
    private boolean isSetStatusBar = true;
    /** 是否允许全屏 **/
    private boolean mAllowFullScreen = true;
    /** 是否禁止旋转屏幕 **/
    private boolean isAllowScreenRotate = false;
    /** 当前Activity渲染的视图View **/
    private View mContextView = null;

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $Log(TAG + "-->onCreate()");
        try {
            Bundle bundle = getIntent().getExtras();
            initParams(bundle);

            mContextView = LayoutInflater.from(this)
                    .inflate(bindLayout(), null);

            mActivity = this;

            if (mAllowFullScreen) {
                this.getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
            }

            if (isSetStatusBar) {
                steepStatusBar();
            }

            setContentView(mContextView);

            ButterKnife.bind(this);

            if (isAllowScreenRotate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            initView(mContextView);

            doBusiness(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 沉浸状态栏
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 初始化Bundle参数
     *
     * @param parms
     */
    public abstract void initParams(Bundle parms);

    /**
     * 绑定布局
     *
     * @return
     */
    public abstract int bindLayout();

    /**
     * 初始化控件
     *
     * @param view
     */
    public abstract void initView(final View view);

    /**
     * 业务操作
     *
     * @param mContext
     */
    public abstract void doBusiness(Context mContext);

    @Override
    protected void onResume() {
        super.onResume();
        $Log(TAG + "--->onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        $Log(TAG + "--->onDestroy()");
    }

    /**
     * 页面跳转
     *
     * @param cz
     */
    public void startActivity(Class<?> cz) {
        startActivity(cz, null);
    }

    /**
     * 携带数据的页面跳转
     *
     * @param cz
     * @param bundle
     */
    public void startActivity(Class<?> cz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    /**
     * 含有Bundle通过Class打开编辑界面
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 日志输出
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if(XFastConf.LOG){
            Log.d(TAG, msg);
        }
    }

    /**
     * 是否允许全屏
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    /**
     * 是否设置沉浸状态栏
     *
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    /**
     * 是否允许屏幕旋转
     *
     * @param isAllowScreenRotate
     */
    public void setScreenRoate(boolean isAllowScreenRotate) {
        this.isAllowScreenRotate = isAllowScreenRotate;
    }

    /**
     * 防止快速点击
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * 显示网络错误
     */
    public void showNetError(){

    }

    /**
     * 显示加载动画
     */
    public SweetAlertDialog showLoading(){
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE).setTitleText("Loading");
        pDialog.getProgressHelper().setBarColor(mActivity.getResources().getColor(android.R.color.holo_blue_bright));
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.show();
        return pDialog;
    }

    /**
     * 显示加载动画
     *
     * @param text
     * @return
     */
    public SweetAlertDialog showLoading(String text){
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE).setTitleText(text);
        pDialog.getProgressHelper().setBarColor(mActivity.getResources().getColor(android.R.color.holo_blue_bright));
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.show();
        return pDialog;
    }

    /**
     * 隐藏加载
     */
    public void hideLoading(){
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    /**
     * 显示键盘
     */
    public void showKeyBoard() {
        InputMethodManager imm = (InputMethodManager) mActivity.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethod.SHOW_FORCED);
    }

    /**
     * 隐藏键盘
     */
    public boolean hideKeyBoard() {
        final InputMethodManager imm = (InputMethodManager) mActivity.getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.hideSoftInputFromWindow(mActivity.findViewById(android.R.id.content)
                .getWindowToken(), 0);
    }
}
