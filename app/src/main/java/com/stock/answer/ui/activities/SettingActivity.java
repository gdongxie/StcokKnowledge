package com.stock.answer.ui.activities;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.stock.answer.R;
import com.stock.answer.base.BaseActivity;

public class SettingActivity extends BaseActivity {
    private ImageView iv_back;
    private RelativeLayout rl_cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        iv_back = findViewById(R.id.iv_back);
        rl_cache = findViewById(R.id.rl_cache);
        iv_back.setOnClickListener(v -> finish());
        rl_cache.setOnClickListener(v -> Toast.makeText(SettingActivity.this, "当前暂无可清除缓存", Toast.LENGTH_SHORT).show());
    }
}