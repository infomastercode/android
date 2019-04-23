package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Log.d("check", "Fragment getItem: " + i);
        if (i == 0) {
            return FragmentOne.newInstance(i,"red");
        } else if (i == 1) {
            return FragmentOne.newInstance(i,"blue");
        } else if (i == 2) {
            return FragmentOne.newInstance(i,"green");
        } else if (i == 3) {
            return FragmentOne.newInstance(i,"yellow");
        }else if (i == 4) {
            return FragmentOne.newInstance(i,"black");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
