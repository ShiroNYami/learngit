package com.xushuzhan.viewpagertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;



public class SecondAdapter extends FragmentPagerAdapter {

    //TabLayout上面的标题数组
    String []  mTitles;
    //待显示的Fragment的集合
    List<Fragment> mFragments;

    //设置标题数组
    public void setTitles(String[] titles){
        mTitles = titles;
    }

    //设置待显示的Fragment
    public void setFragments(List<Fragment> fragments){
        mFragments = fragments;
    }

    public SecondAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
