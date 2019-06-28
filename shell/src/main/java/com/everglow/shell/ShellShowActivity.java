package com.everglow.shell;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.everglow.mimixiao.JieMengActivity;
import com.everglow.mimixiao.ShengXiaoActivity;
import com.everglow.mimixiao.XingZuoActivity;
import com.example.wannianli.WannianliActivity;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


public class ShellShowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shellactivity_show);

        findViewById(R.id.im1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShellShowActivity.this, WannianliActivity.class));
//                ARouter.getInstance().build("/weather/activity").navigation();
            }
        });
        findViewById(R.id.im2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShellShowActivity.this, ShengXiaoActivity.class));
            }
        });
        findViewById(R.id.im3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShellShowActivity.this, XingZuoActivity.class));
            }
        });
        findViewById(R.id.im4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShellShowActivity.this, JieMengActivity.class));
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                Toast.makeText(this, "再点击一次退出应用", Toast.LENGTH_SHORT).show();
                isExit = true;
                Timer tExit = new Timer();
                tExit.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            } else {
                finish();
            }
        }
        return false;
    }

    private static Boolean isExit = false;
}