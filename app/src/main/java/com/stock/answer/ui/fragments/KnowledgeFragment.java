package com.stock.answer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.stock.answer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DataFragment
 * @Description:
 * @Author: dongxie
 * @CreateDate: 2020/6/23 20:18
 */
public class KnowledgeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] strings = new String[]{"基础知识", "交易指南"};


    public static KnowledgeFragment newInstance() {
        KnowledgeFragment fragment = new KnowledgeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dynamic, container, false);
        initView(root);
        return root;
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        fragmentList.add(BaseKnowledgeFragment.newInstance());
        fragmentList.add(GuideFragment.newInstance());
        MyAdapter myAdapter = new MyAdapter(getParentFragmentManager());
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }
}
