package com.stock.answer.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.crush.skipupdate.SplashCallback;
import com.crush.skipupdate.SplashRequest;
import com.stock.answer.R;
import com.stock.answer.utils.SharedPreferencesUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import okhttp3.Call;

public class SplashActivity extends AppCompatActivity {

    private TextView tv_app_name, tv_desc;
    private Typeface textTypeface, descTypeface;
    private AlphaAnimation alphaAnimation;
    private ImageView iv_web_icon;
    private ZLoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textTypeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts" +
                "/Lobster-1.4.otf");
        descTypeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts" +
                "/FZLanTingHeiS-L-GB-Regular.TTF");
        loadingDialog = new ZLoadingDialog(this);
        loadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)
                .setLoadingColor(getColor(R.color.colorLoading))
                .setCancelable(false)
                .setHintTextSize(16f)
                .setHintTextColor(getColor(R.color.colorWhite))
                .setDialogBackgroundColor(getColor(R.color.colorLoadingBackground));
        initView();
        check();
    }

    private void initView() {
        tv_app_name = findViewById(R.id.tv_app_name);
        tv_desc = findViewById(R.id.tv_splash_desc);
        tv_app_name.setTypeface(textTypeface);
        tv_desc.setTypeface(descTypeface);
        iv_web_icon = findViewById(R.id.iv_web_icon);
        alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                getData();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    private void check() {
        if (SharedPreferencesUtil.getBoolean(getApplicationContext(), "isAgree", false)) {
            iv_web_icon.startAnimation(alphaAnimation);
        } else {
            showPrivacy();
        }

    }

    private void redirectTo() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showPrivacy() {
        //  final PrivacyDialog dialog = new PrivacyDialog(SplashActivity.this);
        final Dialog dialog = new Dialog(SplashActivity.this, R.style.PrivacyThemeDialog);
        dialog.setContentView(R.layout.dialog_privacy);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        TextView tv_privacy_tips = dialog.findViewById(R.id.tv_privacy_tips);
        TextView btn_exit = dialog.findViewById(R.id.btn_exit);
        TextView btn_enter = dialog.findViewById(R.id.btn_enter);
        dialog.show();
        String string = getResources().getString(R.string.privacy_tips);
        String key1 = getResources().getString(R.string.privacy_tips_key1);
        String key2 = getResources().getString(R.string.privacy_tips_key2);
        int index1 = string.indexOf(key1);
        int index2 = string.indexOf(key2);
        //需要显示的字串
        SpannableString spannedString = new SpannableString(string);
        //设置点击字体颜色
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(getColor(R.color.colorRed));
        spannedString.setSpan(colorSpan1, index1, index1 + key1.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ForegroundColorSpan colorSpan2 = new ForegroundColorSpan(getColor(R.color.colorRed));
        spannedString.setSpan(colorSpan2, index2, index2 + key2.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //设置点击字体大小
        AbsoluteSizeSpan sizeSpan1 = new AbsoluteSizeSpan(18, true);
        spannedString.setSpan(sizeSpan1, index1, index1 + key1.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        AbsoluteSizeSpan sizeSpan2 = new AbsoluteSizeSpan(18, true);
        spannedString.setSpan(sizeSpan2, index2, index2 + key2.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //设置点击事件
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NotNull View view) {
                Intent intent = new Intent(SplashActivity.this, AgreementActivity.class);
                intent.putExtra("title", "用户协议");
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                //点击事件去掉下划线
                ds.setUnderlineText(false);
            }
        };
        spannedString.setSpan(clickableSpan1, index1, index1 + key1.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, AgreementActivity.class);
                intent.putExtra("title", "隐私政策");
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                //点击事件去掉下划线
                ds.setUnderlineText(false);
            }
        };
        spannedString.setSpan(clickableSpan2, index2, index2 + key2.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        //设置点击后的颜色为透明，否则会一直出现高亮
        tv_privacy_tips.setHighlightColor(Color.TRANSPARENT);
        //开始响应点击事件
        tv_privacy_tips.setMovementMethod(LinkMovementMethod.getInstance());

        tv_privacy_tips.setText(spannedString);

        //设置弹框宽度占屏幕的80%
        WindowManager m = getWindowManager();
        Display defaultDisplay = m.getDefaultDisplay();
        final WindowManager.LayoutParams params = Objects.requireNonNull(dialog.getWindow()).getAttributes();
        params.width = (int) (defaultDisplay.getWidth() * 0.80);
        dialog.getWindow().setAttributes(params);

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SharedPreferencesUtil.putBoolean(SplashActivity.this, "isAgree", false);
                finish();
            }
        });

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SharedPreferencesUtil.putBoolean(SplashActivity.this, "isAgree", true);
                getData();
            }
        });

    }

    private void getData() {
        loadingDialog.setHintText("正在加载...");
        loadingDialog.show();
        OkHttpUtils.get()
                .url("http://mock-api.com/vzMr1bgG.mock/appconfig")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        loadingDialog.dismiss();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("res", response);
                        SplashRequest.init(SplashActivity.this, response, new SplashCallback() {
                            @Override
                            public void onStartMainActivity() {
                                loadingDialog.dismiss();
                                redirectTo();

                            }
                        });
                    }
                });
    }
}
