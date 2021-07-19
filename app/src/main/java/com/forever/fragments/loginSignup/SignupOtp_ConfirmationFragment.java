package com.forever.fragments.loginSignup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.LoginActivity;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class SignupOtp_ConfirmationFragment extends Fragment implements View.OnClickListener, TextWatcher {

    private ImageView back_btn;
    private CardView next_btn;
    private TextView txt_skip_btn;
    private EditText otp_et_1, otp_et_2, otp_et_3, otp_et_4;


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
        return inflater.inflate(R.layout.fragment_signup_otp__confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();

    }

    private void bindView(View view) {

        back_btn = view.findViewById(R.id.back_btn);

        //cardview
        next_btn = view.findViewById(R.id.next_btn);


        otp_et_1 = view.findViewById(R.id.otp_et_1);
        otp_et_2 = view.findViewById(R.id.otp_et_2);
        otp_et_3 = view.findViewById(R.id.otp_et_3);
        otp_et_4 = view.findViewById(R.id.otp_et_4);

        txt_skip_btn=view.findViewById(R.id.txt_skip_btn);

    }

    private void viewSetup() {

        back_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);

        otp_et_1.addTextChangedListener(this);
        otp_et_2.addTextChangedListener(this);
        otp_et_3.addTextChangedListener(this);
        otp_et_4.addTextChangedListener(this);
        txt_skip_btn.setOnClickListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        editText_codefill();

        if (otp_et_1.getText().toString().length() == 1) {

            otp_et_1.clearFocus();
            otp_et_2.requestFocus();
            otp_et_3.clearFocus();
            otp_et_4.clearFocus();

        }

        if (otp_et_2.getText().toString().length() == 1) {

            otp_et_1.clearFocus();
            otp_et_2.clearFocus();
            otp_et_3.requestFocus();
            otp_et_4.clearFocus();

        }

        if (otp_et_3.getText().toString().length() == 1) {

            otp_et_1.clearFocus();
            otp_et_2.clearFocus();
            otp_et_3.clearFocus();
            otp_et_4.requestFocus();

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

        editText_codefill();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.next_btn:

                if(!otp_et_1.getText().toString().isEmpty()){

                    if(!otp_et_2.getText().toString().isEmpty()){

                        if(!otp_et_3.getText().toString().isEmpty()){

                            if(!otp_et_4.getText().toString().isEmpty()){

                                ((LoginActivity)getActivity()).replaceFragment(new GenderFragment(),true,
                                        KeyClass.FRAGMENT_GENDER,KeyClass.FRAGMENT_GENDER);


                            }

                        }
                    }
                }else {

                    Toast.makeText(getActivity(), "Please Enter valid OTP", Toast.LENGTH_SHORT).show();

                }



                break;

            case R.id.txt_skip_btn:

                ((LoginActivity)getActivity()).replaceFragment(new LocationFragment(),true,
                        KeyClass.FRAGMENT_LOCATION,KeyClass.FRAGMENT_LOCATION);

                break;

        }

    }

    private void editText_codefill() {


        if (otp_et_1.getText().toString().length() == 1) {

            otp_et_1.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_1.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg));

        }
        if (otp_et_2.getText().toString().length() == 1) {

            otp_et_2.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_2.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg));

        }

        if (otp_et_3.getText().toString().length() == 1) {


            otp_et_3.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_3.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg));

        }

        if (otp_et_4.getText().toString().length() == 1) {


            otp_et_4.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_4.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg));

        }


    }
}