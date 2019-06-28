package com.everglow.mimixiao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by EverGlow on 2019/6/21 22:01
 */
public class ShengXiaoActivity extends AppCompatActivity {
    private int[] a = {
            R.drawable.sx_banner1, R.drawable.sx_banner2, R.drawable.sx_banner3,
            R.drawable.sx_banner4, R.drawable.sx_banner5, R.drawable.sx_banner6, R.drawable.sx_banner7, R.drawable.sx_banner8,
            R.drawable.sx_banner9, R.drawable.sx_banner10, R.drawable.sx_banner11, R.drawable.sx_banner12,


    };
    List<ShengXiao.DataBean.ZhuanTiDaQuanBean> mZhuanTiDaQuan;
    private TextView gexing;

    private ImageView iv;


    private TextView tv1;

    private TextView tv10;

    private TextView tv11;

    private TextView tv12;

    private TextView tv13;

    private TextView tv14;

    private TextView tv15;

    private TextView tv16;

    private TextView tv17;

    private TextView tv18;

    private TextView tv2;

    private TextView tv3;

    private TextView tv4;

    private TextView tv5;

    private TextView tv6;

    private TextView tv7;

    private TextView tv8;

    private TextView tv9;

    private TextView tv_1;

    private TextView tv_2;

    private TextView tv_3;

    private TextView tv_4;

    private TextView tv_5;

    private TextView tv_6;

    private TextView tv_7;

