package com.stock.answer.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stock.answer.R;
import com.stock.answer.beans.FinanceBean;
import com.stock.answer.ui.adapter.DataAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import org.jetbrains.annotations.NotNull;

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
public class DataFragment extends Fragment {

    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private List<FinanceBean.ResultBean.DataBean> dataBeanList = new ArrayList<>();
    private ZLoadingDialog loadingDialog;

    public static DataFragment newInstance() {
        DataFragment fragment = new DataFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_data, container, false);
        initView(root);
        getData();
        return root;
    }

    private void initView(View root) {
        refreshLayout = root.findViewById(R.id.refreshLayout);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataAdapter = new DataAdapter(getContext(), R.layout.item_finance, dataBeanList);
        recyclerView.setAdapter(dataAdapter);
        refreshLayout.setDragRate(0.5f);
        refreshLayout.setReboundDuration(300);
        refreshLayout.setHeaderHeight(100);
        loadingDialog = new ZLoadingDialog(Objects.requireNonNull(getActivity()));
        loadingDialog.setLoadingBuilder(Z_TYPE.ROTATE_CIRCLE)
                .setLoadingColor(getActivity().getColor(R.color.colorLoading))
                .setCancelable(false)
                .setHintTextSize(16f)
                .setHintTextColor(getActivity().getColor(R.color.colorWhite))
                .setDialogBackgroundColor(getActivity().getColor(R.color.colorLoadingBackground));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NotNull final RefreshLayout refreshlayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshlayout.finishRefresh(true);
                    }
                }, 1000);

            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NotNull final RefreshLayout refreshlayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshlayout.finishLoadMore(true);
                    }
                }, 1000);

            }

        });
    }

    private void getData() {
        OkHttpUtils.get()
                .url("http://v.juhe.cn/toutiao/index?type=top&key=c10a52bbc484e6fbfc571cc40082a9ee")
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

}
