package com.forever.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.forever.R;
import com.forever.fragments.loginSignup.LoginFragment;
import com.forever.fragments.loginSignup.LoginWithPhoneFragment;
import com.forever.utilities.KeyClass;

public class LoginActivity extends AppCompatActivity {

    public static FrameLayout container;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        bindView();
        viewSetup();
    }

    private void bindView() {

        container = findViewById(R.id.container);


    }

    private void viewSetup() {

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        replaceFragment(new LoginWithPhoneFragment(),false, KeyClass.FRAGMENT_LOGIN_WITH_PHONE,
                KeyClass.FRAGMENT_LOGIN_WITH_PHONE);

    }


    public void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(LoginActivity.container.getId(), fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(transactionName);
            fragmentTransaction.commitAllowingStateLoss();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}