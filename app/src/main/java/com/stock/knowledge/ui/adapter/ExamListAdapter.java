package com.stock.knowledge.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.stock.knowledge.R;
import com.stock.knowledge.base.ExamListBean;
import com.stock.knowledge.ui.activities.ExamActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * @ClassName: ExamListAdapter
 * @Description:
 * @Author: dongxie
 * @CreateDate: 2020/6/28 10:02
 */
public class ExamListAdapter extends CommonAdapter<ExamListBean> {
    public ExamListAdapter(Context context, int layoutId, List<ExamListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, final ExamListBean examListBean, int position) {
        holder.setText(R.id.tv_title, examListBean.getTitle());
        holder.setText(R.id.tv_num, "题目数量:" + examListBean.getNum());
        holder.setOnClickListener(R.id.card_item, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ExamActivity.class);
                intent.putExtra("title", examListBean.getTitle());
                intent.putExtra("id", examListBean.getId());
                intent.putExtra("num", examListBean.getNum());
                mContext.startActivity(intent);
            }
        });
    }
}