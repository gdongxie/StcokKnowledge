package com.stock.knowledge.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.stock.knowledge.R;
import com.stock.knowledge.beans.KnowledgeBean;
import com.stock.knowledge.ui.activities.KnowledgeDetailsActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class KonwledgeAdapter extends CommonAdapter<KnowledgeBean> {

    public KonwledgeAdapter(Context context, int layoutId, List<KnowledgeBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, final KnowledgeBean dataBean, int position) {
        holder.setText(R.id.tv_title, dataBean.getTitle());
        holder.setText(R.id.tv_content, dataBean.getContent());
        holder.setOnClickListener(R.id.item_layout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, KnowledgeDetailsActivity.class);
                intent.putExtra("title", dataBean.getTitle());
                intent.putExtra("content", dataBean.getContent());
                mContext.startActivity(intent);
            }
        });
    }
}
