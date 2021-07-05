package com.forever.fragments.loginSignup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.activities.LoginActivity;
import com.forever.utilities.KeyClass;
import com.hbb20.CountryCodePicker;

import org.jetbrains.annotations.NotNull;


public class LoginWithPhoneFragment extends Fragment implements View.OnClickListener, TextWatcher {

    private EditText mobile_num,et_password;
    private TextView login_btn;
    private LinearLayout reset_ll,txt_create_one_ll;
    private CountryCodePicker countryCodePicker;
    private ImageView fb_login,google_login;




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
        return inflater.inflate(R.layout.fragment_login_with_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        mobile_num=view.findViewById(R.id.mobile_num);
        et_password=view.findViewById(R.id.et_password);
        login_btn=view.findViewById(R.id.login_btn);
        reset_ll=view.findViewById(R.id.reset_ll);
        txt_create_one_ll=view.findViewById(R.id.txt_create_one_ll);
        countryCodePicker=view.findViewById(R.id.countryCodePicker);
        fb_login=view.findViewById(R.id.fb_login);
        google_login=view.findViewById(R.id.google_login);


    }

    private void viewSetup() {

        login_btn.setOnClickListener(this);
        reset_ll.setOnClickListener(this);
        txt_create_one_ll.setOnClickListener(this);
        fb_login.setOnClickListener(this);
        google_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.login_btn:

                Intent intent = new Intent(getActivity(), HomeActivity.class);
                ((LoginActivity) getActivity()).startActivity(intent);
                ((LoginActivity) getActivity()).finish();

                break;

            case R.id.reset_ll:

                ((LoginActivity) getActivity()).replaceFragment(new ResetPasswordFragment(), true,
                        KeyClass.FRAGMENT_RESET_PASSWORD, KeyClass.FRAGMENT_RESET_PASSWORD);

                break;

            case R.id.txt_create_one_ll:

                ((LoginActivity) getActivity()).replaceFragment(new SignupFragment(), false,
                        KeyClass.FRAGMENT_SIGNUP, KeyClass.FRAGMENT_SIGNUP);

                break;

            case R.id.fb_login:

                break;

            case R.id.google_login:

                break;


        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}