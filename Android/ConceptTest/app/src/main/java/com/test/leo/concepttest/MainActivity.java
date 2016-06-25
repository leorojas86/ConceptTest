package com.test.leo.concepttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new JSInterface(this), "JSInterface");
        //webView.loadUrl("http://google.com");
        webView.loadUrl("file:///android_asset/WebApplication/index.html");

    }
}
