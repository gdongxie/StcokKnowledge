package com.stock.answer.ui.activities;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.stock.answer.R;
import com.stock.answer.base.BaseActivity;

public class AgreementActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        WebView webView = findViewById(R.id.webView);
        ImageView iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        webView.loadUrl("file:////android_asset/html/policy.html");
    }
}
