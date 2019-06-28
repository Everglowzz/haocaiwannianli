package com.everglow.shell;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


import com.alibaba.android.arouter.launcher.ARouter;

import cn.jpush.android.api.JPushInterface;

/**
 * @author admin
 */
public class MyApplication extends Application  {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base); MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        APP = this;
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        ARouter.openLog();     // Print log
        ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        ARouter.init(this);
    }

    public static MyApplication APP;

    public static MyApplication getApplication() {
        return APP;
    }


}
