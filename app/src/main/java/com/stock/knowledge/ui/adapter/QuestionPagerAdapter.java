package com.stock.knowledge.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.stock.knowledge.R;
import com.stock.knowledge.beans.HomeworkQuestionBean;
import com.stock.knowledge.beans.HomeworkQuestionTypeBean;
import com.stock.knowledge.view.BaseHomeworkQuestionWidget;

import java.util.ArrayList;

/**
 * @Author yinzh
 * @Date 2019/8/13 14:16
 * @Description
 */
public class QuestionPagerAdapter extends PagerAdapter {


    protected LayoutInflater inflater;
    protected Context mContext;
    protected ArrayList<HomeworkQuestionBean> mList;


    public QuestionPagerAdapter(Context context, ArrayList<HomeworkQuestionBean> list) {
        mList = list;
        mContext = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        HomeworkQuestionBean questionBean = mList.get(position);

        View view = switchQuestionWidget(questionBean, position + 1, mList.size());
        ScrollView scrollView = new ScrollView(mContext);
        scrollView.setFillViewport(true);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        container.addView(scrollView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return scrollView;
    }


    private View switchQuestionWidget(HomeworkQuestionBean question, int index, int totalNum) {
        BaseHomeworkQuestionWidget mWidget;
        HomeworkQuestionTypeBean typeBean = question.getType();
        if (typeBean == HomeworkQuestionTypeBean.material) {
            typeBean = question.getItems().get(0).getType();
        }
        int layoutId = 0;
        switch (typeBean) {
            case choice://多选
            case uncertain_choice://不定向
                layoutId = R.layout.item_pager_homework_question_choice;
                break;
            case single_choice://单选题
                layoutId = R.layout.item_pager_homework_question_singlechoice;
                break;
            case essay://问答题
                layoutId = R.layout.item_pager_homework_question_essay;
                break;
            case determine://判断题
                layoutId = R.layout.item_pager_homework_question_determine;
                break;
            case material://材料题
                layoutId = R.layout.item_pager_homework_question_material;
                break;
            case fill:
                layoutId = R.layout.item_pager_homework_question_material;
                break;
            default:
                break;
        }
        mWidget = (BaseHomeworkQuestionWidget) LayoutInflater.from(mContext).inflate(layoutId,
                null);
        mWidget.setData(question, index, totalNum);
        return mWidget;
    }


}