    private TextView zhuanti;
    private int mShengxiaoindex =1;
    private String mShengxiao ="shu";

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_sheng_xiao);
        init();
    }

    private void init() {

        this.iv = (ImageView) findViewById(R.id.iv);
        this.zhuanti = (TextView) findViewById(R.id.zhuanti);
        this.gexing = (TextView) findViewById(R.id.gexing);
        this.tv_1 = (TextView) findViewById(R.id.tv_1);
        this.tv_2 = (TextView) findViewById(R.id.tv_2);
        this.tv_3 = (TextView) findViewById(R.id.tv_3);
        this.tv_4 = (TextView) findViewById(R.id.tv_4);
        this.tv_5 = (TextView) findViewById(R.id.tv_5);
        this.tv_6 = (TextView) findViewById(R.id.tv_6);
        this.tv_7 = (TextView) findViewById(R.id.tv_7);
        this.tv1 = (TextView) findViewById(R.id.tv1);
        this.tv2 = (TextView) findViewById(R.id.tv2);
        this.tv3 = (TextView) findViewById(R.id.tv3);
        this.tv4 = (TextView) findViewById(R.id.tv4);
        this.tv5 = (TextView) findViewById(R.id.tv5);
        this.tv6 = (TextView) findViewById(R.id.tv6);
        this.tv7 = (TextView) findViewById(R.id.tv7);
        this.tv8 = (TextView) findViewById(R.id.tv8);
        this.tv9 = (TextView) findViewById(R.id.tv9);
        this.tv10 = (TextView) findViewById(R.id.tv10);
        this.tv11 = (TextView) findViewById(R.id.tv11);
        this.tv12 = (TextView) findViewById(R.id.tv12);
        this.tv13 = (TextView) findViewById(R.id.tv13);
        this.tv14 = (TextView) findViewById(R.id.tv14);
        this.tv15 = (TextView) findViewById(R.id.tv15);
        this.tv16 = (TextView) findViewById(R.id.tv16);
        this.tv17 = (TextView) findViewById(R.id.tv17);
        this.tv18 = (TextView) findViewById(R.id.tv18);
        this.zhuanti.setText("字鼠的专题大会");
        this.gexing.setText( "子鼠的个性标签");
        this.iv.setImageResource(a[0]);
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(0).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(0).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(1).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(1).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(2).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(2).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(3).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(3).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(3).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(3).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(4).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(4).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(5).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(5).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        tv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", mZhuanTiDaQuan.get(6).getTitle());
                intent.putExtra("url", mZhuanTiDaQuan.get(6).getUrl());
                ShengXiaoActivity.this.startActivity(intent);
            }
        });
        setDate();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ShengXiaoActivity.this);

                View view1 = LayoutInflater.from(ShengXiaoActivity.this).inflate(R.layout.shengxiao_dialog_item, null, false);
                builder.setCancelable(true);

                builder.setView(view1);
                final AlertDialog show = builder.show();
                RadioGroup rg = view1.findViewById(R.id.rg);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        if (i == R.id.zishu) {
                            mShengxiaoindex = 1;
                            mShengxiao = "shu";
                            updateUi(show, "子鼠", 0);
                        } else if (i == R.id.chouniu) {
                            mShengxiaoindex = 2;
                            mShengxiao = "niu";
                            updateUi(show, "丑牛", 1);
                        } else if (i == R.id.yinhu) {
                            mShengxiaoindex = 3;
                            mShengxiao = "hu";
                            updateUi(show, "寅虎", 2);
                        } else if (i == R.id.maotu) {
                            mShengxiaoindex = 4;
                            mShengxiao = "tu";
                            updateUi(show, "卯兔", 3);
                        } else if (i == R.id.chenlong) {
                            mShengxiaoindex = 5;
                            mShengxiao = "long";
                            updateUi(show, "辰龙", 4);
                        } else if (i == R.id.yishe) {
                            mShengxiaoindex = 6;
                            mShengxiao = "she";
                            updateUi(show, "已蛇", 5);

                            mShengxiaoindex = 7;
                            mShengxiao = "ma";
                            updateUi(show, "午马", 6);
                        } else if (i == R.id.wuma) {
                            mShengxiaoindex = 7;
                            mShengxiao = "ma";
                            updateUi(show, "午马", 6);
                        } else if (i == R.id.weiyang) {
                            mShengxiaoindex = 8;
                            mShengxiao = "yang";
                            updateUi(show, "未羊", 7);
                        } else if (i == R.id.shenhou) {
                            mShengxiaoindex = 9;
                            mShengxiao = "hou";
                            updateUi(show, "申猴", 8);
                        } else if (i == R.id.youji) {
                            mShengxiaoindex = 10;
                            mShengxiao = "ji";
                            updateUi(show, "酉鸡", 9);
                        } else if (i == R.id.xvgou) {
                            mShengxiaoindex = 11;
                            mShengxiao = "gou";
                            updateUi(show, "戌狗", 10);
                        } else if (i == R.id.haizhu) {
                            mShengxiaoindex = 12;
                            mShengxiao = "zhu";
                            updateUi(show, "亥猪", 11);
                        }
                    }
                });

            }

        });
    }

    private void updateUi(AlertDialog show, String s, int i) {
        zhuanti.setText(s + "的专题大会");
        gexing.setText(s + "的个性标签");
        iv.setImageResource(a[i]);
        setDate();
        show.dismiss();
    }

    private void setDate() {
        
        String url = "http://aliyun.zhanxingfang.com/zxf/m/shengxiao/" + mShengxiaoindex + "/" + mShengxiao + ".txt";
//        String url = "http://appid.aigoodies.com/getAppConfig.php?appid=everglow0602a5";
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
                ShengXiao shengXiao = (ShengXiao) (new Gson()).fromJson(json, ShengXiao.class);
                mZhuanTiDaQuan = shengXiao.getData().getZhuanTiDaQuan();
                final List<ShengXiao.DataBean.BiaoQianBean> list = shengXiao.getData().getBiaoQian();
                ShengXiaoActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText(list.get(0).getText());
                        tv2.setText(list.get(1).getText());
                        tv3.setText(list.get(2).getText());
                        tv4.setText(list.get(3).getText());
                        tv5.setText(list.get(4).getText());
                        tv6.setText(list.get(5).getText());
                        tv7.setText(list.get(6).getText());
                        tv8.setText(list.get(7).getText());
                        tv9.setText(list.get(8).getText());
                        tv10.setText(list.get(9).getText());
                        tv11.setText(list.get(10).getText());
                        tv12.setText(list.get(11).getText());
                        tv13.setText(list.get(12).getText());
                        tv14.setText(list.get(13).getText());
                        tv15.setText(list.get(14).getText());
                        tv16.setText(list.get(15).getText());
                        tv17.setText(list.get(14).getText());
                        tv18.setText(list.get(15).getText());

                        tv_1.setText(mZhuanTiDaQuan.get(0).getTitle());
                        tv_2.setText(mZhuanTiDaQuan.get(1).getTitle());
                        tv_3.setText(mZhuanTiDaQuan.get(2).getTitle());
                        tv_4.setText(mZhuanTiDaQuan.get(3).getTitle());
                        tv_5.setText(mZhuanTiDaQuan.get(4).getTitle());
                        tv_6.setText(mZhuanTiDaQuan.get(5).getTitle());
                        tv_7.setText(mZhuanTiDaQuan.get(6).getTitle());
                    }
                });
            }
        });
    }
}