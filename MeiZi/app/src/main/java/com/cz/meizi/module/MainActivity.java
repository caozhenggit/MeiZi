package com.cz.meizi.module;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.cz.meizi.adapter.MainPagerAdapter;
import com.cz.meizi.R;
import com.cz.meizi.base.BaseAppActivity;
import com.cz.meizi.module.fragment.GifFragment;
import com.cz.meizi.module.fragment.ImageFragment;
import com.cz.meizi.module.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author caozheng
 * @data 2017/11/22
 */
public class MainActivity extends BaseAppActivity {

    @BindView(R.id.imv_menu)
    ImageView imvMenu;
    @BindView(R.id.imv_about)
    ImageView imvAbout;
    @BindView(R.id.imv_image)
    ImageView imvImage;
    @BindView(R.id.imv_video)
    ImageView imvVideo;
    @BindView(R.id.imv_gif)
    ImageView imvGif;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private List<Fragment> itemList = new ArrayList<Fragment>();

    @Override
    public void initParams(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        itemList.add(new ImageFragment());
        itemList.add(new VideoFragment());
        itemList.add(new GifFragment());

        FragmentManager mFragmentManager = getSupportFragmentManager();
        viewpager.setAdapter(new MainPagerAdapter(mFragmentManager, itemList));

        viewPagerPageChangeListener();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @OnClick({R.id.imv_menu, R.id.imv_about, R.id.imv_image, R.id.imv_video, R.id.imv_gif})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_menu:
                break;

            case R.id.imv_about:
                break;

            case R.id.imv_image:
                setSelectItem(0);
                viewpager.setCurrentItem(0);
                break;

            case R.id.imv_video:
                setSelectItem(1);
                viewpager.setCurrentItem(1);
                break;

            case R.id.imv_gif:
                setSelectItem(2);
                viewpager.setCurrentItem(2);
                break;

            default:
                break;
        }
    }

    private void viewPagerPageChangeListener(){
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSelectItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setSelectItem(int position){
        switch (position){
            case 0:
                imvImage.setImageResource(R.mipmap.icon_image);
                imvVideo.setImageResource(R.mipmap.icon_video_normal);
                imvGif.setImageResource(R.mipmap.icon_gif_normal);
                break;

            case 1:
                imvImage.setImageResource(R.mipmap.icon_image_normal);
                imvVideo.setImageResource(R.mipmap.icon_video);
                imvGif.setImageResource(R.mipmap.icon_gif_normal);
                break;

            case 2:
                imvImage.setImageResource(R.mipmap.icon_image_normal);
                imvVideo.setImageResource(R.mipmap.icon_video_normal);
                imvGif.setImageResource(R.mipmap.icon_gif);
                break;

            default:
                $Log("no exist item:" + position);
                break;
        }
    }
}