package com.example.wannianli;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WannianliActivity extends AppCompatActivity implements CalendarFragment.Callback {
    SimpleDateFormat mMonthFormat = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
    static String chineseNumber[] =
            {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    private static final String TAG = "WannianliActivity";
    TextView mTopTitle;
    Toolbar mToolbar;
    ViewPager mViewPager;
    TextView mTvDay;
    TextView mTvDate;
    TextView mTvWeek;
    TextView mTvLunarCalendar;
    TextView mTvShouldDo;
    TextView mTvAvoidDo;
    TextView mRightTitle;
    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wannianli);
        initView();
    }

    private void initView() {
        mTopTitle = findViewById(R.id.topTitle);
        mToolbar = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.viewPager);
        mTvDay = findViewById(R.id.tv_day);
        mTvDate = findViewById(R.id.tv_date);
        mTvWeek = findViewById(R.id.tv_week);
        mTvLunarCalendar = findViewById(R.id.tv_lunar_calendar);
        mTvShouldDo = findViewById(R.id.tv_should_do);
        mTvAvoidDo = findViewById(R.id.tv_avoid_do);
        mRightTitle = findViewById(R.id.rightTitle);

        mRightTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0, false);
            }
        });

        mTopTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] split = mTopTitle.getTag().toString().split("/");
                MonthFragment.newInstance(Integer.valueOf(split[0]), Integer.valueOf(split[1]), new MonthFragment.MonthCallBack() {
                    @Override
                    public void onDateSet(int year, int month) {
                        Log.i(TAG, "year:" + year + "-->month:" + month);
                        int position = (year - Calendar.getInstance().get(Calendar.YEAR)) * 12 + month - (Calendar.getInstance().get(Calendar.MONTH) + 1);
                        mViewPager.setCurrentItem(position, false);
                    }
                }).show(getSupportFragmentManager(), MonthFragment.TAG);
            }
        });

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);


    }

    private void getMonth(final String month) {
        String url = "http://yl.cgsoft.net/index.php?g=Xmsapishopq&m=huangli&a=getmonth";
        HashMap<String, String> params = new HashMap<>();

        RequestBody requestBody = new FormBody.Builder()
                .add("yearmonth", month)
                .add("token", "43378e1b35ae7858e82eba2b27ddefd7")
                .add("driver", "2").build();
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
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
                final AuspiciousCalendarForm calendarForm = new Gson().fromJson(json, AuspiciousCalendarForm.class);
                if (calendarForm.getCode() == 1) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mPagerAdapter.refresh(calendarForm.getDayarray());
                        }
                    });

                }

            }
        });
    }

    private void getDay(final String date) {


        String url = "http://yl.cgsoft.net/index.php?g=Xmsapishopq&m=huangli&a=getday";

        RequestBody requestBody = new FormBody.Builder()
                .add("yearmonthday", date)
                .add("token", "43378e1b35ae7858e82eba2b27ddefd7")
                .add("driver", "2").build();
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
                AuspiciousCalendarForm calendarForm = new Gson().fromJson(json, AuspiciousCalendarForm.class);
                if (calendarForm.getCode() == 1) {
                    final AuspiciousCalendarForm.HuangLi huangLi = calendarForm.getHuangli();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTvShouldDo.setText(huangLi.getOk());
                            mTvAvoidDo.setText(huangLi.getNo());
                        }
                    });

                }

            }
        });
    }

    @Override
    public void computeHeight(int position, int height, LunarSolarConverter.Solar solar) {
        if (position != mViewPager.getCurrentItem()) return;
        ViewGroup.LayoutParams params = mViewPager.getLayoutParams();
        params.height = height;
        mViewPager.setLayoutParams(params);
        mTopTitle.setText(chineseNumber[solar.month - 1] + "月 " + solar.year);
        mTopTitle.setTag(solar.year + "/" + solar.month);
        getMonth(mMonthFormat.format(solar.date));
    }

    @Override
    public void itemClick(int position, LunarSolarConverter.Lunar lunar, LunarSolarConverter.Solar solar) {
        if (position != mViewPager.getCurrentItem()) return;
        getDay(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(solar.date));
        mTvDay.setText(new SimpleDateFormat("dd", Locale.CHINA).format(solar.date));
        mTvDate.setText(new SimpleDateFormat("yyyy年MM月", Locale.CHINA).format(solar.date));
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        int day = (int) ((solar.date.getTime() - calendar.getTimeInMillis()) / 1000 / 24 / 60 / 60);
        mTvWeek.setText(new SimpleDateFormat("EEEE", Locale.CHINA).format(solar.date) + "\t" + (day == 0 ? "今天" : (day + "天后")));
        int days = LunarSolarConverter.getLunarDays(lunar.year, lunar.month);
        mTvLunarCalendar.setText("农历" + lunar.getMonth() + "月" + "(" + (days == 29 ? "小" : "大") + ")" + lunar.getDay());
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CalendarFragment.newInstance(position);
        }

        public void refresh(String[] dayArray) {
            instantiateItem().refresh(Arrays.asList(dayArray));
        }

        public CalendarFragment instantiateItem() {
            return (CalendarFragment) mPagerAdapter.instantiateItem(mViewPager, mViewPager.getCurrentItem());
        }

        @Override
        public int getCount() {
            return (2100 - Calendar.getInstance().get(Calendar.YEAR)) * 12 + (Calendar.getInstance().get(Calendar.MONTH) + 1);
        }
    }
}
