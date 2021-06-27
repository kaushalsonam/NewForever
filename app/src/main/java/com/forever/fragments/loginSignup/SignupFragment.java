package com.forever.fragments.loginSignup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.activities.LoginActivity;
import com.forever.utilities.KeyClass;
import com.hbb20.CountryCodePicker;

import org.jetbrains.annotations.NotNull;


public class SignupFragment extends Fragment implements View.OnClickListener {

    private EditText full_name, mobile_num, et_password, et_confirm_password;
    private CountryCodePicker countryCodePicker;
    private TextView signup_btn;
    private LinearLayout txt_already_have_one;


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
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {


        full_name = view.findViewById(R.id.full_name);
        mobile_num = view.findViewById(R.id.mobile_num);
        et_password = view.findViewById(R.id.et_password);
        et_confirm_password = view.findViewById(R.id.et_confirm_password);

        countryCodePicker = view.findViewById(R.id.countryCodePicker);

        signup_btn = view.findViewById(R.id.signup_btn);


        txt_already_have_one = view.findViewById(R.id.txt_already_have_one);

    }

    private void viewSetup() {

        signup_btn.setOnClickListener(this);
        txt_already_have_one.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.signup_btn:

                Intent intent = new Intent(getActivity(), HomeActivity.class);
                ((LoginActivity) getActivity()).startActivity(intent);
                ((LoginActivity) getActivity()).finish();


                break;

            case R.id.txt_already_have_one:

                ((LoginActivity) getActivity()).replaceFragment(new LoginFragment(), false,
                        KeyClass.FRAGMENT_LOGIN, KeyClass.FRAGMENT_LOGIN);

                break;
        }

    }
}