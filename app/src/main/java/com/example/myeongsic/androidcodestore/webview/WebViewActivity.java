package com.example.myeongsic.androidcodestore.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myeongsic.androidcodestore.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webViewActivity_webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");
    }
}
