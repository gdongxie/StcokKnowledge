package com.stock.knowledge.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stock.knowledge.R;
import com.stock.knowledge.base.FinanceBean;
import com.stock.knowledge.ui.activities.WebViewActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class DataAdapter extends CommonAdapter<FinanceBean.ResultBean.DataBean> {
    public DataAdapter(Context context, int layoutId, List<FinanceBean.ResultBean.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, final FinanceBean.ResultBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_title, dataBean.getTitle());
        holder.setText(R.id.tv_author_name, "来源:" + dataBean.getAuthor_name());
        holder.setText(R.id.tv_time, dataBean.getDate());
        Glide.with(mContext).load(dataBean.getThumbnail_pic_s()).into((ImageView) holder.getView(R.id.iv_icon));
        holder.setOnClickListener(R.id.ll_content, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("title", dataBean.getTitle());
                intent.putExtra("url", dataBean.getUrl());
                mContext.startActivity(intent);
            }
        });
    }
}
