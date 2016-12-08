package com.xushuzhan.viewpagertest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    SecondAdapter mSecondAdapter;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    String [] titles = new String[]{"今日","昨日"};
    List<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.second_viewpager);

        mSecondAdapter = new SecondAdapter(getSupportFragmentManager());
        mSecondAdapter.setTitles(titles);//设置tab的标题

        mFragments = new ArrayList<>();
        mFragments.add(new Fragment_one());
        mFragments.add(new Fragment_two());

        mSecondAdapter.setFragments(mFragments);//设置待显示的fragment

        //设置TabLayout的显示模式：滚动或者静止
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //给viewPager设置适配器
        mViewPager.setAdapter(mSecondAdapter);
        //TabLayout绑定ViewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
