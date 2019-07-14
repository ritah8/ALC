package com.nancy.alc_40;

import android.app.ProgressDialog;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class about extends AppCompatActivity {
        private Toolbar aboutToolbar;
        private WebView webView;
        private ProgressDialog progdiag;
    private static  final String URL ="https://andela.com/alc";
      // private static  final String URL ="https://medium.com/the-andela-way/andela-learning-community-growing-africa-5b67883404d1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutToolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolbar);
        getSupportActionBar().setTitle("About ALC");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


      progdiag = ProgressDialog.show(about.this,"Loading","please Wait ...",true);
      progdiag.setCancelable(false);
        webView =(WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        //following lines show the loader unti;; downloading of webpage is done
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                progdiag.show();
                view.loadUrl(URL);
                return  true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progdiag.dismiss();
            }
        });
        webView.loadUrl(URL);

   }

    //definition for WebViewClientAuthentication

}
