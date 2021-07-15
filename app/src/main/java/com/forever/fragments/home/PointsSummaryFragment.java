package com.forever.fragments.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.fragments.Profile.ProfileFragment;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

public class PointsSummaryFragment extends Fragment implements View.OnClickListener {

    private TextView txt_day, txt_week, txt_month, txt_year;
    private String type;
    private ImageView back_btn;
    private TextView txt_points_Sammary;
    private SwitchCompat toggle_btn;
    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload;
    private BottomSheetDialog bottomSheerDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            type = getArguments().getString(Constant.Type);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_points_summary, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();


    }

    private void bindView(View view) {

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);
        rl_upload = getActivity().findViewById(R.id.rl_upload);

        txt_day = view.findViewById(R.id.txt_day);
        txt_week = view.findViewById(R.id.txt_week);
        txt_month = view.findViewById(R.id.txt_month);
        txt_year = view.findViewById(R.id.txt_year);
        back_btn = view.findViewById(R.id.back_btn);
        txt_points_Sammary = view.findViewById(R.id.txt_points_Sammary);
        toggle_btn = view.findViewById(R.id.toggle_btn);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        txt_day.setOnClickListener(this);
        txt_year.setOnClickListener(this);
        txt_week.setOnClickListener(this);
        txt_month.setOnClickListener(this);
        txt_points_Sammary.setOnClickListener(this);


        if (type != null) {

            if (type.equalsIgnoreCase("Day")) {

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_day.setTextColor(getResources().getColor(R.color.white));

            } else {

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_day.setTextColor(getResources().getColor(R.color.dotcolor));

            }

            if (type.equalsIgnoreCase("week")) {

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_week.setTextColor(getResources().getColor(R.color.white));

            } else {

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_week.setTextColor(getResources().getColor(R.color.dotcolor));

            }

        } else {

            onClick(txt_day);

        }

        toggle_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (toggle_btn.isPressed()) {

                    ((HomeActivity) getActivity()).replaceFragment(new ProfileFragment(), true,
                            KeyClass.FRAGMENT_PROFILE, KeyClass.FRAGMENT_PROFILE);


                    toggle_btn.setChecked(false);
                }

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.txt_day:

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_day.setTextColor(getResources().getColor(R.color.white));

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_week.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_month.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_month.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_year.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_year.setTextColor(getResources().getColor(R.color.dotcolor));

                break;

            case R.id.txt_year:

                txt_year.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_year.setTextColor(getResources().getColor(R.color.white));

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_week.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_month.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_month.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_day.setTextColor(getResources().getColor(R.color.dotcolor));

                break;

            case R.id.txt_week:

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_week.setTextColor(getResources().getColor(R.color.white));

                txt_year.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_year.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_month.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_month.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_day.setTextColor(getResources().getColor(R.color.dotcolor));

                break;

            case R.id.txt_month:

                txt_month.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_month.setTextColor(getResources().getColor(R.color.white));

                txt_year.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_year.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_week.setTextColor(getResources().getColor(R.color.dotcolor));

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_day.setTextColor(getResources().getColor(R.color.dotcolor));

                break;

            case R.id.txt_points_Sammary:

//                Toast.makeText(getActivity(), "points popup", Toast.LENGTH_SHORT).show();

                bottomPointSummaryDialog();

                break;

            case R.id.close_btn:

                bottomSheerDialog.dismiss();

                break;
        }

    }


    private void bottomPointSummaryDialog() {

        bottomSheerDialog = new BottomSheetDialog(getActivity());
        View parentView = getLayoutInflater().inflate(R.layout.day_points_summary, null);
        bottomSheerDialog.setContentView(parentView);


        ImageView close_btn = parentView.findViewById(R.id.close_btn);

        TextView steps1_tv = parentView.findViewById(R.id.steps1_tv);
        TextView steps2_tv = parentView.findViewById(R.id.steps2_tv);
        TextView steps3_tv = parentView.findViewById(R.id.steps3_tv);
        TextView gym1_tv = parentView.findViewById(R.id.gym1_tv);
        TextView food1_tv = parentView.findViewById(R.id.food1_tv);
        TextView food2_tv = parentView.findViewById(R.id.food2_tv);
        TextView heart1_tv = parentView.findViewById(R.id.heart1_tv);
        TextView heart2_tv = parentView.findViewById(R.id.heart2_tv);

        TextView steps1_points_tv = parentView.findViewById(R.id.steps1_points_tv);
        TextView steps2_points_tv = parentView.findViewById(R.id.steps2_points_tv);
        TextView steps3_points_tv = parentView.findViewById(R.id.steps3_points_tv);
        TextView gym1_points_tv = parentView.findViewById(R.id.gym1_points_tv);
        TextView food1_points_tv = parentView.findViewById(R.id.food1_points_tv);
        TextView food2_points_tv = parentView.findViewById(R.id.food2_points_tv);
        TextView heart1_points_tv = parentView.findViewById(R.id.heart1_points_tv);
        TextView heart2_points_tv = parentView.findViewById(R.id.heart2_points_tv);
        TextView heart3_points_tv = parentView.findViewById(R.id.heart3_points_tv);

        close_btn.setOnClickListener(this);


        bottomSheerDialog.show();

    }


}