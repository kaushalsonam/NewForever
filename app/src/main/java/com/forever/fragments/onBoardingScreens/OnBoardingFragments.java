package com.forever.fragments.onBoardingScreens;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forever.R;
import com.forever.adapter.SwipeFragmentViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class OnBoardingFragments extends Fragment {

    private Context context;
    private ViewPager swipe_view_pager;
    private SwipeFragmentViewPagerAdapter adapter;
    private SpringDotsIndicator dots_indicator;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        swipe_view_pager = view.findViewById(R.id.swipe_view_pager);
        dots_indicator =  view.findViewById(R.id.dots_indicator);


    }

    private void viewSetup() {

        adapter = new SwipeFragmentViewPagerAdapter(getChildFragmentManager());
        swipe_view_pager.setAdapter(adapter);
        dots_indicator.setViewPager(swipe_view_pager);
    }

}