package com.forever.fragments.loginSignup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.service.autofill.OnClickAction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.activities.LoginActivity;
import com.forever.fragments.onBoardingScreens.OnBoardScreen3Fragment;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText et_email, et_password;
    private RelativeLayout et_email_rl, et_password_rl;
    private TextView login_btn;
    private ImageView fb_login, google_login, apple_login, hide_password, email_correction;
    private LinearLayout reset_ll, txt_create_one_ll;


    public static LoginFragment newInstance() {

        LoginFragment loginFragment = new LoginFragment();
        Bundle b = new Bundle();
        loginFragment.setArguments(b);

        return loginFragment;
    }

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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {


        et_email = view.findViewById(R.id.et_email);
        et_password = view.findViewById(R.id.et_password);


        et_email_rl = view.findViewById(R.id.et_email_rl);
        et_password_rl = view.findViewById(R.id.et_password_rl);

        login_btn = view.findViewById(R.id.login_btn);

        fb_login = view.findViewById(R.id.fb_login);
        google_login = view.findViewById(R.id.google_login);
        apple_login = view.findViewById(R.id.apple_login);
        hide_password = view.findViewById(R.id.hide_password);
        email_correction = view.findViewById(R.id.email_correction);

        reset_ll = view.findViewById(R.id.reset_ll);
        txt_create_one_ll = view.findViewById(R.id.txt_create_one_ll);


    }

    private void viewSetup() {

        login_btn.setOnClickListener(this);
        fb_login.setOnClickListener(this);
        google_login.setOnClickListener(this);
        apple_login.setOnClickListener(this);
        reset_ll.setOnClickListener(this);
        txt_create_one_ll.setOnClickListener(this);
        hide_password.setOnClickListener(this);

//       if(et_email.requestFocus()){
//
//           et_email_rl.setBackground(getResources().getDrawable(R.drawable.rounded_corner_green_bg));
//           et_password_rl.setBackground(getResources().getDrawable(R.drawable.rounded_corner_grey_bg));
//
//       }if(et_password.requestFocus()) {
//
//            et_password.setBackground(getResources().getDrawable(R.drawable.rounded_corner_green_bg));
//           et_email_rl.setBackground(getResources().getDrawable(R.drawable.rounded_corner_grey_bg));
//
//
//       }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.login_btn:
//
//                if (et_email.getText().toString().isEmpty()) {
//
//                    et_email.setError("Please enter Email Id");
//
//                    if (et_password.getText().toString().isEmpty()) {
//
//                        et_password.setError("Please enter Password");
//
//                    }
//
//                }else {


                Intent intent = new Intent(getActivity(), HomeActivity.class);
                ((LoginActivity) getActivity()).startActivity(intent);
                ((LoginActivity) getActivity()).finish();

//                }


                break;

            case R.id.fb_login:

                Toast.makeText(getActivity(), "Fb login", Toast.LENGTH_SHORT).show();

                break;

            case R.id.google_login:

                Toast.makeText(getActivity(), "Google login", Toast.LENGTH_SHORT).show();

                break;

            case R.id.apple_login:

                Toast.makeText(getActivity(), "Apple login", Toast.LENGTH_SHORT).show();


                break;

            case R.id.reset_ll:

                ((LoginActivity) getActivity()).replaceFragment(new ResetPasswordFragment(), true,
                        KeyClass.FRAGMENT_RESET_PASSWORD, KeyClass.FRAGMENT_RESET_PASSWORD);

                break;

            case R.id.txt_create_one_ll:

                ((LoginActivity) getActivity()).replaceFragment(new SignupFragment(), false,
                        KeyClass.FRAGMENT_SIGNUP, KeyClass.FRAGMENT_SIGNUP);

                break;

            case R.id.hide_password:


//                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);


                break;
        }

    }
}