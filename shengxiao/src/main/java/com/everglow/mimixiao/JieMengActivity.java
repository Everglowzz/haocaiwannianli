package com.everglow.mimixiao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.everglow.mimixiao.bean.JieMeng;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class JieMengActivity extends AppCompatActivity {
    private List<JieMeng.DataBean> data;

    private GridView gv;

    List<JieQi> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_meng);
        gv = findViewById(R.id.gv);
        requestDate();
    }

    private void requestDate() {

        String url = "http://aliyun.zhanxingfang.com/zxf/appclient/zhougong.php?act=get_cats";

        RequestBody requestBody = new FormBody.Builder()
                .add("act", "get_cats").
                        build();
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
                JieMeng jieMeng = (new Gson()).fromJson(json, JieMeng.class);
                data = jieMeng.getData();
                list.add(new JieQi(R.drawable.zgjm_icon1,data.get(0).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon2,data.get(1).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon3,data.get(2).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon4,data.get(3).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon5,data.get(4).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon6,data.get(5).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon7,data.get(6).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon8,data.get(7).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon9,data.get(8).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon10,data.get(9).getName()));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new MyAdapter());
                    }
                });
               
            }
        });
        
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(JieMengActivity.this, JieMentSouSuoActivity.class);
                intent.putExtra("id", data.get(i).getCid());
                JieMengActivity.this.startActivity(intent);
            }
        });
    }
    class MyAdapter extends BaseAdapter {
        public int getCount() {
            return list.size();
        }

        public JieQi getItem(int param1Int) {
            return list.get(param1Int);
        }

        public long getItemId(int param1Int) {
            return param1Int;
        }

        @Override
        public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
            param1View = LayoutInflater.from(JieMengActivity.this).inflate(R.layout.jieqi_item, param1ViewGroup, false);
            TextView textView = (TextView) param1View.findViewById(R.id.name);
            ImageView imageView = (ImageView) param1View.findViewById(R.id.img);
            textView.setText(list.get(param1Int).getName());
            imageView.setImageResource(list.get(param1Int).getImg());
            return param1View;
        }
    }
}
