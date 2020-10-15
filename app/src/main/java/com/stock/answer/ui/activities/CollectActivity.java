package com.stock.answer.ui.activities;


import android.os.Bundle;
import android.view.View;

import com.stock.answer.R;
import com.stock.answer.base.BaseActivity;

public class CollectActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
    }

    public void onBack(View view) {
        finish();
    }
}