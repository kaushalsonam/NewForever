package com.forever.fragments.loginSignup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.Model.PhoneSignupResponseModel;
import com.forever.R;
import com.forever.ViewModel.OnBoardingViewModel;
import com.forever.ViewModel.PhoneSignupViewModel;
import com.forever.activities.HomeActivity;
import com.forever.activities.LoginActivity;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.forever.utilities.PrefrenceShared;
import com.google.gson.JsonObject;
import com.hbb20.CountryCodePicker;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;


public class SignupFragment extends Fragment implements View.OnClickListener, Observer<PhoneSignupResponseModel>, TextWatcher {

    private EditText full_name, mobile_num, et_password, et_confirm_password, et_email;
    private CountryCodePicker countryCodePicker;
    private TextView signup_btn, full_name_astric, mobile_num_astric, password_astric, confirm_password_astric;
    private LinearLayout txt_already_have_one;
    private PhoneSignupViewModel phoneSignupViewModel;
    private ImageView hide_password, hide_confirm_password;
    private Boolean loginFlag = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        viewModelSetup();
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
        et_email = view.findViewById(R.id.et_email);


        countryCodePicker = view.findViewById(R.id.countryCodePicker);

        signup_btn = view.findViewById(R.id.signup_btn);

        full_name_astric = view.findViewById(R.id.full_name_astric);
        mobile_num_astric = view.findViewById(R.id.mobile_num_astric);

        password_astric = view.findViewById(R.id.password_astric);
        confirm_password_astric = view.findViewById(R.id.confirm_password_astric);


        txt_already_have_one = view.findViewById(R.id.txt_already_have_one);

        hide_password = view.findViewById(R.id.hide_password);
        hide_confirm_password = view.findViewById(R.id.hide_confirm_password);

    }

    private void viewSetup() {

        signup_btn.setOnClickListener(this);
        txt_already_have_one.setOnClickListener(this);

        full_name.addTextChangedListener(this);
        mobile_num.addTextChangedListener(this);
        et_password.addTextChangedListener(this);
        et_confirm_password.addTextChangedListener(this);
        et_email.addTextChangedListener(this);

        hide_password.setOnClickListener(this);
        hide_confirm_password.setOnClickListener(this);


    }

    private void viewModelSetup() {

        phoneSignupViewModel = new ViewModelProvider(this).get(PhoneSignupViewModel.class);
        phoneSignupViewModel.signupwithphone.observe(this, this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.signup_btn:


                if (!full_name.getText().toString().isEmpty()) {

                    if (countryCodePicker != null) {

                        if (!mobile_num.getText().toString().isEmpty() && mobile_num.getText().toString().length() < 11) {

//                            if (!et_email.getText().toString().isEmpty()) {
//
//
//                                if (!isValidMail(et_email.getText().toString())) {
//
//                                    Toast.makeText(getActivity(), "Please enter valid email", Toast.LENGTH_SHORT).show();
//
//                                }


                                if (!et_password.getText().toString().isEmpty()) {

                                    if (!et_confirm_password.getText().toString().isEmpty()) {

                                        if (et_confirm_password.getText().toString().equals(et_password.getText().toString())) {


                                            JsonObject data = new JsonObject();
                                            data.addProperty(Constant.full_name, full_name.getText().toString());
                                            data.addProperty(Constant.phone_code, countryCodePicker.getSelectedCountryCode());
                                            data.addProperty(Constant.phone_number, mobile_num.getText().toString());
                                            data.addProperty(Constant.email, et_email.getText().toString());
                                            data.addProperty(Constant.password, et_password.getText().toString());
                                            data.addProperty(Constant.device_type, R.string.device_type);
                                            data.addProperty(Constant.device_token, R.string.tocken);


                                            phoneSignupViewModel.phoneSignup(data, getActivity());

                                        } else {

                                            Toast.makeText(getActivity(), "Confirm Password should be same as password", Toast.LENGTH_SHORT).show();
                                        }


                                    } else {

                                        Toast.makeText(getActivity(), "Confirm Password can not be empty", Toast.LENGTH_SHORT).show();
                                    }


                                } else {

                                    Toast.makeText(getActivity(), "Password Can not be empty", Toast.LENGTH_SHORT).show();

                                }
//                            }
                        } else {

                            Toast.makeText(getActivity(), "Please enter Valid Mobile number", Toast.LENGTH_SHORT).show();
                        }

                    }

                } else {

                    Toast.makeText(getActivity(), "Please enter Full name", Toast.LENGTH_SHORT).show();
                }

//                ((LoginActivity) getActivity()).replaceFragment(new SignupOtp_ConfirmationFragment(), true,
//                        KeyClass.FRAGMENT_SIGN_UP_OTP_CONFIRMATION, KeyClass.FRAGMENT_SIGN_UP_OTP_CONFIRMATION);


                break;

            case R.id.txt_already_have_one:

                ((LoginActivity) getActivity()).replaceFragment(new LoginWithPhoneFragment(), false,
                        KeyClass.FRAGMENT_LOGIN, KeyClass.FRAGMENT_LOGIN);

                break;

            case R.id.hide_password:

                if (et_password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {

                    et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                } else {

                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }

                break;

            case R.id.hide_confirm_password:

                if (et_confirm_password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {

                    et_confirm_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                } else {

                    et_confirm_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }

                break;
        }

    }


    private boolean isValidMail(String email) {

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(EMAIL_STRING).matcher(email).matches();

    }


    @Override
    public void onChanged(PhoneSignupResponseModel phoneSignupResponseModel) {

        loginFlag=true;

        PrefrenceShared.getInstance().getPreferenceData().setValue(Constant.loginflag, String.valueOf(loginFlag));

        ((LoginActivity) getActivity()).replaceFragment(new SignupOtp_ConfirmationFragment(), true,
                KeyClass.FRAGMENT_SIGN_UP_OTP_CONFIRMATION, KeyClass.FRAGMENT_SIGN_UP_OTP_CONFIRMATION);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (full_name.getText().toString().length() > 0) {

            full_name_astric.setVisibility(View.GONE);
        } else {

            full_name_astric.setVisibility(View.VISIBLE);
        }
        if (mobile_num.getText().toString().length() > 0) {

            mobile_num_astric.setVisibility(View.GONE);

        } else {

            mobile_num_astric.setVisibility(View.VISIBLE);
        }

        if (et_email.getText().toString().length() > 0) {

//            email_astric.setVisibility(View.GONE);
        } else {

//            email_astric.setVisibility(View.VISIBLE);
        }
        if (et_password.getText().toString().length() > 0) {

            password_astric.setVisibility(View.GONE);
        } else {

            password_astric.setVisibility(View.VISIBLE);

        }
        if (et_confirm_password.getText().toString().length() > 0) {

            confirm_password_astric.setVisibility(View.GONE);
        } else {

            confirm_password_astric.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}