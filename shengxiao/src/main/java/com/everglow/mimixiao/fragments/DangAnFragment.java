package com.everglow.mimixiao.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.everglow.mimixiao.DangAnActivity;
import com.everglow.mimixiao.R;
import com.everglow.mimixiao.RvAdapterOfNews;
import com.everglow.mimixiao.bean.DangAn;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by EverGlow on 2019/6/22 22:09
 */
public class DangAnFragment extends Fragment {
    List<DangAn.BaiyangBean.GuanJianZiBean> guanJianZi = new ArrayList();
    private static final String Tag = "DangAnFragment";
    private int index = 1;

    private RecyclerView lv;

    private SharedPreferences sp;

    private TextView tv00;

    private TextView tv01;

    private TextView tv02;

    private TextView tv03;

    private TextView tv04;

    private TextView tv05;

    private TextView tv06;

    private TextView tv07;

    private TextView tv08;

    private TextView tv09;

    private TextView tv10;

    private TextView tv11;

    private TextView tv12;

    private TextView tv13;

    private TextView tv14;

    private View view;

    private String xingzuo = "aries";
    private RvAdapterOfNews mRvAdapterOfNews;

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.view = paramLayoutInflater.inflate(R.layout.fragment_dang_an, paramViewGroup, false);
        this.lv = (RecyclerView) this.view.findViewById(R.id.lv);
        this.sp = getContext().getSharedPreferences("xingzuo", 0);
        this.xingzuo = this.sp.getString("xingzuo", "aries");
        this.index = this.sp.getInt("index", 1);
        this.tv00 = (TextView) this.view.findViewById(R.id.tv00);
        this.tv01 = (TextView) this.view.findViewById(R.id.tv01);
        this.tv02 = (TextView) this.view.findViewById(R.id.tv02);
        this.tv03 = (TextView) this.view.findViewById(R.id.tv03);
        this.tv04 = (TextView) this.view.findViewById(R.id.tv04);
        this.tv05 = (TextView) this.view.findViewById(R.id.tv05);
        this.tv06 = (TextView) this.view.findViewById(R.id.tv06);
        this.tv07 = (TextView) this.view.findViewById(R.id.tv07);
        this.tv08 = (TextView) this.view.findViewById(R.id.tv08);
        this.tv09 = (TextView) this.view.findViewById(R.id.tv09);
        this.tv10 = (TextView) this.view.findViewById(R.id.tv10);
        this.tv11 = (TextView) this.view.findViewById(R.id.tv11);
        this.tv12 = (TextView) this.view.findViewById(R.id.tv12);
        this.tv13 = (TextView) this.view.findViewById(R.id.tv13);
        this.tv14 = (TextView) this.view.findViewById(R.id.tv14);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.lv.setLayoutManager(linearLayoutManager);
        mRvAdapterOfNews = new RvAdapterOfNews(this.guanJianZi);
        this.lv.setAdapter(mRvAdapterOfNews);
        mRvAdapterOfNews.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
                DangAn.BaiyangBean.GuanJianZiBean guanJianZiBean = (DangAn.BaiyangBean.GuanJianZiBean) param1BaseQuickAdapter.getItem(param1Int);
                Intent intent = new Intent(DangAnFragment.this.getContext(), DangAnActivity.class);
                intent.putExtra("title", guanJianZiBean.getTitle());
                intent.putExtra("url", guanJianZiBean.getUrl());
                getActivity().startActivity(intent);
            }
        });

        return this.view;
    }


    private void refreshData() {
        this.sp = getContext().getSharedPreferences("xingzuo", 0);
        this.xingzuo = this.sp.getString("xingzuo", "aries");
        this.index = this.sp.getInt("index", 1);
        String url = "http://aliyun.zhanxingfang.com/zxf/m/xingzuo/" + this.index + "/" + this.xingzuo + ".txt";

        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                        e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                DangAn dangAn = new Gson().fromJson(json, DangAn.class);
                if (dangAn != null && dangAn.getBaiyang() != null) {
                    final List<DangAn.BaiyangBean.BiaoQianBean> list1 = dangAn.getBaiyang().getBiaoQian();
                    final List<DangAn.BaiyangBean.GuanJianZiBean> list2 = dangAn.getBaiyang().getGuanJianZi();
                    if (getActivity() != null)
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                    if (list2 != null && list2.size() > 0) {
                        guanJianZi.clear();
                        guanJianZi.addAll(list2);
                        mRvAdapterOfNews.notifyDataSetChanged();
                    }
                    tv00.setText(list1.get(0).getText());
                    tv01.setText(list1.get(1).getText());
                    tv02.setText(list1.get(2).getText());
                    tv03.setText(list1.get(3).getText());
                    tv04.setText(list1.get(4).getText());
                    tv05.setText(list1.get(5).getText());
                    tv06.setText(list1.get(6).getText());
                    tv07.setText(list1.get(7).getText());
                    tv08.setText(list1.get(8).getText());
                    tv09.setText(list1.get(9).getText());
                    tv10.setText(list1.get(10).getText());
                    tv11.setText(list1.get(11).getText());
                    tv12.setText(list1.get(12).getText());
                    tv13.setText(list1.get(13).getText());
                    tv14.setText(list1.get(14).getText());
                        }
                    });
                }

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

//        Log.e(Tag, "hidden==" + hidden);

        if (!hidden) {
            refreshData();
        }
    }
}
