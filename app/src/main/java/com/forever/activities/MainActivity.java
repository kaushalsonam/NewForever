package com.forever.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.forever.R;
import com.forever.fragments.onBoardingScreens.OnBoardingFragments;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.forever.utilities.PrefrenceShared;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public static FrameLayout mcontainer;
    public static Context context;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        bindView();
        viewSetup();
    }

    private void bindView() {

        firebaseAuth=FirebaseAuth.getInstance();
        mcontainer = findViewById(R.id.mcontainer);

    }

    private void viewSetup() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        replaceFragment(new OnBoardingFragments(), false, KeyClass.FRAGMENT_ONBOARDING, KeyClass.FRAGMENT_ONBOARDING);


    }

    @Override
    protected void onStart() {
        super.onStart();

        if(PrefrenceShared.getInstance().getPreferenceData().getValueFromKey(Constant.loginflag)!=null){

            if(PrefrenceShared.getInstance().getPreferenceData().getValueFromKey(Constant.loginflag).equalsIgnoreCase("True")){

                Intent intent= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

            }

        }

//        if(firebaseAuth.getCurrentUser()!=null){
//
//            finish();
//            startActivity(new Intent(MainActivity.this,HomeActivity.class));
//
//        }else {}
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(MainActivity.mcontainer.getId(), fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(transactionName);
            fragmentTransaction.commitAllowingStateLoss();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}