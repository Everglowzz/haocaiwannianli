package com.everglow.mimixiao;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by EverGlow on 2019/6/21 22:33
 */
public    class DangAnActivity extends AppCompatActivity   {
    int fontSize = 1;

    private TextView title;

    private WebView webView;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_dang_an);
        this.title = (TextView)findViewById(R.id.title);
        this.webView = (WebView)findViewById(R.id.wv);
        Intent intent = getIntent();
        this.title.setText(intent.getStringExtra("title"));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(intent.getStringExtra("url"));
        WebSettings webSettings = this.webView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4 && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        finish();
        return false;
    }
}
