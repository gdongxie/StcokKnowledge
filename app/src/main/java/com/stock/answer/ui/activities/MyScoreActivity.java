package com.stock.answer.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.stock.answer.R;
import com.stock.answer.base.BaseActivity;

public class MyScoreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_score);
    }

    public void onFinish(View view) {
        finish();
    }
}