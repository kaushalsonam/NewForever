package com.forever.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.forever.R;
import com.forever.fragments.Profile.ProfileFragment;
import com.forever.fragments.home.HomeFragment;
import com.forever.fragments.home.UploadReceiptsFragment;
import com.forever.fragments.notifications.NotificationsFragment;
import com.forever.fragments.reward.RewardFragment;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static FrameLayout container;
    public static Context context;
    public static BottomNavigationView bottom_navigation;
    public RelativeLayout rl_upload;
    public Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;

        bindView();
        viewSetup();
    }

    private void bindView() {

        container = findViewById(R.id.container);

        //bottom navigation
        bottom_navigation = findViewById(R.id.bottom_navigation);
        rl_upload = findViewById(R.id.rl_upload);

        rl_upload.setOnClickListener(this);


    }

    private void viewSetup() {



        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottom_navigation.setItemIconTintList(null);




//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);




        replaceFragment(new HomeFragment(), false, KeyClass.FRAGMENT_HOME,
                KeyClass.FRAGMENT_HOME);




    }


    public void replaceFragment(Fragment fragment, boolean addToBackStack, String transactionName, String tag) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(HomeActivity.container.getId(), fragment, tag);
            if (addToBackStack)
                fragmentTransaction.addToBackStack(transactionName);
            fragmentTransaction.commitAllowingStateLoss();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


            Menu menu = bottom_navigation.getMenu();
            menu.findItem(R.id.nav_home).setIcon(R.drawable.home_deselect);
            menu.findItem(R.id.nav_rewards).setIcon(R.drawable.rewards_deselected);
            menu.findItem(R.id.nav_notifications).setIcon(R.drawable.notification_deselected);
            menu.findItem(R.id.nav_user).setIcon(R.drawable.peofile_deselect);


            switch (item.getItemId()) {

                case R.id.nav_home:
                    rl_upload.setVisibility(View.VISIBLE);
                    replaceFragment(new HomeFragment(), true, KeyClass.FRAGMENT_HOME,
                            KeyClass.FRAGMENT_HOME);

                    item.setIcon(R.drawable.home_select);



                break;

                case R.id.nav_rewards:
                    rl_upload.setVisibility(View.GONE);
                    replaceFragment(new RewardFragment(), true, KeyClass.FRAGMENT_REWARD,
                            KeyClass.FRAGMENT_REWARD);

                    item.setIcon(R.drawable.rewards_select);


                    break;

                case R.id.nav_notifications:
                    rl_upload.setVisibility(View.GONE);
                    replaceFragment(new NotificationsFragment(), true, KeyClass.FRAGMENT_NOTIFICATIONS,
                            KeyClass.FRAGMENT_NOTIFICATIONS);

                    item.setIcon(R.drawable.notification_selected);


                    break;

                case R.id.nav_user:
                    rl_upload.setVisibility(View.GONE);
                    replaceFragment(new ProfileFragment(), true, KeyClass.FRAGMENT_PROFILE,
                            KeyClass.FRAGMENT_PROFILE);

                    item.setIcon(R.drawable.peofile_select);

//                    Intent intent_profile= new Intent(context,ProfileActivity.class);
//                    startActivity(intent_profile);

                    break;


            }
            return false;


        }
    };


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rl_upload:

                replaceFragment(new UploadReceiptsFragment(), true, KeyClass.FRAGMENT_UPLOAD_RECEIPTS,
                        KeyClass.FRAGMENT_UPLOAD_RECEIPTS);

                break;

        }

    }
}