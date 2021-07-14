package com.forever.fragments.Profile;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CompleteProfileFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner txt_gender_spinner, txt_age_spinner;
    private ArrayAdapter<String> genderAdapter, ageAdapter;
    private String[] arrGender = {"Male", "Female", "Non Binary"};
    private TextView txt_gender, txt_age,txt_save_btn;
    private BottomNavigationView bottomNavigationView;
    private ImageView back_btn;


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
        return inflater.inflate(R.layout.fragment_complete_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottomNavigationView=getActivity().findViewById(R.id.bottom_navigation);

        txt_gender_spinner = view.findViewById(R.id.txt_gender_spinner);
        txt_age_spinner = view.findViewById(R.id.txt_age_spinner);

        txt_gender = view.findViewById(R.id.txt_gender);
        txt_age = view.findViewById(R.id.txt_age);
        txt_save_btn = view.findViewById(R.id.txt_save_btn);

        back_btn = view.findViewById(R.id.back_btn);


    }

    private void viewSetup() {

        bottomNavigationView.setVisibility(View.GONE);


        txt_gender_spinner.setOnItemSelectedListener(this);

        txt_gender.setOnClickListener(this);
        txt_age.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        txt_save_btn.setOnClickListener(this);


        //gender spinner setup
        genderAdapter = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_spinner_item,
                        arrGender);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        txt_gender_spinner.setAdapter(genderAdapter);


        //age spinner setup
        List age = new ArrayList<Integer>();
        for (int i = 16; i <= 100; i++) {
            age.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(
                getActivity(), android.R.layout.simple_spinner_item, age);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        txt_age_spinner.setAdapter(spinnerArrayAdapter);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.txt_gender:

                txt_gender_spinner.setVisibility(View.VISIBLE);
                txt_gender.setVisibility(View.GONE);

                break;

            case R.id.txt_age:

                txt_age_spinner.setOnItemSelectedListener(this);

                txt_age_spinner.setVisibility(View.VISIBLE);
                txt_age.setVisibility(View.GONE);

                break;

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.txt_save_btn:

                ((HomeActivity)getActivity()).replaceFragment(new ProfileFragment(),true,
                        KeyClass.FRAGMENT_PROFILE,KeyClass.FRAGMENT_PROFILE);

                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        switch (parent.getId()) {

            case R.id.txt_age_spinner:



                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}