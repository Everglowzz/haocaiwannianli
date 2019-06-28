package com.everglow.mimixiao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by EverGlow on 2019/6/22 20:26
 */

public class JieMentFragment extends Fragment {
    private int index;

    private String title;

    private WrapContentViewPager vp;

    public JieMentFragment() {}

    @SuppressLint({"ValidFragment"})
    public JieMentFragment(String paramString, WrapContentViewPager paramWrapContentViewPager, int paramInt) {
        this.title = paramString;
        this.vp = paramWrapContentViewPager;
        this.index = paramInt;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = paramLayoutInflater.inflate(R.layout.fragment_jie_ment, paramViewGroup, false);
        this.vp.setObjectForPosition(view, this.index);
        ((TextView)view.findViewById(R.id.tv)).setText(this.title);
        return view;
    }
}
