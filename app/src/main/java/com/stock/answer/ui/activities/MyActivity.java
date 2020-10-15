package com.stock.answer.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.immersionbar.ImmersionBar;
import com.stock.answer.R;
import com.stock.answer.ui.login.ui.login.LoginActivity;
import com.stock.answer.utils.AssetsDatabaseManager;
import com.stock.answer.utils.SharedPreferencesUtil;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.Objects;

public class MyActivity extends AppCompatActivity {
    private LinearLayout ll_login;
    private TextView tv_username, tv_miaoshu;
    private RelativeLayout rl_suggest, rl_update, rl_about, rl_logOut, rl_tuichu, rl_jifen, rl_collect;
    private Intent intent;
    private ZLoadingDialog loadingDialog;
    private AssetsDatabaseManager databaseManager = AssetsDatabaseManager.getManager();
    private ImageView iv_back, iv_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ImmersionBar.with(this).statusBarColor(R.color.hongfen).fitsSystemWindows(true).statusBarDarkFont(true).init();
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SharedPreferencesUtil.getBoolean(getApplicationContext(), "isLogin", false)) {
            tv_username.setText("欢迎");
            rl_logOut.setVisibility(View.VISIBLE);
            rl_tuichu.setVisibility(View.VISIBLE);
            tv_miaoshu.setText(SharedPreferencesUtil.getString(getApplicationContext(), "username", ""));
        } else {
            tv_username.setText("立即登录/注册");
            tv_miaoshu.setText("点击登录\u3000享受更多精彩信息");
            rl_logOut.setVisibility(View.INVISIBLE);
            rl_tuichu.setVisibility(View.INVISIBLE);
        }
    }

    private void initView() {
        ll_login = findViewById(R.id.ll_login);
        tv_username = findViewById(R.id.tv_username);
        rl_suggest = findViewById(R.id.rl_suggest);
        rl_update = findViewById(R.id.rl_update);
        rl_about = findViewById(R.id.rl_about);
        rl_logOut = findViewById(R.id.rl_logOut);
        rl_tuichu = findViewById(R.id.rl_tuichu);
        rl_jifen = findViewById(R.id.rl_jifen);
        rl_collect = findViewById(R.id.rl_collect);
        iv_back = findViewById(R.id.iv_back);
        iv_setting = findViewById(R.id.iv_setting);
        tv_miaoshu = findViewById(R.id.tv_miaoshu);
        loadingDialog = new ZLoadingDialog(this);
        loadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)
                .setLoadingColor(getColor(R.color.colorLoading))
                .setCancelable(false)
                .setHintTextSize(16f)
                .setHintTextColor(getColor(R.color.colorWhite))
                .setDialogBackgroundColor(getColor(R.color.colorLoadingBackground));
        iv_back.setOnClickListener(v -> finish());
        iv_setting.setOnClickListener(v -> startActivity(new Intent(MyActivity.this, SettingActivity.class)));
        ll_login.setOnClickListener(v -> {
            if (!SharedPreferencesUtil.getBoolean(getApplicationContext(), "isLogin", false)) {
                intent = new Intent(MyActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        rl_jifen.setOnClickListener(v -> {
            if (SharedPreferencesUtil.getBoolean(getApplicationContext(), "isLogin", false)) {
                intent = new Intent(MyActivity.this, MyScoreActivity.class);
            } else {
                intent = new Intent(MyActivity.this, LoginActivity.class);
            }
            startActivity(intent);
        });
        rl_collect.setOnClickListener(v -> {
            if (SharedPreferencesUtil.getBoolean(getApplicationContext(), "isLogin", false)) {
                intent = new Intent(MyActivity.this, CollectActivity.class);
            } else {
                intent = new Intent(MyActivity.this, LoginActivity.class);
            }
            startActivity(intent);
        });
        rl_tuichu.setOnClickListener(v -> {
            loadingDialog.setHintText("退出中...");
            loadingDialog.show();
            new Handler().postDelayed(() -> {
                loadingDialog.dismiss();
                Toast.makeText(MyActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                SharedPreferencesUtil.putBoolean(getApplicationContext(),
                        "isLogin", false);
                tv_username.setText("立即登录/注册");
                tv_miaoshu.setText("点击登录\u3000享受更多精彩信息");
                rl_logOut.setVisibility(View.INVISIBLE);
                rl_tuichu.setVisibility(View.INVISIBLE);
            }, 1000);

        });

        rl_suggest.setOnClickListener(v -> startActivity(new Intent(MyActivity.this, FeedBackActivity.class)));
        rl_update.setOnClickListener(v -> {
            loadingDialog.show();
            new Handler().postDelayed(() -> {
                loadingDialog.dismiss();
                Toast.makeText(MyActivity.this, "当前已是最新版本", Toast.LENGTH_SHORT).show();
            }, 1000);
        });

        rl_about.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
            builder.setTitle("关于我们");
            builder.setMessage("大牛股助手\n专业全面的股票答题软件\n当前版本：V1.0.0");
            builder.setCancelable(false);
            builder.setPositiveButton("确定", (dialog, which) -> dialog.dismiss());
            builder.show();
        });
        rl_logOut.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
            builder.setTitle("提示");
            builder.setCancelable(false);
            builder.setMessage("注销操作不可逆，是否确定注销当前账号？");
            builder.setPositiveButton("确定", (dialog, which) -> {
                SQLiteDatabase sqLiteDatabase = databaseManager.getDatabase("gupiao.db");
                String[] args =
                        {SharedPreferencesUtil.getString(getApplicationContext(),
                                "username", "")};
                final int i = sqLiteDatabase.delete("user", "mobile=?", args);
                loadingDialog.setHintText("注销中...");
                loadingDialog.show();
                new Handler().postDelayed(() -> {
                    if (i > 0) {
                        loadingDialog.dismiss();
                        Toast.makeText(MyActivity.this, "注销成功",
                                Toast.LENGTH_SHORT).show();
                        SharedPreferencesUtil.putBoolean(getApplicationContext(),
                                "isLogin", false);
                        tv_username.setText("立即登录/注册");
                        tv_miaoshu.setText("点击登录\u3000享受更多精彩信息");
                        rl_logOut.setVisibility(View.INVISIBLE);
                        rl_tuichu.setVisibility(View.INVISIBLE);
                    } else {
                        loadingDialog.dismiss();
                        Toast.makeText(MyActivity.this,
                                "注销失败，请稍后重试",
                                Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            });
            builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());
            builder.show();

        });

    }
}