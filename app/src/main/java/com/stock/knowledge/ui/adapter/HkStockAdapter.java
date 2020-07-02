package com.stock.knowledge.ui.adapter;

import android.content.Context;

import com.stock.knowledge.R;
import com.stock.knowledge.base.HkStockBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class HkStockAdapter extends CommonAdapter<HkStockBean.ResultBean.DataBean> {

    public HkStockAdapter(Context context, int layoutId, List<HkStockBean.ResultBean.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, HkStockBean.ResultBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_stockName, dataBean.getName());
        holder.setText(R.id.tv_lastTrade, dataBean.getLasttrade());
        holder.setText(R.id.changePercent, dataBean.getChangepercent());
    }
}
