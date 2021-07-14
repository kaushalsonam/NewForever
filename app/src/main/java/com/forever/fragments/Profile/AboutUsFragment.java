package com.forever.fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.forever.R;
import com.forever.utilities.Constant;
import com.forever.utilities.PrefrenceShared;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class AboutUsFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn,close_btn;
    private BottomNavigationView bottom_navigation;
    private Boolean closeFlag=false;


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
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottom_navigation=getActivity().findViewById(R.id.bottom_navigation);

        back_btn=view.findViewById(R.id.back_btn);
        close_btn=view.findViewById(R.id.close_btn);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        close_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.close_btn:


                closeFlag=true;
                PrefrenceShared.getInstance().getPreferenceData().setValue(Constant.close, String.valueOf(closeFlag));
                getActivity().onBackPressed();

                break;

        }
    }
}