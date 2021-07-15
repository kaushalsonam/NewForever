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
import com.forever.fragments.home.ActivityPointsFragment;
import com.forever.activities.HomeActivity;
import com.forever.activities.LoginActivity;
import com.forever.fragments.home.LevelBadgeStatusFragment;
import com.forever.fragments.loginSignup.ResetPasswordFragment;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.forever.utilities.PrefrenceShared;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout redeemed_rl, total_points_rl, edit_profile_rl, prefrence_rl, terms_condition_rl,
            help_center_rl, about_rl, password_rl, logout_btn_rl;
    private ImageView setting_icon;
    private TextView complete_profile_btn, view_detail_btn;
    private BottomSheetDialog bottomSheerDialog;
    private BottomNavigationView navigationView;
    private Boolean logoutFlag = true, closeflag = true, profileFlag = false;
    private FirebaseAuth firebaseAuth;


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

        navigationView = getActivity().findViewById(R.id.bottom_navigation);


        redeemed_rl = view.findViewById(R.id.redeemed_rl);
        total_points_rl = view.findViewById(R.id.total_points_rl);


        setting_icon = view.findViewById(R.id.setting_icon);


        complete_profile_btn = view.findViewById(R.id.complete_profile_btn);
        view_detail_btn = view.findViewById(R.id.view_detail_btn);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    private void viewSetup() {

        navigationView.setVisibility(View.VISIBLE);

        redeemed_rl.setOnClickListener(this);
        total_points_rl.setOnClickListener(this);
        setting_icon.setOnClickListener(this);
        complete_profile_btn.setOnClickListener(this);
        view_detail_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.redeemed_rl:

                ((HomeActivity) getActivity()).replaceFragment(new ProfileRedeemFragment(), true,
                        KeyClass.FRAGMENT_PROFILE_REDEEM, KeyClass.FRAGMENT_PROFILE_REDEEM);

                break;

            case R.id.total_points_rl:




//                PrefrenceShared.getInstance().getPreferenceData().setValue(Constant.profileFlag, String.valueOf(profileFlag));

                ((HomeActivity) getActivity()).replaceFragment(new ActivityPointsFragment(), true,
                        KeyClass.FRAGMENT_ACTIVITY_POINTS, KeyClass.FRAGMENT_ACTIVITY_POINTS);



                break;

            case R.id.setting_icon:
                settingDialog();


                break;

            case R.id.complete_profile_btn:


                ((HomeActivity) getActivity()).replaceFragment(new CompleteProfileFragment(), true,
                        KeyClass.FRAGMENT_COMPLETE_PROFILE, KeyClass.FRAGMENT_COMPLETE_PROFILE);


                break;

            case R.id.view_detail_btn:

                ((HomeActivity) getActivity()).replaceFragment(new LevelBadgeStatusFragment(), true,
                        KeyClass.FRAGMENT_LEVEL_BADGE_STATUS, KeyClass.FRAGMENT_LEVEL_BADGE_STATUS);

                break;


            case R.id.about_rl:

                bottomSheerDialog.dismiss();
                ((HomeActivity) getActivity()).replaceFragment(new AboutUsFragment(), true,
                        KeyClass.FRAGMENT_ABOUT_US, KeyClass.FRAGMENT_ABOUT_US);

                break;

            case R.id.edit_profile_rl:

                bottomSheerDialog.dismiss();

                ((HomeActivity) getActivity()).replaceFragment(new CompleteProfileFragment(), true,
                        KeyClass.FRAGMENT_COMPLETE_PROFILE, KeyClass.FRAGMENT_COMPLETE_PROFILE);

                break;
            case R.id.prefrence_rl:

                bottomSheerDialog.dismiss();

                ((HomeActivity) getActivity()).replaceFragment(new PrefrenceFragment(), true,
                        KeyClass.FRAGMENT_PREFRENCE, KeyClass.FRAGMENT_PREFRENCE);

                break;
            case R.id.terms_condition_rl:

                bottomSheerDialog.dismiss();
                ((HomeActivity) getActivity()).replaceFragment(new Terms_PrivacyFragment(), true,
                        KeyClass.FRAGMENT_TERMS_AND_PRIVACY, KeyClass.FRAGMENT_TERMS_AND_PRIVACY);

                break;
            case R.id.help_center_rl:

                bottomSheerDialog.dismiss();
                ((HomeActivity) getActivity()).replaceFragment(new HelpCenterFragment(), true,
                        KeyClass.FRAGMENT_HELP_CENTER, KeyClass.FRAGMENT_HELP_CENTER);

                break;
            case R.id.password_rl:

                bottomSheerDialog.dismiss();
                ((HomeActivity) getActivity()).replaceFragment(new ResetPasswordFragment(), true,
                        KeyClass.FRAGMENT_RESET_PASSWORD, KeyClass.FRAGMENT_RESET_PASSWORD);

                break;

            case R.id.logout_btn_rl:

                bottomSheerDialog.dismiss();

                logoutFlag = false;

                PrefrenceShared.getInstance().getPreferenceData().setValue(Constant.loginflag, String.valueOf(logoutFlag));

                if (firebaseAuth.getCurrentUser() != null) {

                    firebaseAuth.signOut();
                }
                Intent logout = new Intent(getActivity(), LoginActivity.class);
                startActivity(logout);
                getActivity().finish();

                break;


        }

    }


    private void settingDialog() {


        bottomSheerDialog = new BottomSheetDialog(getActivity());
        View parentView = getLayoutInflater().inflate(R.layout.bottom_sheet_profile_setting, null);
        bottomSheerDialog.setContentView(parentView);

        edit_profile_rl = parentView.findViewById(R.id.edit_profile_rl);
        prefrence_rl = parentView.findViewById(R.id.prefrence_rl);
        terms_condition_rl = parentView.findViewById(R.id.terms_condition_rl);
        help_center_rl = parentView.findViewById(R.id.help_center_rl);
        about_rl = parentView.findViewById(R.id.about_rl);
        password_rl = parentView.findViewById(R.id.password_rl);
        logout_btn_rl = parentView.findViewById(R.id.logout_btn_rl);


        edit_profile_rl.setOnClickListener(this);
        prefrence_rl.setOnClickListener(this);
        terms_condition_rl.setOnClickListener(this);
        help_center_rl.setOnClickListener(this);
        about_rl.setOnClickListener(this);
        password_rl.setOnClickListener(this);
        logout_btn_rl.setOnClickListener(this);

        if (PrefrenceShared.getInstance().getPreferenceData().getValueFromKey(Constant.close) != null) {

            if (PrefrenceShared.getInstance().getPreferenceData().getValueFromKey(Constant.close).equalsIgnoreCase("true")) {

                bottomSheerDialog.openContextMenu(parentView);

            }
        }


        bottomSheerDialog.show();

    }
}
