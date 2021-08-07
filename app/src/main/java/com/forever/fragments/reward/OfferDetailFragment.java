package com.forever.fragments.reward;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

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
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class OfferDetailFragment extends Fragment implements View.OnClickListener {
    private ImageView back_btn;
    private BottomNavigationView bottom_navigation;
    private SwitchCompat toggle_btn;
    private TextView share_btn, redeem_btn;
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
        return inflater.inflate(R.layout.fragment_offer_detail, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();

    }

    private void bindView(View view) {

        back_btn = view.findViewById(R.id.back_btn);
        toggle_btn = view.findViewById(R.id.toggle_btn);
        share_btn = view.findViewById(R.id.share_btn);
        redeem_btn = view.findViewById(R.id.redeem_btn);

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);
        rl_upload = getActivity().findViewById(R.id.rl_upload);

    }

    private void viewSetup() {

        back_btn.setOnClickListener(this);
        share_btn.setOnClickListener(this);
        redeem_btn.setOnClickListener(this);

        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);


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

            case R.id.share_btn:

                Toast.makeText(getActivity(), "Share", Toast.LENGTH_SHORT).show();

                break;

            case R.id.redeem_btn:

                ((HomeActivity) getActivity()).replaceFragment(new RedeemCodeFragment(), true,
                        KeyClass.FRAGMENT_REDEEM_CODE, KeyClass.FRAGMENT_REDEEM_CODE);

                break;


        }
    }
}