package com.everglow.mimixiao.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.everglow.mimixiao.R;
import com.everglow.mimixiao.WrapContentViewPager;
import com.everglow.mimixiao.bean.YunShiBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by EverGlow on 2019/6/22 21:21
 */
public class BenYueFragment extends Fragment {
    private String index = "";
    private String xingzuo = "aries";

    private TextView tv00;

    private TextView tv01;

    private TextView tv02;

    private TextView tv03;

    private TextView tv04;

    

    private TextView tv_00;

    private TextView tv_01;

    private TextView tv_02;

    private TextView tv_03;

    private TextView tv_04;

    private TextView tv_05;

    private TextView tv_06;

    private WrapContentViewPager vp;
    private List<YunShiBean.DataBean.UlBean> mUl;
    private List<YunShiBean.DataBean.ContBean> mCont;

    public static BenYueFragment getInstance(String paramString, WrapContentViewPager paramWrapContentViewPager) {
        BenYueFragment yunShiFragment = new BenYueFragment();
        yunShiFragment.index = paramString;
        yunShiFragment.vp = paramWrapContentViewPager;
        return yunShiFragment;
    }

    private void init(View paramView) {
        this.vp.setObjectForPosition(paramView, Integer.parseInt(this.index));
        this.tv00 = (TextView)paramView.findViewById(R.id.tv00);
        this.tv01 = (TextView)paramView.findViewById(R.id.tv01);
        this.tv02 = (TextView)paramView.findViewById(R.id.tv02);
        this.tv03 = (TextView)paramView.findViewById(R.id.tv03);
        this.tv04 = (TextView)paramView.findViewById(R.id.tv04);
        this.tv_00 = (TextView)paramView.findViewById(R.id.tv_00);
        this.tv_01 = (TextView)paramView.findViewById(R.id.tv_01);
        this.tv_02 = (TextView)paramView.findViewById(R.id.tv_02);
        this.tv_03 = (TextView)paramView.findViewById(R.id.tv_03);
        this.tv_04 = (TextView)paramView.findViewById(R.id.tv_04);
        this.tv_05 = (TextView)paramView.findViewById(R.id.tv_05);
        this.tv_06 = (TextView)paramView.findViewById(R.id.tv_06);
    
        initData();
    }
    private void refreshUi() {
        tv00.setText(getXing(mUl.get(0).getValue())+"星");
        tv01.setText(getXing(mUl.get(1).getValue())+"星");
        tv02.setText(getXing(mUl.get(2).getValue())+"星");
        tv03.setText(getXing(mUl.get(3).getValue())+"星");
        tv04.setText(mUl.get(4).getValue());
        tv_00.setText(mCont.get(0).getValue());
        tv_01.setText(mCont.get(1).getValue());
        tv_02.setText(mCont.get(2).getValue());
        tv_03.setText(mCont.get(3).getValue());
        tv_04.setText(mCont.get(4).getValue());
        tv_05.setText(mCont.get(5).getValue());
        tv_06.setText(mCont.get(6).getValue());

    }
    private void initData() {
        xingzuo = getContext().getSharedPreferences("xingzuo", 0).getString("xingzuo", "aries");
        String url = "http://aliyun.zhanxingfang.com/zxf/appclient/fortune.php";

        RequestBody requestBody = new FormBody.Builder()
                .add("category", index)
                .add("xingzuo", xingzuo)
                        .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                YunShiBean yunShiBean = (YunShiBean)(new Gson()).fromJson(json, YunShiBean.class);
                mUl = yunShiBean.getData().getUl();
                mCont = yunShiBean.getData().getCont();
                if (getActivity() != null)
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                refreshUi();
                    }
                });
            }
        });
    }

//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        if (!hidden) {
//            initData();
//        }
//    }


    public int getXing(String paramString) { return (int)(10.0D * Double.parseDouble(paramString) / 2.0D); }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = paramLayoutInflater.inflate(R.layout.fragment_ben_yue, paramViewGroup, false);
        init(view);
        return view;
    }
}
