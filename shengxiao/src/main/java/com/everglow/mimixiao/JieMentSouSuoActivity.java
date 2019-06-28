package com.everglow.mimixiao;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.everglow.mimixiao.bean.JieMengDetail;
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

public class JieMentSouSuoActivity extends AppCompatActivity implements AbsListView.OnScrollListener {
    List<JieMengDetail.DataBean> data;

    private EditText editText;

    private int index = 1;

    private int lastVisibleIndex;

    private List<JieMengDetail.DataBean> list1 = new ArrayList();

    private ListView listView;

    private List<String> lists = new ArrayList();

    private ProgressBar pb;

    private SearchLvAdapter searchLvAdapter;

    private TextView tvLoad;

    private View view_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_ment_sou_suo);
        initViews();
        editText = (EditText) findViewById(R.id.et);
        initData();

    }

    private void initViews() {
        searchLvAdapter = new SearchLvAdapter(list1);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(searchLvAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                Intent intent = new Intent(JieMentSouSuoActivity.this, JieMengDetailActivity.class);
                intent.putExtra("id", Integer.parseInt((list1.get(param1Int)).getId()));
                JieMentSouSuoActivity.this.startActivity(intent);
            }
        });
        view_more = getLayoutInflater().inflate(R.layout.view_more, null);
        pb = (ProgressBar) view_more.findViewById(R.id.progressBar);
        tvLoad = (TextView) view_more.findViewById(R.id.tv_Load);
    }

    private void initData() {

        String url = "http://aliyun.zhanxingfang.com/zxf/appclient/zhougong_new.php?act=get";

        RequestBody requestBody = new FormBody.Builder()
                .add("cid", getIntent().getStringExtra("id"))
                .add("page", String.valueOf(this.index))
                .add("page_num", String.valueOf(15))
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
                JieMengDetail jieMengDetail = (new Gson()).fromJson(json, JieMengDetail.class);
                data = jieMengDetail.getData();
                for (JieMengDetail.DataBean datum : data) {
                    lists.add(datum.getTitle());
                    list1.add(new JieMengDetail.DataBean(datum.getCid(), datum.getId(), datum.getTitle()));
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchLvAdapter.update(list1);
                        listView.addFooterView(view_more);
                        setListeners();

                    }
                });

            }
        });

    }

    private void loadMoreData() {
        this.index++;
        if (this.data.size() < 15) {
            this.listView.removeFooterView(this.view_more);
            return;
        }

        String url = "http://aliyun.zhanxingfang.com/zxf/appclient/zhougong_new.php?act=get";

        RequestBody requestBody = new FormBody.Builder()
                .add("cid", getIntent().getStringExtra("id"))
                .add("page", String.valueOf(this.index))
                .add("page_num", String.valueOf(15))
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
                JieMengDetail jieMengDetail = (new Gson()).fromJson(json, JieMengDetail.class);
                data = jieMengDetail.getData();
                for (JieMengDetail.DataBean datum : data) {
                    lists.add(datum.getTitle());
                    list1.add(new JieMengDetail.DataBean(datum.getCid(), datum.getId(), datum.getTitle()));
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        searchLvAdapter.update(list1);
                    }
                });
            }
        });
    }

    private void setListeners() {
        if (data.size() == 15) {
            listView.setOnScrollListener(this);
            return;
        }
        listView.removeFooterView(this.view_more);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int paramInt) {
        Log.e("TAG", "lastVisibleIndex = " + lastVisibleIndex);
        Log.e("TAG", "adapter.getCount() = " + searchLvAdapter.getCount());
        if (paramInt == 0 && lastVisibleIndex == searchLvAdapter.getCount()) {
            pb.setVisibility(View.VISIBLE);
            tvLoad.setVisibility(View.VISIBLE);
            loadMoreData();
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int paramInt1, int paramInt2, int paramInt3) {
        lastVisibleIndex = paramInt1 + paramInt2 - 1;
        if (paramInt3 == this.data.size() * index)
            listView.removeFooterView(view_more);
    }

    public void sousuo(View paramView) {
        if (editText.getText().toString().trim().equals("")) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        this.lists.clear();
        this.list1.clear();

        String url = "http://aliyun.zhanxingfang.com/zxf/appclient/zhougong.php?act=search_title";

        RequestBody requestBody = new FormBody.Builder()
                .add("keyword", editText.getText().toString().trim())
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


                JieMengDetail jieMengDetail = (new Gson()).fromJson(json, JieMengDetail.class);
                data = jieMengDetail.getData();
                lists.clear();
                list1.clear();
                for (JieMengDetail.DataBean datum : data) {
                    lists.add(datum.getTitle());
                    list1.add(new JieMengDetail.DataBean(datum.getCid(), datum.getId(), datum.getTitle()));
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (list1.size() > 0) {
                            searchLvAdapter.update(list1);
                            listView.addFooterView(view_more);
                            setListeners();
                        } else {
                            searchLvAdapter.clean();
                            listView.removeFooterView(view_more);
                            Toast.makeText(JieMentSouSuoActivity.this, "暂无相关", Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });


//        RequestParams requestParams = new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/zhougong.php?act=search_title");
//        requestParams.addBodyParameter("keyword", this.editText.getText().toString());
//        x.http().post(requestParams, new Callback.CommonCallback<String>() {
//            public void onCancelled(Callback.CancelledException param1CancelledException) {}
//
//            public void onError(Throwable param1Throwable, boolean param1Boolean) {}
//
//            public void onFinished() {}
//
//            public void onSuccess(String param1String) {
//                JieMengDetail jieMengDetail = (JieMengDetail)(new Gson()).fromJson(param1String, JieMengDetail.class);
//                JieMentSouSuoActivity.this.data = jieMengDetail.getData();
//                for (byte b = 0; b < JieMentSouSuoActivity.this.data.size(); b++) {
//                    JieMentSouSuoActivity.this.lists.add(((JieMengDetail.DataBean)JieMentSouSuoActivity.this.data.get(b)).getTitle());
//                    JieMentSouSuoActivity.this.list1.add(new JieMengDetail.DataBean(((JieMengDetail.DataBean)JieMentSouSuoActivity.this.data.get(b)).getCid(), ((JieMengDetail.DataBean)JieMentSouSuoActivity.this.data.get(b)).getId(), ((JieMengDetail.DataBean)JieMentSouSuoActivity.this.data.get(b)).getTitle()));
//                }
//                JieMentSouSuoActivity.this.searchLvAdapter.update(JieMentSouSuoActivity.this.list1);
//                JieMentSouSuoActivity.this.listView.addFooterView(JieMentSouSuoActivity.this.view_more);
//                JieMentSouSuoActivity.this.setListeners();
//            }
//        });
    }


}
