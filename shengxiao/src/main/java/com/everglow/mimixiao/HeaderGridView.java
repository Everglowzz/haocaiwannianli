package com.everglow.mimixiao;
/**
 * Created by EverGlow on 2019/6/22 17:49
 */
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView {
    private static final String TAG = "HeaderGridView";

    private ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList();

    public HeaderGridView(Context paramContext) {
        super(paramContext);
        initHeaderGridView();
    }

    public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initHeaderGridView();
    }

    public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initHeaderGridView();
    }

    private void initHeaderGridView() { super.setClipChildren(false); }

    private void removeFixedViewInfo(View paramView, ArrayList<FixedViewInfo> paramArrayList) {
        int i = paramArrayList.size();
        for (byte b = 0;; b++) {
            if (b < i) {
                if (((FixedViewInfo)paramArrayList.get(b)).view == paramView) {
                    paramArrayList.remove(b);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void addHeaderView(View paramView) { addHeaderView(paramView, null, true); }

    public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean) {
        ListAdapter listAdapter = getAdapter();
        if (listAdapter != null && !(listAdapter instanceof HeaderViewGridAdapter))
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        FullWidthFixedViewLayout fullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
        fullWidthFixedViewLayout.addView(paramView);
        fixedViewInfo.view = paramView;
        fixedViewInfo.viewContainer = fullWidthFixedViewLayout;
        fixedViewInfo.data = paramObject;
        fixedViewInfo.isSelectable = paramBoolean;
        this.mHeaderViewInfos.add(fixedViewInfo);
        if (listAdapter != null)
            ((HeaderViewGridAdapter)listAdapter).notifyDataSetChanged();
    }

    public int getHeaderViewCount() { return this.mHeaderViewInfos.size(); }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        ListAdapter listAdapter = getAdapter();
        if (listAdapter != null && listAdapter instanceof HeaderViewGridAdapter)
            ((HeaderViewGridAdapter)listAdapter).setNumColumns(getNumColumns());
    }

    public boolean removeHeaderView(View paramView) {
        if (this.mHeaderViewInfos.size() > 0) {
            byte b = 0;
            ListAdapter listAdapter = getAdapter();
            boolean i = true;
            if (listAdapter != null) {
                i = false;
                if (((HeaderViewGridAdapter)listAdapter).removeHeader(paramView))
                    i = true;
            }
            removeFixedViewInfo(paramView, this.mHeaderViewInfos);
            return i;
        }
        return false;
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        HeaderViewGridAdapter headerViewGridAdapter;
        if (this.mHeaderViewInfos.size() > 0) {
            headerViewGridAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, paramListAdapter);
            int i = getNumColumns();
            if (i > 1)
                headerViewGridAdapter.setNumColumns(i);
            super.setAdapter(headerViewGridAdapter);
            return;
        }
        super.setAdapter(null);
    }

    public void setClipChildren(boolean paramBoolean) {}

    private static class FixedViewInfo {
        public Object data;

        public boolean isSelectable;

        public View view;

        public ViewGroup viewContainer;

        private FixedViewInfo() {}
    }

    private class FullWidthFixedViewLayout extends FrameLayout {
        public FullWidthFixedViewLayout(Context param1Context) { super(param1Context); }

        protected void onMeasure(int param1Int1, int param1Int2) { super.onMeasure(MeasureSpec.makeMeasureSpec(HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft() - HeaderGridView.this.getPaddingRight(), MeasureSpec.getMode(param1Int1)), param1Int2); }
    }

    private static class HeaderViewGridAdapter implements WrapperListAdapter, Filterable {
        private final ListAdapter mAdapter;

        boolean mAreAllFixedViewsSelectable;

        private final DataSetObservable mDataSetObservable = new DataSetObservable();

        ArrayList<FixedViewInfo> mHeaderViewInfos;

        private final boolean mIsFilterable;

        private int mNumColumns = 1;

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> param1ArrayList, ListAdapter param1ListAdapter) {
            this.mAdapter = param1ListAdapter;
            this.mIsFilterable = param1ListAdapter instanceof Filterable;
            if (param1ArrayList == null)
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            this.mHeaderViewInfos = param1ArrayList;
            this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos);
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> param1ArrayList) {
            if (param1ArrayList != null) {
                Iterator iterator = param1ArrayList.iterator();
                while (iterator.hasNext()) {
                    if (!((FixedViewInfo)iterator.next()).isSelectable)
                        return false;
                }
            }
            return true;
        }

        public boolean areAllItemsEnabled() { return (this.mAdapter == null || (this.mAreAllFixedViewsSelectable && this.mAdapter.areAllItemsEnabled())); }

        public int getCount() { return (this.mAdapter != null) ? (getHeadersCount() * this.mNumColumns + this.mAdapter.getCount()) : (getHeadersCount() * this.mNumColumns); }

        public Filter getFilter() { return this.mIsFilterable ? ((Filterable)this.mAdapter).getFilter() : null; }

        public int getHeadersCount() { return this.mHeaderViewInfos.size(); }

        public Object getItem(int param1Int) {
            int i = getHeadersCount() * this.mNumColumns;
            if (param1Int < i)
                return (param1Int % this.mNumColumns == 0) ? ((FixedViewInfo)this.mHeaderViewInfos.get(param1Int / this.mNumColumns)).data : null;
            i = param1Int - i;
            if (this.mAdapter != null && i < this.mAdapter.getCount())
                return this.mAdapter.getItem(i);
            throw new ArrayIndexOutOfBoundsException(param1Int);
        }

        public long getItemId(int param1Int) {
            int i = getHeadersCount() * this.mNumColumns;
            if (this.mAdapter != null && param1Int >= i) {
                param1Int -= i;
                if (param1Int < this.mAdapter.getCount())
                    return this.mAdapter.getItemId(param1Int);
            }
            return -1L;
        }

        public int getItemViewType(int param1Int) {
            int i = getHeadersCount() * this.mNumColumns;
            if (param1Int < i && param1Int % this.mNumColumns != 0)
                return (this.mAdapter != null) ? this.mAdapter.getViewTypeCount() : 1;
            if (this.mAdapter != null && param1Int >= i) {
                param1Int -= i;
                if (param1Int < this.mAdapter.getCount())
                    return this.mAdapter.getItemViewType(param1Int);
            }
            return -2;
        }

        public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
            int i = getHeadersCount() * this.mNumColumns;
            if (param1Int < i) {
                ViewGroup viewGroup = ((FixedViewInfo)this.mHeaderViewInfos.get(param1Int / this.mNumColumns)).viewContainer;
                if (param1Int % this.mNumColumns == 0)
                    return viewGroup;
                View view = param1View;
                if (param1View == null)
                    view = new View(param1ViewGroup.getContext());
                view.setVisibility(INVISIBLE);
                view.setMinimumHeight(viewGroup.getHeight());
                return view;
            }
            i = param1Int - i;
            if (this.mAdapter != null && i < this.mAdapter.getCount())
                return this.mAdapter.getView(i, param1View, param1ViewGroup);
            throw new ArrayIndexOutOfBoundsException(param1Int);
        }

        public int getViewTypeCount() { return (this.mAdapter != null) ? (this.mAdapter.getViewTypeCount() + 1) : 2; }

        public ListAdapter getWrappedAdapter() { return this.mAdapter; }

        public boolean hasStableIds() { return (this.mAdapter != null) ? this.mAdapter.hasStableIds() : false; }

        public boolean isEmpty() { return ((this.mAdapter == null || this.mAdapter.isEmpty()) && getHeadersCount() == 0); }

        public boolean isEnabled(int param1Int) {
            int i = getHeadersCount() * this.mNumColumns;
            if (param1Int < i)
                return (param1Int % this.mNumColumns == 0 && ((FixedViewInfo)this.mHeaderViewInfos.get(param1Int / this.mNumColumns)).isSelectable);
            i = param1Int - i;
            if (this.mAdapter != null && i < this.mAdapter.getCount())
                return this.mAdapter.isEnabled(i);
            throw new ArrayIndexOutOfBoundsException(param1Int);
        }

        public void notifyDataSetChanged() { this.mDataSetObservable.notifyChanged(); }

        public void registerDataSetObserver(DataSetObserver param1DataSetObserver) {
            this.mDataSetObservable.registerObserver(param1DataSetObserver);
            if (this.mAdapter != null)
                this.mAdapter.registerDataSetObserver(param1DataSetObserver);
        }

        public boolean removeHeader(View param1View) {
            for (byte b = 0; b < this.mHeaderViewInfos.size(); b++) {
                if (((FixedViewInfo)this.mHeaderViewInfos.get(b)).view == param1View) {
                    this.mHeaderViewInfos.remove(b);
                    this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos);
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public void setNumColumns(int param1Int) {
            if (param1Int < 1)
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            if (this.mNumColumns != param1Int) {
                this.mNumColumns = param1Int;
                notifyDataSetChanged();
            }
        }

        public void unregisterDataSetObserver(DataSetObserver param1DataSetObserver) {
            this.mDataSetObservable.unregisterObserver(param1DataSetObserver);
            if (this.mAdapter != null)
                this.mAdapter.unregisterDataSetObserver(param1DataSetObserver);
        }
    }
}
