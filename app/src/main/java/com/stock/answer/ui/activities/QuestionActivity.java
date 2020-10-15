package com.stock.answer.ui.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.stock.answer.R;
import com.stock.answer.beans.HomeworkAnswerBean;
import com.stock.answer.beans.HomeworkQuestionBean;
import com.stock.answer.beans.HomeworkQuestionTypeBean;
import com.stock.answer.ui.adapter.QuestionPagerAdapter;
import com.stock.answer.ui.fragments.HomeworkCardFragment;
import com.stock.answer.utils.AssetsDatabaseManager;
import com.stock.answer.utils.FastClickUtil;
import com.stock.answer.view.HomeWorkViewPager;
import com.stock.answer.view.MessageEvent;
import com.stock.answer.view.SureNoTitleDialog;
import com.stock.answer.view.SureTitleDialog;
import com.supermax.base.common.viewbind.annotation.Bind;
import com.supermax.base.common.widget.toast.QsToast;
import com.supermax.base.mvp.QsABActivity;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

public class QuestionActivity extends QsABActivity implements View.OnClickListener {
    @Bind(R.id.ll_back)
    LinearLayout ll_back;
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.view_pager)
    HomeWorkViewPager view_pager;
    @Bind(R.id.ll_card)
    LinearLayout ll_card;
    @Bind(R.id.ll_finish)
    LinearLayout ll_finish;
    public ArrayList<HomeworkAnswerBean> answerList = new ArrayList<>();
    public ArrayList<HomeworkQuestionBean> mQuestionList = new ArrayList<>();
    private SureTitleDialog mTitleDialog;
    private SureNoTitleDialog mSubmitDialog;
    private QuestionPagerAdapter mAdapter;
    private int id;
    private AssetsDatabaseManager assetsDatabaseManager = AssetsDatabaseManager.getManager();
    protected int mCurrentIndex;

    @Override
    public int actionbarLayoutId() {
        return R.layout.actionbar_title_back;
    }

    @Override
    public int layoutId() {
        return R.layout.activity_question;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ImmersionBar.with(this).statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
        id = getIntent().getIntExtra("id", 0);
        queryData();
    }

    private void queryData() {
        tv_title.setText(getIntent().getStringExtra("title"));
        SQLiteDatabase sqLiteDatabase = assetsDatabaseManager.getDatabase("gupiao.db");
        String sql = "select * from problem where exam_id='" + id + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            HomeworkQuestionBean homeworkQuestionBean = new HomeworkQuestionBean();
            String type = cursor.getString(cursor.getColumnIndex("type"));
            if (type.equals("单选题")) {
                homeworkQuestionBean.type = HomeworkQuestionTypeBean.single_choice;
            } else if (type.equals("判断题")) {
                homeworkQuestionBean.type = HomeworkQuestionTypeBean.determine;
            } else if (type.equals("多选题")) {
                homeworkQuestionBean.type = HomeworkQuestionTypeBean.choice;
            }
            homeworkQuestionBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
            homeworkQuestionBean.setStem(cursor.getString(cursor.getColumnIndex("title")));
            homeworkQuestionBean.setAnalysis(cursor.getString(cursor.getColumnIndex("explain")));
            mQuestionList.add(homeworkQuestionBean);
        }
        for (int i = 0; i < mQuestionList.size(); i++) {
            String optionSql =
                    "select * from option where problem_id='" + mQuestionList.get(i).getId() +
                            "'";
            Cursor optionCursor = sqLiteDatabase.rawQuery(optionSql, null);
            ArrayList<String> metas = new ArrayList<>();
            metas.clear();
            while (optionCursor.moveToNext()) {
                metas.add(optionCursor.getString(optionCursor.getColumnIndex("answer")));
            }
            Log.e("answer", new Gson().toJson(metas));
            mQuestionList.get(i).setMetas(metas);
        }
        Log.e("data", new Gson().toJson(mQuestionList));
        assetsDatabaseManager.closeDatabase("gupiao.db");
        initListener();
        setStartExamData(mQuestionList);
        initDialog();
    }

    private void initListener() {
        ll_card.setOnClickListener(this);
        ll_finish.setOnClickListener(this);
        ll_back.setOnClickListener(this);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private boolean flag;

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        flag = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        flag = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        //判断是不是最后一页，同是是不是拖的状态
                        if (view_pager.getCurrentItem() == mAdapter.getCount() - 1 && !flag) {
                            Toast.makeText(QuestionActivity.this, "已经是最后一题", Toast
                                    .LENGTH_SHORT).show();
                        }
                        flag = true;
                        break;
                    default:
                        break;
                }
            }
        });
        view_pager.setOffscreenPageLimit(3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_card:
                if (mQuestionList.size() == 0) {
                    return;
                }
                showQuestionCard();
                break;
            case R.id.ll_finish:
                showFinishDialog();
                break;
            default:
                break;
        }
    }

    private void setStartExamData(ArrayList<HomeworkQuestionBean> results) {
        mAdapter = new QuestionPagerAdapter(QuestionActivity.this, results);
        view_pager.setAdapter(mAdapter);
        for (HomeworkQuestionBean homeworkQuestionBean : results) {
            HomeworkAnswerBean answerBean = new HomeworkAnswerBean();
            answerBean.data = homeworkQuestionBean.getAnswer();
            answerList.add(answerBean);
        }
    }

    private void showQuestionCard() {
        HomeworkCardFragment fragment = new HomeworkCardFragment();
        Bundle params = new Bundle();
        params.putBoolean("isShowSubmit", true);
        fragment.setArguments(params);
        fragment.show(getSupportFragmentManager(), "dialog");
    }

    //显示交卷弹窗
    public void showFinishDialog() {
        loading();

        for (int i = 0; i < mQuestionList.size(); i++) {
            HomeworkAnswerBean answer = answerList.get(i);
            if (!answer.isAnswer) {
                loadingClose();
                mTitleDialog.showDialog(getSupportFragmentManager());
                return;
            }
        }

        loadingClose();

        mSubmitDialog.showDialog(getSupportFragmentManager());
    }

    @Subscribe
    public void onEvent(MessageEvent messageEvent) {
        switch (messageEvent.getType()) {
            case MessageEvent.EXAM_CHANGE_ANSWER: // 保存答案
                Bundle bundle = (Bundle) messageEvent.getMessageBody();
                int index = bundle.getInt("index", 0);
                ArrayList<String> data = bundle.getStringArrayList("data");
                HomeworkQuestionTypeBean questionType =
                        (HomeworkQuestionTypeBean) bundle.getSerializable("QuestionType");
                changeAnswer(index, data, questionType);
                Log.i("QQQQQQQQQQ", "index = " + index + "= data =" + data.get(0) + "= " +
                        "questionType = " + questionType);
                break;
            case MessageEvent.EXAM_NEXT_QUESTION:
                //自动下一题
                if (view_pager.getCurrentItem() == mQuestionList.size() - 1) {
                    QsToast.show("已经是最后一题");
                    return;
                }

                if (view_pager.getCurrentItem() < mQuestionList.size() - 1) {
                    view_pager.setCurrentItem(view_pager.getCurrentItem() + 1);
                    EventBus.getDefault().cancelEventDelivery(messageEvent);
                }
                break;
            case MessageEvent.EXAM_CARD_JUMP:
                //题目跳转
                int num = (Integer) messageEvent.getMessageBody();
                if (num < 0 || num > mQuestionList.size() - 1) {
                    return;
                }
                view_pager.setCurrentItem(num, true);
                break;

            default:
                break;
        }
    }

    /**
     * 通过Event 事件回传答案
     */
    private void changeAnswer(int index, ArrayList<String> data,
                              HomeworkQuestionTypeBean questionType) {
        if (answerList == null) {
            return;
        }

        HomeworkAnswerBean answer = answerList.get(index);
        answer.data = data;
        answer.isAnswer = data != null && !data.isEmpty();
        if (questionType == HomeworkQuestionTypeBean.single_choice || questionType ==
                HomeworkQuestionTypeBean.determine) {
            if (FastClickUtil.isFastClick()) {
                view_pager.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new MessageEvent(MessageEvent
                                .EXAM_NEXT_QUESTION));
                    }
                }, 500);
            }
        } else if (questionType == HomeworkQuestionTypeBean.material
                && (mQuestionList.get(index).getType() == HomeworkQuestionTypeBean.single_choice
                || mQuestionList.get(index).getType() == HomeworkQuestionTypeBean.determine)) {
            if (FastClickUtil.isFastClick()) {
                view_pager.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new MessageEvent(MessageEvent
                                .EXAM_NEXT_QUESTION));
                    }
                }, 500);
            }
        }
    }

    @Override
    public boolean isOpenEventBus() {
        return true;
    }

    private void initDialog() {
        mTitleDialog = new SureTitleDialog()
                .setTitle("提交试卷")
                .setMessage("你当前还有题目未做完，确定交卷")
                .setAllBtnText("坚持考完", "交卷")
                .setClickListener(new SureTitleDialog.CallBack() {
                    @Override
                    public void onRightClick(SureTitleDialog dialog, View v) {
                        dialog.dismissDialog(getSupportFragmentManager());
                    }

                    @Override
                    public void onLeftClick(SureTitleDialog dialog, View v) {
                        dialog.dismissDialog(getSupportFragmentManager());
                        finish();
                    }
                });

        mSubmitDialog = new SureNoTitleDialog()
                .setMessage("确认交卷")
                .setAllBtnText("确认交卷", "取消")
                .setClickListener(new SureNoTitleDialog.CallBack() {
                    @Override
                    public void onRightClick(SureNoTitleDialog dialog, View v) {
                        dialog.dismissDialog(getSupportFragmentManager());
                        finish();
                    }

                    @Override
                    public void onLeftClick(SureNoTitleDialog dialog, View v) {
                        dialog.dismissDialog(getSupportFragmentManager());
                    }
                });
    }

}
