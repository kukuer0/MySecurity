package mysecurity.wencheng.com.mysecurity.activity.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mysecurity.wencheng.com.mysecurity.R;
import mysecurity.wencheng.com.mysecurity.activity.fragment.FiveFragment;
import mysecurity.wencheng.com.mysecurity.activity.fragment.FourFragment;
import mysecurity.wencheng.com.mysecurity.activity.fragment.OneFragment;
import mysecurity.wencheng.com.mysecurity.activity.fragment.TreeFragment;
import mysecurity.wencheng.com.mysecurity.activity.fragment.TwoFragment;


/**
 * Created by wang on 2016/3/15.
 */
public class ActivityZero extends FragmentActivity {


    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);
        initAdapter();
        initView();

    }

    private void initView() {
        mViewPager  = (ViewPager) findViewById(R.id.activity_zero_viewpager);


        ZeroPagerAdapter zeroPageAdapter = new ZeroPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(zeroPageAdapter);



    }

    private void initAdapter() {
        mFragmentArrayList = new ArrayList<>();
        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        TreeFragment treeFragment = new TreeFragment();
        FourFragment fourFragment = new FourFragment();
        FiveFragment fiveFragment = new FiveFragment();
        mFragmentArrayList.add(oneFragment);
        mFragmentArrayList.add(twoFragment);
        mFragmentArrayList.add(treeFragment);
        mFragmentArrayList.add(fourFragment);
        mFragmentArrayList.add(fiveFragment);
    }

    private class ZeroPagerAdapter extends FragmentPagerAdapter {
        public ZeroPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentArrayList.size();
        }

    }
}
