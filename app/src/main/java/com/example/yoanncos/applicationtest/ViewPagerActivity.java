package com.example.yoanncos.applicationtest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.yoanncos.applicationtest.Adapter.MyPageAdapter;
import com.example.yoanncos.applicationtest.fragments.MyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoann_000 on 18/05/2015.
 */
public class ViewPagerActivity extends FragmentActivity {

    MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(MyFragment.newInstance("Fragment 1"));
        fList.add(MyFragment.newInstance("Fragment 2"));
        fList.add(MyFragment.newInstance("Fragment 3"));

        return fList;
    }
}
