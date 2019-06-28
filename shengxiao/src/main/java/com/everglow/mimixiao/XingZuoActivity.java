package com.everglow.mimixiao;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.everglow.mimixiao.bean.XingZuo;
import com.everglow.mimixiao.fragments.DangAnFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class XingZuoActivity extends AppCompatActivity {
    private int a = 0;

    private DangAnFragment dangAnFragment;

    private TextView dangan;

    private LinearLayout ll;

    private FragmentManager manager;

    private TextView riqi;

    private SharedPreferences sp;

    private ImageView xingZuoHead;

    private XingZuoYunShiFragment xingZuoYunShiFragment;

    private TextView xingzuo;

    private TextView xinxi;

    private TextView yunshi;

    private void getData() {
        StringBuffer stringBuffer;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(this.sp.getString("xingzuo", "aries") + ".txt")));
            stringBuffer = new StringBuffer();
            while (true) {
                String str = bufferedReader.readLine();
                if (str != null) {
                    stringBuffer.append(str);
                    continue;
                }
                break;
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        this.xinxi.setText(stringBuffer.toString());
        String[] zuo = getXingZuo();
        this.xingzuo.setText(zuo[0]);
        this.riqi.setText(zuo[1]);
//        List list = DataSupport.where(new String[] { "xingzuo=?", this.sp.getString("xingzuo", "") }).find(XingZuo.class);
//        if (list.size() > 0) {
//            this.xingzuo.setText(((XingZuo)list.get(0)).getXingzuoming());
//            this.riqi.setText(((XingZuo)list.get(0)).getRiqi());
//            return;
//        }
    }

    private String[] getXingZuo() {
        String str3 = this.sp.getString("xingzuo", "aries");
        String str2 = "白羊座";
        String str1 = "3.21-4.19";

        switch (str3) {
            case "aquarius":
                str2 = "水瓶座";
                str1 = "1.20-2.18";
                break;
            case "aries":
                str2 = "白羊座";
                str1 = "3.21-4.19";
                break;
            case "cancer":
                str2 = "巨蟹座";
                str1 = "6.22-7.22";
                break;
            case "capricorn":
                str2 = "摩羯座";
                str1 = "12.22-1.19";
                break;
            case "gemini":
                str2 = "双子座";
                str1 = "5.21-6.21";
                break;
            case "leo":
                str2 = "狮子座";
                str1 = "7.23-8.22";
                break;
            case "libra":
                str2 = "天秤座";
                str1 = "9.23-10.23";
                break;
            case "pisces":
                str2 = "双鱼座";
                str1 = "2.13-3.20";
                break;
            case "sagittarius":
                str2 = "射手座";
                str1 = "11.23-12.21";
                break;
            case "scorpio":
                str2 = "天蝎座";
                str1 = "10.24-11.22";
                break;
            case "taurus":
                str2 = "金牛座";
                str1 = "4.20-5.20";
                break;
            case "virgo":
                str2 = "处女座";
                str1 = "8.23-9.22";
                break;

        }
        return new String[]{str2, str1};
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_xing_zuo);
        this.ll = (LinearLayout) findViewById(R.id.ll);
        this.xingzuo = (TextView) findViewById(R.id.xingzuo);
        this.yunshi = (TextView) findViewById(R.id.yunshi);
        this.dangan = (TextView) findViewById(R.id.dangan);
        this.riqi = (TextView) findViewById(R.id.riqi);
        this.xingZuoHead = (ImageView) findViewById(R.id.xingzuohead);
        this.xingZuoYunShiFragment = new XingZuoYunShiFragment();
        this.manager = getSupportFragmentManager();
        dangAnFragment = new DangAnFragment();
        this.manager.beginTransaction().add(R.id.ll1, this.xingZuoYunShiFragment).add(R.id.ll1, this.dangAnFragment).commit();
        manager.beginTransaction().hide(dangAnFragment).show(xingZuoYunShiFragment).commitAllowingStateLoss();
        this.sp = getSharedPreferences("xingzuo", 0);
        this.xingzuo.setText(getXingZuo()[0]);
        this.riqi.setText(getXingZuo()[1]);

        this.yunshi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                XingZuoActivity.this.yunshi.setBackgroundResource(R.drawable.bg_text);
                XingZuoActivity.this.yunshi.setTextColor(Color.WHITE);
                XingZuoActivity.this.dangan.setBackgroundColor(Color.TRANSPARENT);
                XingZuoActivity.this.dangan.setTextColor(getResources().getColor(R.color.text_bg_color));
                manager.beginTransaction().hide(dangAnFragment).show(xingZuoYunShiFragment).commitAllowingStateLoss();
            }
        });
        this.dangan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                XingZuoActivity.this.dangan.setBackgroundResource(R.drawable.bg_text);
                XingZuoActivity.this.dangan.setTextColor(Color.WHITE);
                XingZuoActivity.this.yunshi.setBackgroundColor(Color.TRANSPARENT);
                XingZuoActivity.this.yunshi.setTextColor(getResources().getColor((R.color.text_bg_color)));
                manager.beginTransaction().hide(xingZuoYunShiFragment).show(dangAnFragment).commitAllowingStateLoss();
            }
        });
        this.xinxi = (TextView) findViewById(R.id.xinxi);
        getData();

        this.ll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(XingZuoActivity.this);

                View view1 = LayoutInflater.from(XingZuoActivity.this).inflate(R.layout.dialog_item, null, false);
                builder.setCancelable(true);

                builder.setView(view1);
                final AlertDialog show = builder.show();
                RadioGroup rg = view1.findViewById(R.id.brg);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        Drawable drawable;
                        int drawableResId = R.drawable.xztb_tc1;
                        if (i == R.id.baiyang) {
                            sp.edit().putString("xingzuo", "aries").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_21).commit();
                            sp.edit().putInt("index", 1).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_21);
                            xingzuo.setText("白羊座");
                            riqi.setText("3.21-4.19");
                            drawableResId = R.drawable.xztb_tc1;
                        } else if (i == R.id.jinniu) {
                            sp.edit().putString("xingzuo", "taurus").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_22).commit();
                            sp.edit().putInt("index", 2).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_22);
                            xingzuo.setText("金牛座");
                            riqi.setText("4.20-5.20");
                            drawableResId = R.drawable.xztb_tc2;
                        } else if (i == R.id.shuangzi) {
                            sp.edit().putString("xingzuo", "gemini").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_23).commit();
                            sp.edit().putInt("index", 3).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_23);
                            xingzuo.setText("双子座");
                            riqi.setText("5.21-6.21");
                            drawableResId = R.drawable.xztb_tc3;
                        } else if (i == R.id.jvxie) {
                            sp.edit().putString("xingzuo", "cancer").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_24).commit();
                            sp.edit().putInt("index", 4).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_24);
                            xingzuo.setText("巨蟹座");
                            riqi.setText("6.22-7.22");
                            drawableResId = R.drawable.xztb_tc4;
                        } else if (i == R.id.shizi) {
                            sp.edit().putString("xingzuo", "leo").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_25).commit();
                            sp.edit().putInt("index", 5).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_25);
                            xingzuo.setText("狮子座");
                            riqi.setText("7.23-8.22");
                            drawableResId = R.drawable.xztb_tc5;
                        } else if (i == R.id.chunv) {
                            sp.edit().putString("xingzuo", "virgo").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_26).commit();
                            sp.edit().putInt("index", 6).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_26);
                            xingzuo.setText("处女座");
                            riqi.setText("8.23-9.22");
                            drawableResId = R.drawable.xztb_tc6;
                        } else if (i == R.id.tiancheng) {
                            sp.edit().putString("xingzuo", "libra").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_27).commit();
                            sp.edit().putInt("index", 7).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_27);
                            xingzuo.setText("天秤座");
                            riqi.setText("9.23-10.23");
                            drawableResId = R.drawable.xztb_tc7;
                        } else if (i == R.id.tianxie) {
                            sp.edit().putString("xingzuo", "scorpio").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_28).commit();
                            sp.edit().putInt("index", 8).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_28);
                            xingzuo.setText("天蝎座");
                            riqi.setText("10.24-11.22");
                            drawableResId = R.drawable.xztb_tc8;
                        } else if (i == R.id.sheshou) {
                            sp.edit().putString("xingzuo", "sagittarius").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_29).commit();
                            sp.edit().putInt("index", 9).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_29);
                            xingzuo.setText("射手座");
                            riqi.setText("11.23-12.21");
                            drawableResId = R.drawable.xztb_tc9;
                        } else if (i == R.id.mojie) {
                            sp.edit().putString("xingzuo", "capricorn").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_30).commit();
                            sp.edit().putInt("index", 10).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_30);
                            xingzuo.setText("摩羯座");
                            riqi.setText("112.22-1.19");
                            drawableResId = R.drawable.xztb_tc10;
                        } else if (i == R.id.shuiping) {
                            sp.edit().putString("xingzuo", "aquarius").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_31).commit();
                            sp.edit().putInt("index", 11).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_31);
                            xingzuo.setText("水瓶座");
                            riqi.setText("1.20-2.18");
                            drawableResId = R.drawable.xztb_tc11;
                        } else if (i == R.id.shuangyu) {
                            sp.edit().putString("xingzuo", "pisces").commit();
                            sp.edit().putInt("head", R.drawable.icon_sx_32).commit();
                            sp.edit().putInt("index", 12).commit();
                            xingZuoHead.setImageResource(R.drawable.icon_sx_32);
                            xingzuo.setText("双鱼座");
                            riqi.setText("12.19-3.20");
                            drawableResId = R.drawable.xztb_tc12;
                        }
                        drawable = getResources().getDrawable(drawableResId);
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                        xingzuo.setCompoundDrawables(drawable, null, null, null);
                        getData();
                        yunshi.setBackgroundResource(R.drawable.bg_text);
                        yunshi.setTextColor(Color.WHITE);
                        dangan.setBackgroundColor(Color.TRANSPARENT);
                        dangan.setTextColor(getResources().getColor(R.color.text_bg_color));
                        manager.beginTransaction().hide(dangAnFragment).show(xingZuoYunShiFragment).commitAllowingStateLoss();
                        xingZuoYunShiFragment.notifyData();
                        show.dismiss();
                    }


                });
            }
        });
    }
}