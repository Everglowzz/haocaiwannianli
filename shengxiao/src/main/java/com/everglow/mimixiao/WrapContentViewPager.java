package com.everglow.mimixiao;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by EverGlow on 2019/6/22 20:16
 */

public class WrapContentViewPager extends ViewPager {
    private int current;

    private int height = 0;

    private HashMap<Integer, View> mChildrenViews = new LinkedHashMap();

    private boolean scrollble = true;

    public WrapContentViewPager(Context paramContext) { super(paramContext); }

    public WrapContentViewPager(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }

    public boolean isScrollble() { return this.scrollble; }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if (this.mChildrenViews.size() > this.current) {
            View view = (View)this.mChildrenViews.get(Integer.valueOf(this.current));
            if (view != null) {
                view.measure(paramInt1, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                this.height = view.getMeasuredHeight();
            }
        }
        super.onMeasure(paramInt1, MeasureSpec.makeMeasureSpec(this.height, MeasureSpec.EXACTLY));
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) { return !this.scrollble ? true : super.onTouchEvent(paramMotionEvent); }

    public void resetHeight(int paramInt) {
        this.current = paramInt;
        if (this.mChildrenViews.size() > paramInt) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, this.height);
            } else {
                layoutParams.height = this.height;
            }
            setLayoutParams(layoutParams);
        }
    }

    public void setObjectForPosition(View paramView, int paramInt) { this.mChildrenViews.put(Integer.valueOf(paramInt), paramView); }

    public void setScrollble(boolean paramBoolean) { this.scrollble = paramBoolean; }
}
