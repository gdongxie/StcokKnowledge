package com.stock.answer.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stock.answer.R;
import com.stock.answer.base.BaseActivity;
import com.stock.answer.ui.login.ui.login.LoginActivity;
import com.stock.answer.utils.SharedPreferencesUtil;

public class KnowledgeDetailsActivity extends BaseActivity {
    private ImageView imageView, iv_collecting;
    private TextView tv_title, tv_content;
    private boolean isCollected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_details);
        imageView = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        iv_collecting = findViewById(R.id.iv_collecting);
        tv_content = findViewById(R.id.tv_details);
        imageView.setOnClickListener(v -> finish());
        tv_title.setText(getIntent().getStringExtra("title"));
        tv_content.setText(getIntent().getStringExtra("content"));

        iv_collecting.setOnClickListener(v -> {
            if (SharedPreferencesUtil.getBoolean(getApplicationContext(), "isLogin", false)) {
                if (!isCollected) {
                    iv_collecting.setImageResource(R.mipmap.collected);
                    Toast.makeText(KnowledgeDetailsActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                    isCollected = true;
                } else {
                    iv_collecting.setImageResource(R.mipmap.uncollect);
                    Toast.makeText(KnowledgeDetailsActivity.this, "取消收藏成功", Toast.LENGTH_SHORT).show();
                    isCollected = false;
                }
            } else {
                Intent intent = new Intent(KnowledgeDetailsActivity.this, LoginActivity.class);
                startActivity(intent);

            }

        });
    }
}
