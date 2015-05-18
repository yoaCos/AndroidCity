package com.example.yoanncos.applicationtest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by yoann_000 on 18/05/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] tab;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        tab = new String[]{
                "position1", "position2", "position3"
        };
    }


    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
