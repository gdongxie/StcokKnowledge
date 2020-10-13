package com.stock.answer.ui.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.stock.answer.ui.activities.QuestionActivity;
import com.stock.answer.ui.adapter.BannerAdapter;
import com.stock.answer.ui.adapter.DataAdapter;
import com.stock.answer.ui.login.ui.login.LoginActivity;
import com.stock.answer.utils.SharedPreferencesUtil;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

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
        card_practice = root.findViewById(R.id.rl_practice);
        card_pastExam = root.findViewById(R.id.rl_past_exam);
        card_simulateExam = root.findViewById(R.id.rl_simulate_exam);
        rl_strength = root.findViewById(R.id.rl_strength);
        rl_random = root.findViewById(R.id.rl_random);
        rl_everyday = root.findViewById(R.id.rl_everyday);
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
        OkHttpUtils.get()
                .url("http://v.juhe.cn/toutiao/index?type=caijing&key=c10a52bbc484e6fbfc571cc40082a9ee")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
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
        bannerBean1.setImageRes(R.drawable.bg1);
        BannerBean bannerBean2 = new BannerBean();
        bannerBean2.setImageRes(R.drawable.bg2);
        BannerBean bannerBean3 = new BannerBean();
        bannerBean3.setImageRes(R.drawable.bg3);
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
            default:
                break;
        }
    }

}
