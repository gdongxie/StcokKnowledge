package com.stock.answer.ui.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.stock.answer.R;
import com.stock.answer.beans.BannerBean;
import com.stock.answer.beans.FinanceBean;
import com.stock.answer.ui.activities.ExamListActivity;
import com.stock.answer.ui.activities.MyActivity;
import com.stock.answer.ui.activities.QuestionActivity;
import com.stock.answer.ui.activities.WebViewActivity;
import com.stock.answer.ui.adapter.BannerAdapter;
import com.stock.answer.ui.adapter.DataAdapter;
import com.stock.answer.ui.login.ui.login.LoginActivity;
import com.stock.answer.utils.SharedPreferencesUtil;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;

/**
 * @ClassName: DataFragment
 * @Description:
 * @Author: dongxie
 * @CreateDate: 2020/6/23 20:18
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private RelativeLayout card_practice, card_pastExam, card_simulateExam, rl_strength,
            rl_random, rl_everyday;
    private Banner banner;
    private List<BannerBean> bannerBeans = new ArrayList<>();
    private TextView textView;
    private Typeface textTypeface;
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private ZLoadingDialog loadingDialog;
    private ImageView iv_login;
    private List<FinanceBean.ResultBean.DataBean> dataBeanList = new ArrayList<>();

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(root);
        getData();
        return root;
    }

    private void initViews(View root) {
        loadingDialog = new ZLoadingDialog(getActivity());
        loadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)
                .setLoadingColor(getActivity().getColor(R.color.colorLoading))
                .setCancelable(false)
                .setHintTextSize(16f)
                .setHintTextColor(getActivity().getColor(R.color.colorWhite))
                .setDialogBackgroundColor(getActivity().getColor(R.color.colorLoadingBackground));
        card_practice = root.findViewById(R.id.rl_practice);
        card_pastExam = root.findViewById(R.id.rl_past_exam);
        card_simulateExam = root.findViewById(R.id.rl_simulate_exam);
        rl_strength = root.findViewById(R.id.rl_strength);
        rl_random = root.findViewById(R.id.rl_random);
        rl_everyday = root.findViewById(R.id.rl_everyday);
        iv_login = root.findViewById(R.id.iv_login);
        banner = root.findViewById(R.id.banner);
        textView = root.findViewById(R.id.tv_new);
        textTypeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets()
                , "fonts" +
                        "/FZLanTingHeiS-DB1-GB-Regular.TTF");
        textView.setTypeface(textTypeface);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataAdapter = new DataAdapter(getContext(), R.layout.item_finance, dataBeanList);
        recyclerView.setAdapter(dataAdapter);
        initBanner();
        initListener();

    }

    private void getData() {
        loadingDialog.setHintText("正在加载...");
        loadingDialog.show();
        OkHttpUtils.get()
                .url("http://v.juhe.cn/toutiao/index?type=caijing&key=01ed1debad9af88466463967f7593d0e")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        loadingDialog.dismiss();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        loadingDialog.dismiss();
                        FinanceBean financeBean = new Gson().fromJson(response, FinanceBean.class);
                        if (0 == financeBean.getError_code()) {
                            dataBeanList.addAll(financeBean.getResult().getData());
                            dataAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), financeBean.getReason(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initBanner() {
        BannerBean bannerBean1 = new BannerBean();
        bannerBean1.setImgUrl("https://swdlcdn.eastmoney.com/app/adimg/bf0c8728-989e-4062-8759-598542922278.png");
        bannerBean1.setJumpUrl("https://act.1234567.com.cn/zt/1602570017149?spm=jd&_track=ad.click&_trackid=221000002396252334");
        bannerBean1.setTitle("");
        BannerBean bannerBean2 = new BannerBean();
        bannerBean2.setImgUrl("https://swdlcdn.eastmoney.com/app/adimg/499b1c65-0798-4588-a109-6b371e565992.png");
        bannerBean2.setJumpUrl("https://marketing.eastmoney.com/activitytemplate/?activityId=403&_track=ad.click&_trackid=221000002450932330");
        bannerBean2.setTitle("");
        BannerBean bannerBean3 = new BannerBean();
        bannerBean3.setImgUrl("https://swdlcdn.eastmoney.com/app/adimg/4395b437-ff4e-4f06-80ae-127a5a741b73.png");
        bannerBean3.setJumpUrl("https://act.1234567.com.cn/topic/2020/eastmoney-etf-topic/?spm=003001.jd&_track=ad.click&_trackid=221000001500096322");
        bannerBean3.setTitle("");
        bannerBeans.add(bannerBean1);
        bannerBeans.add(bannerBean2);
        bannerBeans.add(bannerBean3);
        banner.addBannerLifecycleObserver(this)
                .setAdapter(new BannerAdapter(bannerBeans))
                .setIndicator(new CircleIndicator(Objects.requireNonNull(getActivity()).getApplicationContext()))
                .start();
    }

    private void initListener() {
        card_practice.setOnClickListener(this);
        card_pastExam.setOnClickListener(this);
        card_simulateExam.setOnClickListener(this);
        rl_strength.setOnClickListener(this);
        rl_random.setOnClickListener(this);
        rl_everyday.setOnClickListener(this);
        iv_login.setOnClickListener(this);
        banner.setOnBannerListener((data, position) -> {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra("url", bannerBeans.get(position).getJumpUrl());
            intent.putExtra("title", bannerBeans.get(position).getTitle());
            getActivity().startActivity(intent);
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_practice:
                if (SharedPreferencesUtil.getBoolean(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "isLogin", false)) {
                    Intent intent = new Intent(getContext(), ExamListActivity.class);
                    intent.putExtra("title", "章节练习");
                    getActivity().startActivity(intent);
                } else {
                    getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.rl_past_exam:
                if (SharedPreferencesUtil.getBoolean(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "isLogin", false)) {
                    Intent intent = new Intent(getContext(), ExamListActivity.class);
                    intent.putExtra("title", "历年真题");
                    getActivity().startActivity(intent);
                } else {
                    getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.rl_simulate_exam:
                if (SharedPreferencesUtil.getBoolean(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "isLogin", false)) {
                    Intent intent = new Intent(getContext(), ExamListActivity.class);
                    intent.putExtra("title", "模拟考试");
                    getActivity().startActivity(intent);
                } else {
                    getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.rl_strength:
                if (SharedPreferencesUtil.getBoolean(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "isLogin", false)) {
                    Intent intent = new Intent(getContext(), ExamListActivity.class);
                    intent.putExtra("title", "巩固模拟");
                    getActivity().startActivity(intent);
                } else {
                    getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.rl_random:
                if (SharedPreferencesUtil.getBoolean(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "isLogin", false)) {
                    Intent intent = new Intent(getContext(), QuestionActivity.class);
                    intent.putExtra("title", "随机检验");
                    intent.putExtra("id", 4);
                    intent.putExtra("num", "29");
                    getActivity().startActivity(intent);
                } else {
                    getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.rl_everyday:
                if (SharedPreferencesUtil.getBoolean(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "isLogin", false)) {
                    Intent intent = new Intent(getContext(), QuestionActivity.class);
                    intent.putExtra("title", "每日一练");
                    intent.putExtra("id", 7);
                    intent.putExtra("num", "13");
                    getActivity().startActivity(intent);
                } else {
                    getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.iv_login:
                getActivity().startActivity(new Intent(getContext(), MyActivity.class));
                break;
            default:
                break;
        }
    }

}
