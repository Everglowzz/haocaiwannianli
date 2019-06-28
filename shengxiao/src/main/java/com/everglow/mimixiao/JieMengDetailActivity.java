package com.everglow.mimixiao;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.everglow.mimixiao.bean.JieMentDetail;
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

public class JieMengDetailActivity extends AppCompatActivity {
    private MyFragmentAdapter adapter;

    private List<Fragment> fragmentList = new ArrayList();

    private List<String> DataList = new ArrayList();

    private TabLayout tl;

    private TextView tv;

    private WrapContentViewPager vp;
    private int mI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_meng_detail);

        tl = (TabLayout) findViewById(R.id.tl);
        vp = (WrapContentViewPager) findViewById(R.id.vp);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText("周公解梦");
        mI = getIntent().getIntExtra("id", 1);
        requestDate();
    }

    private void requestDate() {

        String url = "http://aliyun.zhanxingfang.com/zxf/appclient/zhougong_new.php?act=show_content&id=" + mI;


        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                JieMentDetail jieMentDetail = new Gson().fromJson(json, JieMentDetail.class);
                List<JieMentDetail.DataBean.ContentBean> list = jieMentDetail.getData().getContent();
                for (byte b = 0; b < list.size(); b++) {
                    fragmentList.add(new JieMentFragment(list.get(b).getContent(), vp, b));
                    DataList.add(list.get(b).getTitle());
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        runUi();
                        runUi();
                    }
                });


            }
        });
    }

    private void runUi() {
        MyFragmentAdapter fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());

        vp.setAdapter(fragmentAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class MyFragmentAdapter extends FragmentStatePagerAdapter {
        public MyFragmentAdapter(FragmentManager param1FragmentManager) {
            super(param1FragmentManager);
        }

        public int getCount() {
            return fragmentList.size();
        }

        public Fragment getItem(int param1Int) {
            return fragmentList.get(param1Int);
        }

        public int getItemPosition(Object param1Object) {
            return -2;
        }

        public CharSequence getPageTitle(int param1Int) {
            return DataList.get(param1Int);
        }
    }
}
