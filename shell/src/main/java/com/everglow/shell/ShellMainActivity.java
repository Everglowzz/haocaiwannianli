package com.everglow.shell;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
@Route(path = "/app/activity")
public class ShellMainActivity extends AppCompatActivity {
    BottomBar mBottomBar;
    FrameLayout mMainFrame;
    private List<Fragment> mFragments;
    private int mReplace = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shellactivity_main);
        mBottomBar = findViewById(R.id.bottomBar);
        mMainFrame = findViewById(R.id.main_frame);
        initView();
    }

    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(int tabId) {
            switch (tabId) {
                case R.id.tab_home:
                    mReplace = 0;
                    break;
                case R.id.tab_shop:
                    mReplace = 1;
                    break;
                case R.id.tab_discover:
                    mReplace = 2;
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,mFragments.get(mReplace)).commitAllowingStateLoss();
        }
    };
    

    private void initView() {
        mFragments = new ArrayList<>();
        mFragments.add(WebFragment1.newInstance());
        mFragments.add(WebFragment2.newInstance());
        mFragments.add(WebFragment3.newInstance());
        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);
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
