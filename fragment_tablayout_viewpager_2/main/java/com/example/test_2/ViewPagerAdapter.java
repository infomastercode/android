package com.example.test_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> data = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm, ArrayList<String> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int i) {
        DemoFragment demoFragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        bundle.putString("data", data.toString());

        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // position started with 0
        String tabName = "";
        if (position == 0) {
            tabName = "Red";
        } else if (position == 1) {
            tabName = "Blue";
        } else if (position == 2) {
            tabName = "Green";
        } else if (position == 3) {
            tabName = "Yellow";
        } else if (position == 4) {
            tabName = "Black";
        }
        return tabName;
    }
}
