package com.forever.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.forever.R;
import com.forever.fragments.Profile.ProfileFragment;
import com.forever.fragments.home.HomeFragment;
import com.forever.fragments.home.NotificationsFragment;
import com.forever.fragments.home.RewardFragment;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {

    public static FrameLayout container;
    public static Context context;
    public static BottomNavigationView bottom_navigation;


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


    }

    private void viewSetup() {

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottom_navigation.getChildAt(0);
        bottom_navigation.getMenu().getItem(0).setChecked(true);
        bottom_navigation.setItemIconTintList(null);


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


            switch (item.getItemId()) {

                case R.id.nav_home:

                    replaceFragment(new HomeFragment(),false,KeyClass.FRAGMENT_HOME,
                            KeyClass.FRAGMENT_HOME);



                    break;

                case R.id.nav_rewards:

                    replaceFragment(new RewardFragment(),false,KeyClass.FRAGMENT_REWARD,
                            KeyClass.FRAGMENT_REWARD);

                    break;

                case R.id.nav_notifications:

                    replaceFragment(new NotificationsFragment(),false,KeyClass.FRAGMENT_NOTIFICATIONS,
                            KeyClass.FRAGMENT_NOTIFICATIONS);

                    break;

                case R.id.nav_user:

                    replaceFragment(new ProfileFragment(),false,KeyClass.FRAGMENT_PROFILE,
                            KeyClass.FRAGMENT_PROFILE);

//                    Intent intent_profile= new Intent(context,ProfileActivity.class);
//                    startActivity(intent_profile);

                    break;


            }
            return false;
        }
    };
}