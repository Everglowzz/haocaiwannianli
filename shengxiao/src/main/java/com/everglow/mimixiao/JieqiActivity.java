package com.everglow.mimixiao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JieqiActivity extends AppCompatActivity {
    HeaderGridView gv;

    List<JieQi> list = new ArrayList();

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jieqi);
        tv = findViewById(R.id.tv);
        tv.setText("节气查询");
        list.add(new JieQi(R.drawable.ms_icon3, "立春"));
        list.add(new JieQi(R.drawable.ms_icon4, "雨水"));
        list.add(new JieQi(R.drawable.ms_icon5, "惊蛰"));
        list.add(new JieQi(R.drawable.ms_icon6, "春风"));
        list.add(new JieQi(R.drawable.ms_icon7, "清明"));
        list.add(new JieQi(R.drawable.ms_icon8, "谷雨"));
        list.add(new JieQi(R.drawable.ms_icon9, "立夏"));
        list.add(new JieQi(R.drawable.ms_icon10, "小满"));
        list.add(new JieQi(R.drawable.ms_icon11, "忙种"));
        list.add(new JieQi(R.drawable.ms_icon12, "夏至"));
        list.add(new JieQi(R.drawable.ms_icon13, "小暑"));
        list.add(new JieQi(R.drawable.ms_icon14, "大暑"));
        list.add(new JieQi(R.drawable.ms_icon15, "立秋"));
        list.add(new JieQi(R.drawable.ms_icon16, "处暑"));
        list.add(new JieQi(R.drawable.ms_icon17, "白露"));
        list.add(new JieQi(R.drawable.ms_icon18, "秋风"));
        list.add(new JieQi(R.drawable.ms_icon19, "寒露"));
        list.add(new JieQi(R.drawable.ms_icon20, "霜降"));
        list.add(new JieQi(R.drawable.ms_icon21, "立冬"));
        list.add(new JieQi(R.drawable.ms_icon22, "小雪"));
        list.add(new JieQi(R.drawable.ms_icon23, "大雪"));
        list.add(new JieQi(R.drawable.ms_icon24, "冬至"));
        list.add(new JieQi(R.drawable.ms_icon25, "小寒"));
        list.add(new JieQi(R.drawable.ms_icon26, "大寒"));
        gv = findViewById(R.id.gv);
        gv.addHeaderView(LayoutInflater.from(this).inflate(R.layout.jieqi_headview, null, false));
        gv.setAdapter(new MyAdapter());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                Intent intent = new Intent(JieqiActivity.this, DangAnActivity.class);
                intent.putExtra("title", list.get(param1Int - 4).getName());
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/m/24jieqi/" + (param1Int - 3) + ".txt");
                JieqiActivity.this.startActivity(intent);
            }
        });
    }


    class MyAdapter extends BaseAdapter {
        public int getCount() {
            return JieqiActivity.this.list.size();
        }

        public JieQi getItem(int param1Int) {
            return list.get(param1Int);
        }

        public long getItemId(int param1Int) {
            return param1Int;
        }

        @Override
        public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
            param1View = LayoutInflater.from(JieqiActivity.this).inflate(R.layout.jieqi_item, param1ViewGroup, false);
            TextView textView = (TextView) param1View.findViewById(R.id.name);
            ImageView imageView = (ImageView) param1View.findViewById(R.id.img);
            textView.setText(list.get(param1Int).getName());
            imageView.setImageResource(list.get(param1Int).getImg());
            return param1View;
        }
    }
}
