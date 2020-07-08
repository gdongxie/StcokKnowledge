package com.stock.knowledge.ui.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.stock.knowledge.R;
import com.stock.knowledge.base.BaseActivity;

public class KnowledgeDetailsActivity extends BaseActivity {
    private ImageView imageView;
    private TextView tv_title, tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_details);
        imageView = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_details);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title.setText(getIntent().getStringExtra("title"));
        tv_content.setText(getIntent().getStringExtra("content"));
    }
}
