package com.forever.adapter;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.forever.fragments.loginSignup.LoginFragment;
import com.forever.fragments.onBoardingScreens.OnBoardScreen1Fragment;
import com.forever.fragments.onBoardingScreens.OnBoardScreen2Fragment;
import com.forever.fragments.onBoardingScreens.OnBoardScreen3Fragment;

public class SwipeFragmentViewPagerAdapter extends FragmentPagerAdapter {


    public SwipeFragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return OnBoardScreen1Fragment.newInstance();
            case 1:

                return OnBoardScreen2Fragment.newInstance();

            default:
                return OnBoardScreen3Fragment.newInstance();




        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
