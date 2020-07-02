package com.stock.knowledge.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stock.knowledge.R;
import com.stock.knowledge.base.BaseActivity;
import com.stock.knowledge.ui.activities.AgreementActivity;
import com.stock.knowledge.ui.activities.SplashActivity;
import com.stock.knowledge.ui.login.ui.login.LoginActivity;
import com.stock.knowledge.utils.AssetsDatabaseManager;

import org.w3c.dom.Text;

public class RegisterActivity extends BaseActivity {
    private TextView tv_protocol, tv_privacy;
    private ImageView iv_back;
    private EditText et_username, et_password, et_confirmPwd;
    private Button btn_register;
    private AssetsDatabaseManager databaseManager = AssetsDatabaseManager.getManager();
    private static final String telRegex = "^((13[0-9])|(14[5,6,7,9])|(15[^4])|(16[5,6])|(17[0-9])|(18[0-9])|" +
            "(19[1,8,9]))\\d{8}$";

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
        iv_back = findViewById(R.id.iv_back);
        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        et_confirmPwd = findViewById(R.id.password_confirm);
        btn_register = findViewById(R.id.btn_register);
        tv_protocol = findViewById(R.id.tv_protocol);
    }

    private void setListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    private void register() {
        if (et_username.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
        } else if (!et_username.getText().toString().trim().matches(telRegex)) {
            Toast.makeText(RegisterActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
        } else if (et_password.getText().toString().trim().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        } else if (et_password.getText().toString().trim().length() < 6) {
            Toast.makeText(RegisterActivity.this, "密码不能少于6位", Toast.LENGTH_SHORT).show();
        } else if (!et_confirmPwd.getText().toString().trim().equals(et_password.getText().toString().trim())) {
            Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
        } else {
            loadingDialog.show();
            SQLiteDatabase sqLiteDatabase = databaseManager.getDatabase("gupiao.db");
            ContentValues contentValues = new ContentValues();
            contentValues.put("mobile", et_username.getText().toString().trim());
            contentValues.put("password", et_password.getText().toString().trim());
            final long l = sqLiteDatabase.insert("user", null, contentValues);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.dismiss();
                    if (l > 0L) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败,该账号已存在！",
                                Toast.LENGTH_SHORT).show();
                    }
                    databaseManager.closeDatabase("gupiao.db");
                }
            }, 1000);
        }
    }
}
