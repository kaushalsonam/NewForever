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
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class ActivitySummaryFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn;
    private CardView custom_date_btn,total_steps_cv,pramotion_cv,total_points_cv;
    private TextView txt_activity_Sammary;
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
        return inflater.inflate(R.layout.fragment_activity_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottom_navigation=getActivity().findViewById(R.id.bottom_navigation);
        rl_upload=getActivity().findViewById(R.id.rl_upload);

        back_btn=view.findViewById(R.id.back_btn);

        custom_date_btn=view.findViewById(R.id.custom_date_btn);
        total_steps_cv=view.findViewById(R.id.total_steps_cv);
        pramotion_cv=view.findViewById(R.id.pramotion_cv);
        total_points_cv=view.findViewById(R.id.total_points_cv);
        txt_activity_Sammary=view.findViewById(R.id.txt_activity_Sammary);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        custom_date_btn.setOnClickListener(this);
        total_steps_cv.setOnClickListener(this);
        pramotion_cv.setOnClickListener(this);
        total_points_cv.setOnClickListener(this);
        txt_activity_Sammary.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back_btn:

                getActivity().onBackPressed();
                break;

            case R.id.custom_date_btn:

                Toast.makeText(getActivity(), "custom date popup", Toast.LENGTH_SHORT).show();

                break;

            case R.id.total_steps_cv:
            case R.id.pramotion_cv:

                ((HomeActivity)getActivity()).replaceFragment(new ActivityDetailFragment(),true,
                        KeyClass.FRAGMENT_ACTIVITY_DETAILS,KeyClass.FRAGMENT_ACTIVITY_DETAILS);

                break;

            case R.id.total_points_cv:

                ((HomeActivity)getActivity()).replaceFragment(new ActivityPointsFragment(),true,
                        KeyClass.FRAGMENT_ACTIVITY_POINTS,KeyClass.FRAGMENT_ACTIVITY_POINTS);

                break;
                
            case R.id.txt_activity_Sammary:

                Toast.makeText(getActivity(), "activity summary dialog", Toast.LENGTH_SHORT).show();
                
                break;

        }

    }
}