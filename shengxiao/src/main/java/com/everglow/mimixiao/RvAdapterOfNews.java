package com.everglow.mimixiao;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.everglow.mimixiao.bean.DangAn;
import com.github.library.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 22:15
 */
public class RvAdapterOfNews extends BaseQuickAdapter<DangAn.BaiyangBean.GuanJianZiBean, MyViewHolder> {
    private static List<Integer> listColor = new ArrayList();

    static {
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape1));
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape2));
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape3));
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape4));
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape5));
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape6));
        listColor.add(Integer.valueOf(R.drawable.dangan_guanjian_shape7));
     
    }

    public RvAdapterOfNews(@Nullable List<DangAn.BaiyangBean.GuanJianZiBean> paramList) {
        super(R.layout.dangan_item, paramList);
    }

    protected void convert(MyViewHolder paramBaseViewHolder, DangAn.BaiyangBean.GuanJianZiBean paramGuanJianZiBean) {
        ((TextView) paramBaseViewHolder.getView(R.id.title)).setBackgroundResource(((Integer) listColor.get(paramBaseViewHolder.getPosition())).intValue());
        paramBaseViewHolder.setText(R.id.detail, paramGuanJianZiBean.getText());
        paramBaseViewHolder.setText(R.id.title, paramGuanJianZiBean.getTitle());
    }
}
