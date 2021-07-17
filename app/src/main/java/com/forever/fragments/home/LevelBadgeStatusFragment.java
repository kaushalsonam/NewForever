package com.forever.fragments.home;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.adapter.LevelBadgeRecyclerAdapter;
import com.forever.fragments.Profile.ProfileFragment;
import com.forever.fragments.reward.RewardFragment;
import com.forever.utilities.CenterLayoutManagerHorizontal;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LevelBadgeStatusFragment extends Fragment implements View.OnClickListener {

    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload;
    private ImageView back_btn;
    private SwitchCompat toggle_btn;
    private CardView next_btn;
    private RecyclerView level_badge_recycler;
    private LevelBadgeRecyclerAdapter badgeRecyclerAdapter;
    private List<Integer> badgeImage;
    private List<String> badgeName;
    private CenterLayoutManagerHorizontal snapHelper;


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
        return inflater.inflate(R.layout.fragment_level_badge_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       bindView(view);
        viewSetup();
    }

    private void bindView(View view){

        bottom_navigation=getActivity().findViewById(R.id.bottom_navigation);
        rl_upload=getActivity().findViewById(R.id.rl_upload);


        back_btn=view.findViewById(R.id.back_btn);
        toggle_btn=view.findViewById(R.id.toggle_btn);
        next_btn=view.findViewById(R.id.next_btn);


        level_badge_recycler=view.findViewById(R.id.level_badge_recycler);



    }


    private void viewSetup() {


//        level_badge_recycler.setHasFixedSize(true);
//
//        level_badge_recycler.setPadding(50,50,50,50);


        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);


        adapterSetup();


        toggle_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (toggle_btn.isPressed()) {

                    ((HomeActivity) getActivity()).replaceFragment(new ProfileFragment(), true,
                            KeyClass.FRAGMENT_PROFILE, KeyClass.FRAGMENT_PROFILE);


                    toggle_btn.setChecked(false);
                }

            }
        });


    }



    @Override
    public void onClick(View v) {


        switch (v.getId()){


            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.next_btn:

                ((HomeActivity)getActivity()).replaceFragment(new RewardFragment(),true,
                        KeyClass.FRAGMENT_REWARD,KeyClass.FRAGMENT_REWARD);

                break;


        }
    }


    private void adapterSetup(){

        badgeImage= new ArrayList<>();
        badgeImage.add(R.drawable.ic_badge_level);
        badgeImage.add(R.drawable.ic_level1);
        badgeImage.add(R.drawable.ic_level2);
        badgeImage.add(R.drawable.ic_badge_level);
        badgeImage.add(R.drawable.ic_level1);
        badgeImage.add(R.drawable.ic_level2);

        badgeName= new ArrayList<>();
        badgeName.add("Gold");
        badgeName.add("Bronze");
        badgeName.add("Silver");
        badgeName.add("Gold");
        badgeName.add("Bronze");
        badgeName.add("Silver");




        badgeRecyclerAdapter= new LevelBadgeRecyclerAdapter(getActivity(),badgeImage,badgeName);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        level_badge_recycler.setLayoutManager(layoutManager);
        level_badge_recycler.setAdapter(badgeRecyclerAdapter);


    }
}