package com.everglow.mimixiao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everglow.mimixiao.fragments.AiQingFragment;
import com.everglow.mimixiao.fragments.BenNianFragment;
import com.everglow.mimixiao.fragments.BenYueFragment;
import com.everglow.mimixiao.fragments.BenZhouFragment;
import com.everglow.mimixiao.fragments.YunShiFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 21:12
 */
public class XingZuoYunShiFragment extends Fragment {
    private MyFragmentAdapter adapter;

    private List<Fragment> fragmentList = new ArrayList();

    private List<String> list = new ArrayList();

    private TabLayout tl;

    private View view;

    private WrapContentViewPager vp;
    private String Tag = "XingZuoYunShiFragment";

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.view = paramLayoutInflater.inflate(R.layout.fragment_xing_zuo_yun_shi, paramViewGroup, false);
        this.tl = (TabLayout) this.view.findViewById(R.id.tl);
        this.vp = (WrapContentViewPager) this.view.findViewById(R.id.vp);

        return this.view;
    }


    private void refreshData() {
        YunShiFragment yunShiFragment1 = YunShiFragment.getInstance("0", this.vp);
        YunShiFragment yunShiFragment2 = YunShiFragment.getInstance("1", this.vp);
        BenZhouFragment benZhouFragment = BenZhouFragment.getInstance("2", this.vp);
        BenYueFragment benYueFragment = BenYueFragment.getInstance("3", this.vp);
        BenNianFragment benNianFragment = BenNianFragment.getInstance("4", this.vp);
        AiQingFragment aiQingFragment = AiQingFragment.getInstance("5", this.vp);
        this.fragmentList.add(yunShiFragment1);
        this.fragmentList.add(yunShiFragment2);
        this.fragmentList.add(benZhouFragment);
        this.fragmentList.add(benYueFragment);
        this.fragmentList.add(benNianFragment);
        this.fragmentList.add(aiQingFragment);
        this.list.add("今日");
        this.list.add("明日");
        this.list.add("本周");
        this.list.add("本月");
        this.list.add("本年");
        this.list.add("爱情");
        this.adapter = new MyFragmentAdapter(getChildFragmentManager());
        this.vp.setAdapter(this.adapter);
        this.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int param1Int) {

            }

            public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {

            }

            public void onPageSelected(int param1Int) {

                XingZuoYunShiFragment.this.vp.resetHeight(param1Int);
            }
        });
        this.vp.resetHeight(0);
        this.tl.setTabMode(1);
        this.tl.setupWithViewPager(this.vp);
    }

    class MyFragmentAdapter extends FragmentStatePagerAdapter {
        public MyFragmentAdapter(FragmentManager param1FragmentManager) {
            super(param1FragmentManager);
        }

        public int getCount() {
            return XingZuoYunShiFragment.this.fragmentList.size();
        }

        public Fragment getItem(int param1Int) {
            return (Fragment) XingZuoYunShiFragment.this.fragmentList.get(param1Int);
        }

        public int getItemPosition(Object param1Object) {
            return -2;
        }

        public CharSequence getPageTitle(int param1Int) {
            return (CharSequence) XingZuoYunShiFragment.this.list.get(param1Int);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshData();
    }


    public void notifyData() {
        fragmentList.clear();
        YunShiFragment yunShiFragment1 = YunShiFragment.getInstance("0", this.vp);
        YunShiFragment yunShiFragment2 = YunShiFragment.getInstance("1", this.vp);
        BenZhouFragment benZhouFragment = BenZhouFragment.getInstance("2", this.vp);
        BenYueFragment benYueFragment = BenYueFragment.getInstance("3", this.vp);
        BenNianFragment benNianFragment = BenNianFragment.getInstance("4", this.vp);
        AiQingFragment aiQingFragment = AiQingFragment.getInstance("5", this.vp);
        this.fragmentList.add(yunShiFragment1);
        this.fragmentList.add(yunShiFragment2);
        this.fragmentList.add(benZhouFragment);
        this.fragmentList.add(benYueFragment);
        this.fragmentList.add(benNianFragment);
        this.fragmentList.add(aiQingFragment);
        adapter.notifyDataSetChanged();
    }
}