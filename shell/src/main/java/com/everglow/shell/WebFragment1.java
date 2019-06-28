package com.everglow.shell;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by EverGlow on 2018/4/11 11:52
 */
public class WebFragment1 extends BaseWebView {
    
    public static WebFragment1 newInstance() {
        WebFragment1 fragment = new WebFragment1();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        goToWeb();
    }




    private void goToWeb() {
        mWebView.loadUrl(Api.UnlockFragmentUrl1);
    }

    
}
