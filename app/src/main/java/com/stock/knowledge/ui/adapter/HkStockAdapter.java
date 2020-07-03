package com.stock.knowledge.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.stock.knowledge.R;
import com.stock.knowledge.base.HkStockBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class HkStockAdapter extends CommonAdapter<HkStockBean.ResultBean.DataBean> {

    public HkStockAdapter(Context context, int layoutId, List<HkStockBean.ResultBean.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, HkStockBean.ResultBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_stockName, dataBean.getName());
        BigDecimal bigDecimal = new BigDecimal(dataBean.getLasttrade());
        holder.setText(R.id.tv_lastTrade, bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        if (dataBean.getChangepercent().contains("-")) {
            holder.setTextColor(R.id.changePercent, Color.parseColor("#32CD32"));
            String[] strings = dataBean.getChangepercent().split("-");
            BigDecimal bigDecimals = new BigDecimal(strings[1]);
            holder.setText(R.id.changePercent, bigDecimals.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "%");
        } else {
            holder.setTextColor(R.id.changePercent, Color.parseColor("#FF3030"));
            BigDecimal bigDecimals = new BigDecimal(dataBean.getChangepercent());
            holder.setText(R.id.changePercent, bigDecimals.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "%");
        }
    }
}
