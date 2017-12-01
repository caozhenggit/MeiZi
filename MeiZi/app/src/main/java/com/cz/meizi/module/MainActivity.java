package com.cz.meizi.module;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cz.meizi.adapter.MainPagerAdapter;
import com.cz.meizi.R;
import com.cz.meizi.base.BaseAppActivity;
import com.cz.meizi.module.fragment.GifFragment;
import com.cz.meizi.module.fragment.ImageFragment;
import com.cz.meizi.module.fragment.VideoFragment;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

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
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private List<Fragment> itemList = new ArrayList<Fragment>();

    @Override
    public void initParams(Intent intent) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        initFloatingActionsMenu();

        itemList.add(new ImageFragment());
        itemList.add(new VideoFragment());
        itemList.add(new GifFragment());

        FragmentManager mFragmentManager = getSupportFragmentManager();
        viewpager.setAdapter(new MainPagerAdapter(mFragmentManager, itemList));
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @OnClick({R.id.imv_menu, R.id.imv_about})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_menu:
                break;

            case R.id.imv_about:
                break;

            default:
                break;
        }
    }

    private void initFloatingActionsMenu(){
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);

        FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setIcon(R.mipmap.icon_image);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "click A", Toast.LENGTH_SHORT).show();
                menuMultipleActions.toggle();
            }
        });

        FloatingActionButton actionB = (FloatingActionButton) findViewById(R.id.action_b);
        actionB.setIcon(R.mipmap.icon_image);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "click B", Toast.LENGTH_SHORT).show();
                menuMultipleActions.toggle();
            }
        });

        FloatingActionButton actionC = (FloatingActionButton) findViewById(R.id.action_c);
        actionC.setIcon(R.mipmap.icon_image);
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "click C", Toast.LENGTH_SHORT).show();
                menuMultipleActions.toggle();
            }
        });

        FloatingActionButton actionD = (FloatingActionButton) findViewById(R.id.action_d);
        actionD.setIcon(R.mipmap.icon_menu);
        actionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuMultipleActions.toggle();
            }
        });
    }

}