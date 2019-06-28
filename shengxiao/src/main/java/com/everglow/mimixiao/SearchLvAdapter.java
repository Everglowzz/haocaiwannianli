package com.everglow.mimixiao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.everglow.mimixiao.bean.JieMengDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 19:44
 */

public class SearchLvAdapter extends BaseAdapter {
    List<JieMengDetail.DataBean> list1 = new ArrayList();

    public SearchLvAdapter(List<JieMengDetail.DataBean> paramList) { this.list1.addAll(paramList); }

    public int getCount() { return this.list1.size(); }

    public Object getItem(int paramInt) { return this.list1.get(paramInt); }

    public long getItemId(int paramInt) { return paramInt; }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        View view = paramView;
        if (paramView == null) {
            view = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.adapter_item, paramViewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text1 = (TextView)view.findViewById(R.id.text1);
            view.setTag(viewHolder);
        }
        ((ViewHolder)view.getTag()).text1.setText(((JieMengDetail.DataBean)this.list1.get(paramInt)).getTitle());
        return view;
    }

    public void update(List<JieMengDetail.DataBean> paramList) {
        this.list1 = paramList;
        notifyDataSetChanged();
    }
    
    public void clean(){
        list1.clear();
        notifyDataSetChanged();
    }

    class ViewHolder {
        public TextView text1;
    }
}