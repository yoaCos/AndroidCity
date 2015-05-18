package com.example.yoanncos.applicationtest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yoann_000 on 18/05/2015.
 */
public class MyPageAdapter extends FragmentPagerAdapter{

    private List<android.app.Fragment> fragments;

    public MyPageAdapter(FragmentManager fm, List<android.app.Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
