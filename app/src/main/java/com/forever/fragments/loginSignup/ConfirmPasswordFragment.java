package com.forever.fragments.loginSignup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.LoginActivity;
import com.forever.customView.Changed_password_Dialog;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;

public class ConfirmPasswordFragment extends Fragment implements View.OnClickListener, TextWatcher {

    private ImageView back_btn;
    private CardView next_btn;
    private EditText otp_et_1, otp_et_2, otp_et_3, otp_et_4;
    private Changed_password_Dialog changed_password_dialog;


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
        return inflater.inflate(R.layout.fragment_confirm_password, container, false);
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

    }

    private void viewSetup() {

        changed_password_dialog = new Changed_password_Dialog(LoginActivity.context, R.style.DialogDim);

        back_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);

        otp_et_1.addTextChangedListener(this);
        otp_et_2.addTextChangedListener(this);
        otp_et_3.addTextChangedListener(this);
        otp_et_4.addTextChangedListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.next_btn:

                openDialog();

                break;

            case R.id.reset_rl:

                ((LoginActivity) getActivity()).replaceFragment(new LoginFragment(), false,
                        KeyClass.FRAGMENT_LOGIN, KeyClass.FRAGMENT_LOCATION);

                changed_password_dialog.dismiss();

                break;
        }

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


    private void editText_codefill() {


        if (otp_et_1.getText().toString().length() == 1) {

            otp_et_1.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_1.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg_without_strock));

        }
        if (otp_et_2.getText().toString().length() == 1) {

            otp_et_2.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_2.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg_without_strock));

        }

        if (otp_et_3.getText().toString().length() == 1) {


            otp_et_3.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_3.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg_without_strock));

        }

        if (otp_et_4.getText().toString().length() == 1) {


            otp_et_4.setBackground(getResources().getDrawable(R.drawable.rounded_corner_white_bg_blue_strock));

        } else {

            otp_et_4.setBackground(getResources().getDrawable(R.drawable.rounde_corner_white_bg_without_strock));

        }


    }


    private void openDialog() {

        changed_password_dialog.show();
        Window window = changed_password_dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        changed_password_dialog.setCanceledOnTouchOutside(true);

        changed_password_dialog.reset_rl.setOnClickListener(this);


    }
}