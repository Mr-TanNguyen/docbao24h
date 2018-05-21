package com.t3h.buoi10.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.t3h.buoi10.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initViews();
    }

    private void initViews() {
        initDialog();
        webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setSupportZoom(true);
        String link = getIntent().getStringExtra("KEY_LINK_NEWS");
        webView.loadUrl(link);
        webView.setWebViewClient(webViewClient);
        progressDialog.show();
    }

    private void initDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.setCancelable(false);
    }


    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }


    };

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
