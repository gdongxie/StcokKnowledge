package com.stock.knowledge.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stock.knowledge.R;
import com.stock.knowledge.base.HkStockBean;
import com.stock.knowledge.net.ApiService;
import com.stock.knowledge.net.RetrofitUtils;
import com.stock.knowledge.ui.adapter.HkStockAdapter;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: DataFragment
 * @Description:
 * @Author: dongxie
 * @CreateDate: 2020/6/23 20:18
 */
public class HKStocksFragment extends Fragment {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<HkStockBean.ResultBean.DataBean> dataBeanList = new ArrayList<>();
    private HkStockAdapter dataAdapter;
    private CompositeDisposable disposable = new CompositeDisposable();
    private int page = 1;

    public static HKStocksFragment newInstance() {
        HKStocksFragment fragment = new HKStocksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hk_stock, container, false);
        initView(root);
        getData();
        return root;
    }

    private void initView(View root) {
        refreshLayout = root.findViewById(R.id.refreshLayout);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataAdapter = new HkStockAdapter(getContext(), R.layout.item_list_stock, dataBeanList);
        recyclerView.setAdapter(dataAdapter);
        refreshLayout.setDragRate(0.5f);
        refreshLayout.setReboundDuration(300);
        refreshLayout.setHeaderHeight(100);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                dataBeanList.clear();
                page = 1;
                getData();
                refreshlayout.finishRefresh(true);
            }
        });

//        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(final RefreshLayout refreshlayout) {
//                page += 1;
//                getData();
//                refreshlayout.finishLoadMore(true);
//            }
//
//        });
    }

    private void getData() {
        disposable.add(
                RetrofitUtils.INSTANCE.getApiService(ApiService.class)
                        .getHkStocks(page)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<HkStockBean>() {
                            @Override
                            public void accept(HkStockBean hkStockBean) throws Exception {
                                if (0 == hkStockBean.getError_code()) {
                                    if (hkStockBean.getResult().getData().size() > 0) {
                                        for (int i = 0; i < hkStockBean.getResult().getData().size(); i++) {
                                            dataBeanList.addAll(hkStockBean.getResult().getData());
                                        }
                                        dataAdapter.notifyDataSetChanged();
                                    } else {
                                        Toast.makeText(getContext(), "暂无数据", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(getContext(), hkStockBean.getReason(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        })
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
