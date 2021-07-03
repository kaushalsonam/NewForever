package com.forever.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.ActivityPoints;
import com.forever.activities.ActivitySummary;
import com.forever.activities.HomeActivity;
import com.forever.activities.LevelBadgeStatusActivity;
import com.forever.activities.LoginActivity;
import com.forever.activities.PointsSummaryActivity;
import com.forever.customView.Changed_password_Dialog;
import com.forever.customView.DayPointSummary;
import com.forever.utilities.Constant;

import org.jetbrains.annotations.NotNull;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private ImageView level_badge, share_btn;
    private TextView txt_day,txt_see_all,txt_this_week_see_all_tv;
    private RelativeLayout total_steps_rl,total_points_rl;


    private DayPointSummary dayPointSummary;




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

    }

    private void viewSetup() {

        dayPointSummary= new DayPointSummary(HomeActivity.context,R.style.DialogDim);


        level_badge.setOnClickListener(this);
        share_btn.setOnClickListener(this);
        total_steps_rl.setOnClickListener(this);
        total_points_rl.setOnClickListener(this);
        txt_see_all.setOnClickListener(this);
        txt_this_week_see_all_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.level_badge:


                Intent levelBadge= new Intent(getActivity(), LevelBadgeStatusActivity.class);
                startActivity(levelBadge);



                break;

            case R.id.share_btn:

                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();

                break;

            case R.id.total_steps_rl:


                Intent summary= new Intent(getActivity(), ActivitySummary.class);
                startActivity(summary);

                break;

            case R.id.total_points_rl:

                Intent points= new Intent(getActivity(), ActivityPoints.class);
                startActivity(points);


                break;

            case R.id.txt_see_all:

                Intent pointSummaryday= new Intent(getActivity(), PointsSummaryActivity.class);
                pointSummaryday.putExtra(Constant.Type,Constant.Day);
                startActivity(pointSummaryday);

                break;
            case R.id.txt_this_week_see_all_tv:

                Intent pointSummaryWeek= new Intent(getActivity(), PointsSummaryActivity.class);
                pointSummaryWeek.putExtra(Constant.Type,Constant.Week);
                startActivity(pointSummaryWeek);

                break;

        }

    }

    private void openDialog() {

        dayPointSummary.show();
        Window window = dayPointSummary.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        dayPointSummary.setCanceledOnTouchOutside(true);
    }

}