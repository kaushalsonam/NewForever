package com.forever.fragments.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.fragments.Profile.FoodActivityPointsFragment;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.forever.utilities.PrefrenceShared;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class ActivityPointsFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn, info_btn;
    private CardView custom_date_btn, total_steps_cv, gym_points_cv, food_points_cv, user_points_cv;
    private TextView txt_activity_points;
    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload;


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
        return inflater.inflate(R.layout.fragment_activity_points, container, false);
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

        back_btn = view.findViewById(R.id.back_btn);
        info_btn = view.findViewById(R.id.info_btn);

        custom_date_btn = view.findViewById(R.id.custom_date_btn);
        total_steps_cv = view.findViewById(R.id.total_steps_cv);
        gym_points_cv = view.findViewById(R.id.gym_points_cv);
        food_points_cv = view.findViewById(R.id.food_points_cv);
        user_points_cv = view.findViewById(R.id.user_points_cv);

        txt_activity_points = view.findViewById(R.id.txt_activity_points);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        custom_date_btn.setOnClickListener(this);
        total_steps_cv.setOnClickListener(this);
        gym_points_cv.setOnClickListener(this);
        food_points_cv.setOnClickListener(this);
        user_points_cv.setOnClickListener(this);
        txt_activity_points.setOnClickListener(this);
        info_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back_btn:

                getActivity().onBackPressed();

//                ((HomeActivity)getActivity()).replaceFragment(new HomeFragment(),true,KeyClass.FRAGMENT_HOME,
//                        KeyClass.FRAGMENT_HOME);

                break;

            case R.id.custom_date_btn:

                Toast.makeText(getActivity(), "Custome date popup", Toast.LENGTH_SHORT).show();

                break;

            case R.id.total_steps_cv:
            case R.id.gym_points_cv:
            case R.id.user_points_cv:

                ((HomeActivity) getActivity()).replaceFragment(new PointsSummaryFragment(), true,
                        KeyClass.FRAGMENT_POINTS_SUMMARY, KeyClass.FRAGMENT_POINTS_SUMMARY);

                break;

            case R.id.txt_activity_points:
            case R.id.info_btn:

                Toast.makeText(getActivity(), "Open point calculator", Toast.LENGTH_SHORT).show();

                break;


            case R.id.food_points_cv:
//
//                if (PrefrenceShared.getInstance().getPreferenceData().getValueFromKey(Constant.profileFlag) != null) {
//
//                    if (PrefrenceShared.getInstance().getPreferenceData().getValueFromKey(Constant.profileFlag).equalsIgnoreCase("true")) {
//
//                        ((HomeActivity) getActivity()).replaceFragment(new FoodActivityPointsFragment(), true,
//                                KeyClass.FRAGMENT_FOOD_ACTIVITY_POINTS, KeyClass.FRAGMENT_FOOD_ACTIVITY_POINTS);
//
//
//                    }
//                } else {

                    ((HomeActivity) getActivity()).replaceFragment(new PointsSummaryFragment(), true,
                            KeyClass.FRAGMENT_POINTS_SUMMARY, KeyClass.FRAGMENT_POINTS_SUMMARY);
//                }

                break;


        }

    }
}