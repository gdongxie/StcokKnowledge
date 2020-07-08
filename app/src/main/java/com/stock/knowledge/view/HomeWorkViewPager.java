package com.stock.knowledge.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

/**
 * @Author yinzh
 * @Date 2020/3/16 14:11
 * @Description 作业容器
 */
public class HomeWorkViewPager extends ViewPager {

    public HomeWorkViewPager(@NonNull Context context) {
        super(context);
        initView();
    }

    public HomeWorkViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        try {
            Class clazz = Class.forName("androidx.viewpager.widget.ViewPager");
            Field f = clazz.getDeclaredField("mScroller");
            FixedViewPagerSpeedScroller fixedSpeedScroller =
                    new FixedViewPagerSpeedScroller(getContext(),
                            new LinearOutSlowInInterpolator());
            fixedSpeedScroller.setmDuration(300);
            f.setAccessible(true);
            f.set(this, fixedSpeedScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
