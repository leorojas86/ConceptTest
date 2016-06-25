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
        //WebSettings webSettings = webView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http://google.com");
        webView.loadUrl("file:///android_asset/WebApplication/index.html");

    }
}
