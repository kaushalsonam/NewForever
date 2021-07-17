package com.forever.fragments.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.customLibararies.CurveGraphConfig;
import com.forever.customLibararies.CurveGraphView;
import com.forever.customLibararies.GraphData;
import com.forever.customLibararies.PointMap;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private ImageView level_badge, share_btn;
    private TextView txt_day,txt_see_all,txt_this_week_see_all_tv;
    private RelativeLayout total_steps_rl,total_points_rl;
    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload;
    private CurveGraphView curve_graph_view;






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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottom_navigation=getActivity().findViewById(R.id.bottom_navigation);
        rl_upload=getActivity().findViewById(R.id.rl_upload);

        //image view
        level_badge = view.findViewById(R.id.level_badge);
        share_btn = view.findViewById(R.id.share_btn);

        //TextView
        txt_day = view.findViewById(R.id.txt_day);
        txt_see_all = view.findViewById(R.id.txt_see_all);
        txt_this_week_see_all_tv = view.findViewById(R.id.txt_this_week_see_all_tv);


        //RealtiveLayout
        total_steps_rl=view.findViewById(R.id.total_steps_rl);
        total_points_rl=view.findViewById(R.id.total_points_rl);

        //Graph view
        curve_graph_view=view.findViewById(R.id.curve_graph_view);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.VISIBLE);
        rl_upload.setVisibility(View.VISIBLE);





        level_badge.setOnClickListener(this);
        share_btn.setOnClickListener(this);
        total_steps_rl.setOnClickListener(this);
        total_points_rl.setOnClickListener(this);
        txt_see_all.setOnClickListener(this);
        txt_this_week_see_all_tv.setOnClickListener(this);


        curve_graph_view.configure(
                new CurveGraphConfig.Builder(getActivity())
                        .setAxisColor(R.color.et_hint_color)                                                                       // Set number of values to be displayed in X ax
                        .setVerticalGuideline(7)
                        .setGuidelineColor(R.color.et_hint_color)// Set number of background guidelines to be shown.
                        .setAnimationDuration(2000)                                             // Set Animation Duration
                        .build()
        );

        PointMap pointMap = new PointMap();
        pointMap.addPoint(0, 0);
        pointMap.addPoint(1, 5);
        pointMap.addPoint(2, 10);
        pointMap.addPoint(3, 15);
        pointMap.addPoint(4, 20);



        GraphData gd = GraphData.builder(getActivity())
                .setPointMap(pointMap)                                                   // PointMap datqa
                .setGraphStroke(R.color.dotcolor)                                           // Graph line stroke color
                // Graph fill gradient color
                // true for straight line; false for curved line graph
                // set point radius
                // set point color
                .animateLine(true)                                                       // Trigger animation for the particular graph line!
                .build();




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                curve_graph_view.setData(5, 20, gd);
            }
        }, 250);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.level_badge:


                ((HomeActivity)getActivity()).replaceFragment(new LevelBadgeStatusFragment(),true,
                        KeyClass.FRAGMENT_LEVEL_BADGE_STATUS,KeyClass.FRAGMENT_LEVEL_BADGE_STATUS);



                break;

            case R.id.share_btn:

                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();

                break;

            case R.id.total_steps_rl:


                ((HomeActivity)getActivity()).replaceFragment(new ActivitySummaryFragment(),true,
                        KeyClass.FRAGMENT_ACTIVITY_SUMMARY,KeyClass.FRAGMENT_ACTIVITY_SUMMARY);

                break;

            case R.id.total_points_rl:


                ((HomeActivity)getActivity()).replaceFragment(new ActivityPointsFragment(),true,
                        KeyClass.FRAGMENT_ACTIVITY_POINTS,KeyClass.FRAGMENT_ACTIVITY_POINTS);


                break;

            case R.id.txt_see_all:

                PointsSummaryFragment pointsSummaryFragment= new PointsSummaryFragment();
                Bundle args= new Bundle();
                args.putString(Constant.Type,Constant.Day);
                pointsSummaryFragment.setArguments(args);

                ((HomeActivity)getActivity()).replaceFragment(pointsSummaryFragment,true,
                        KeyClass.FRAGMENT_POINTS_SUMMARY,KeyClass.FRAGMENT_POINTS_SUMMARY);

                break;
            case R.id.txt_this_week_see_all_tv:

                PointsSummaryFragment pointsSummary= new PointsSummaryFragment();
                Bundle bundle= new Bundle();
                bundle.putString(Constant.Type,Constant.Week);
                pointsSummary.setArguments(bundle);

                ((HomeActivity)getActivity()).replaceFragment(pointsSummary,true,
                        KeyClass.FRAGMENT_POINTS_SUMMARY,KeyClass.FRAGMENT_POINTS_SUMMARY);

                break;

        }

    }



}