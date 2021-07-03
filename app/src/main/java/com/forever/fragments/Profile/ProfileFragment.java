package com.forever.fragments.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.activities.LevelBadgeStatusActivity;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.security.Key;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout redeemed_rl,total_points_rl;
    private ImageView setting_icon;
    private TextView complete_profile_btn,view_detail_btn;

    private BottomNavigationView navigationView;


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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        navigationView=getActivity().findViewById(R.id.bottom_navigation);


        redeemed_rl=view.findViewById(R.id.redeemed_rl);
        total_points_rl=view.findViewById(R.id.total_points_rl);


        setting_icon=view.findViewById(R.id.setting_icon);


        complete_profile_btn=view.findViewById(R.id.complete_profile_btn);
        view_detail_btn=view.findViewById(R.id.view_detail_btn);



    }

    private void viewSetup() {

        redeemed_rl.setOnClickListener(this);
        total_points_rl.setOnClickListener(this);
        setting_icon.setOnClickListener(this);
        complete_profile_btn.setOnClickListener(this);
        view_detail_btn.setOnClickListener(this);


//        navigationView.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.redeemed_rl:

                break;

            case R.id.total_points_rl:

                break;

            case R.id.setting_icon:

                break;

            case R.id.complete_profile_btn:

                ((HomeActivity)getActivity()).replaceFragment(new CompleteProfileFragment(),true,
                        KeyClass.FRAGMENT_COMPLETE_PROFILE, KeyClass.FRAGMENT_COMPLETE_PROFILE);


                break;

            case R.id.view_detail_btn:

                Intent intent= new Intent(getActivity(), LevelBadgeStatusActivity.class);
                startActivity(intent);

                break;
        }

    }
}
