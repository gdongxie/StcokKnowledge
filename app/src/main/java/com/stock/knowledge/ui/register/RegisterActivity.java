package com.stock.knowledge.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.stock.knowledge.R;
import com.stock.knowledge.base.BaseActivity;
import com.stock.knowledge.ui.activities.AgreementActivity;
import com.stock.knowledge.ui.activities.SplashActivity;

import org.w3c.dom.Text;

public class RegisterActivity extends BaseActivity {
    private TextView tv_protocol, tv_privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setListener();
    }

    private void initView() {
        tv_protocol = findViewById(R.id.tv_protocol);
        tv_privacy = findViewById(R.id.tv_privacy);
    }

    private void setListener() {
        tv_protocol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, AgreementActivity.class);
                intent.putExtra("title", "用户协议");
                startActivity(intent);
            }
        });
        tv_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, AgreementActivity.class);
                intent.putExtra("title", "隐私政策");
                startActivity(intent);
            }
        });
    }
}
