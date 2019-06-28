package com.everglow.shell;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by EverGlow on 2018/4/11 11:52
 */
public class WebFragment2 extends BaseWebView {
    
    public static WebFragment2 newInstance() {
        WebFragment2 fragment = new WebFragment2();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        goToWeb();
    }


    @Override
    public void hideBottom() {
        try {
            //定义javaScript方法
            String javascript = "javascript:(function() { " +
                    "document.getElementsByClassName('to_normal')[0].style.display='none'; " +
                    "document.getElementsByClassName('footer')[0].style.display='none'; " +


                    "})()";


            //加载方法
            mWebView.loadUrl(javascript);
            //执行方法
            mWebView.loadUrl("javascript:hideBottom();");

//            String javascript1 = "javascript:(function() { " +
//                    "document.getElementsByClassName('other-login')[0].style.display='none'; " +
//                    "})()";
////            //加载方法
//            mWebView.loadUrl(javascript1);
//            //执行方法
//            mWebView.loadUrl("javascript:hideBottom();");
//         
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void goToWeb() {
        mWebView.loadUrl(Api.UnlockFragmentUrl2);
    }

    
}
