package com.example.roshanakhan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Spotify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spotify);
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://open.spotify.com/browse/featured?utm_campaign=redirect.webplayerlink&utm_content=624ffab985781bcb6741482f2f1e71d8&utm_medium=www_footer&utm_source=www.spotify.com");
    }
}
