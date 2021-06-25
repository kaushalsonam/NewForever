package com.forever.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.forever.fragments.OnBoardScreen1Fragment;
import com.forever.fragments.OnBoardScreen2Fragment;
import com.forever.fragments.OnBoardScreen3Fragment;

public class SwipeFragmentViewPagerAdapter extends FragmentPagerAdapter  {


    public SwipeFragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      switch (position){

          case 0:
              return OnBoardScreen1Fragment.newInstance("FirstScreen,Instance 1");
          case 1:

              return OnBoardScreen2Fragment.newInstance("FirstScreen,Instance 1");

          default:
              return OnBoardScreen3Fragment.newInstance("FirstScreen,Instance 1");



      }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
