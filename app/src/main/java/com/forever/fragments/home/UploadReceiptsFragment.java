package com.forever.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import org.jetbrains.annotations.NotNull;


public class UploadReceiptsFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn;
    private RelativeLayout uplod_rl,browse_rl;
    private TextView send_btn;
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
        return inflater.inflate(R.layout.fragment_upload_receipts, container, false);
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
        uplod_rl=view.findViewById(R.id.uplod_rl);
        browse_rl=view.findViewById(R.id.browse_rl);
        send_btn=view.findViewById(R.id.send_btn);


    }

    private void viewSetup() {

        back_btn.setOnClickListener(this);
        uplod_rl.setOnClickListener(this);
        browse_rl.setOnClickListener(this);
        send_btn.setOnClickListener(this);

        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.uplod_rl:



                break;

                case R.id.browse_rl:

                    break;

            case R.id.send_btn:

                ((HomeActivity)getActivity()).replaceFragment(new HomeFragment(),true, KeyClass.FRAGMENT_HOME,
                        KeyClass.FRAGMENT_HOME);

                break;
        }


    }
}