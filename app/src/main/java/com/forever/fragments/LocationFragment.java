package com.forever.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.LoginActivity;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class LocationFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn;
    private TextView txt_skip_btn;


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
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        back_btn=view.findViewById(R.id.back_btn);
        txt_skip_btn=view.findViewById(R.id.txt_skip_btn);


    }

    private void viewSetup() {

        back_btn.setOnClickListener(this);
        txt_skip_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.txt_skip_btn:

                ((LoginActivity)getActivity()).replaceFragment(new AgeFragment(),true,
                        KeyClass.FRAGMENT_AGE, KeyClass.FRAGMENT_AGE);


                break;
        }

    }
}