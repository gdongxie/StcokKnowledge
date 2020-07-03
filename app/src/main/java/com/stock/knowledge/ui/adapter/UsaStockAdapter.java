package com.stock.knowledge.ui.adapter;

import android.content.Context;
import android.graphics.Color;

import com.stock.knowledge.R;
import com.stock.knowledge.base.UsaStockBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.math.BigDecimal;
import java.util.List;

public class UsaStockAdapter extends CommonAdapter<UsaStockBean.ResultBean.DataBean> {
    public UsaStockAdapter(Context context, int layoutId, List<UsaStockBean.ResultBean.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, UsaStockBean.ResultBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_stockName, dataBean.getCname());
        holder.setText(R.id.tv_lastTrade, dataBean.getPrice());
        if (dataBean.getAmplitude().contains("-")) {
            holder.setTextColor(R.id.changePercent, Color.parseColor("#32CD32"));
            String[] strings = dataBean.getAmplitude().split("-");
            holder.setText(R.id.changePercent, strings[1]);
        } else {
            holder.setTextColor(R.id.changePercent, Color.parseColor("#FF3030"));
            holder.setText(R.id.changePercent, dataBean.getAmplitude());
        }
    }
}
