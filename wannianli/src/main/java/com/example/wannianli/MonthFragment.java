package com.example.wannianli;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.NumberPicker;

import java.util.Calendar;

/**
 * Created by YougaKing on 2016/10/17.
 */

public class MonthFragment extends DialogFragment {

    public static final String TAG = "MonthFragment";
    private static final int MAX_YEAR = 2100;
    private MonthCallBack callBack;

    public static MonthFragment newInstance(int year, int month, MonthCallBack callBack) {
        MonthFragment fragment = new MonthFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("year", year);
        bundle.putInt("month", month);
        fragment.setArguments(bundle);
        fragment.setMonthYearPickerCallBack(callBack);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final Calendar cal = Calendar.getInstance();

        View dialog = inflater.inflate(R.layout.fragment_month, null);
        final NumberPicker monthPicker = (NumberPicker) dialog.findViewById(R.id.picker_month);
        final NumberPicker yearPicker = (NumberPicker) dialog.findViewById(R.id.picker_year);

        final int year = cal.get(Calendar.YEAR);
        if (year == getArguments().getInt("year")) {
            monthPicker.setMinValue(cal.get(Calendar.MONTH) + 1);
            monthPicker.setMaxValue(12);
        } else {
            monthPicker.setMinValue(1);
            monthPicker.setMaxValue(12);
        }
        monthPicker.setValue(getArguments().getInt("month"));

        yearPicker.setMinValue(cal.get(Calendar.YEAR));
        yearPicker.setMaxValue(MAX_YEAR);
        yearPicker.setValue(getArguments().getInt("year"));

        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (year == newVal) {
                    monthPicker.setMinValue(cal.get(Calendar.MONTH) + 1);
                    monthPicker.setMaxValue(12);
                } else if (newVal == 2100) {
                    monthPicker.setMinValue(1);
                    monthPicker.setMaxValue(10);
                } else {
                    monthPicker.setMinValue(1);
                    monthPicker.setMaxValue(12);
                }
            }
        });

        builder.setView(dialog)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        callBack.onDateSet(yearPicker.getValue(), monthPicker.getValue());
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog alertDialog = builder.show();
        WindowManager.LayoutParams lp = alertDialog.getWindow().getAttributes();
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metric);
        lp.width = (int) (metric.widthPixels - 50 * metric.density);
        alertDialog.getWindow().setAttributes(lp);
        return alertDialog;
    }

    public interface MonthCallBack {
        void onDateSet(int year, int month);
    }

    public void setMonthYearPickerCallBack(MonthCallBack callBack) {
        this.callBack = callBack;
    }
}
