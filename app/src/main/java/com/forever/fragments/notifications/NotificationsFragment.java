package com.forever.fragments.notifications;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.forever.R;
import com.forever.adapter.NotificationRecyclerAdapter;
import com.forever.utilities.AdapterItemClick;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class NotificationsFragment extends Fragment implements AdapterItemClick {

    private RecyclerView notification_recycler;
    private List<Integer> logoimage;
    private List<String> notificationType;
    private List<String> notificationHeading;
    private List<String> notificationOffer;
    private List<String> time;
    private NotificationRecyclerAdapter notificationRecyclerAdapter;
    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload;


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
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();

    }

    private void bindView(View view) {

        notification_recycler = getActivity().findViewById(R.id.notification_recycler);
        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);

        rl_upload=getActivity().findViewById(R.id.rl_upload);


    }

    private void viewSetup() {

        rl_upload.setVisibility(View.VISIBLE);
        bottom_navigation.setVisibility(View.VISIBLE);

        notification_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapterSetup();


    }

    @Override
    public void onItemClick(int position) {

    }


    private void adapterSetup() {


        logoimage = new ArrayList<>();
        logoimage.add(R.drawable.ic_shoes_brands);
        logoimage.add(R.drawable.ic_steps_noti);
        logoimage.add(R.drawable.ic_rewards_noti);
        logoimage.add(R.drawable.ic_upgrade);


        notificationType = new ArrayList<>();
        notificationType.add("Sport Shoes");
        notificationType.add("Steps");
        notificationType.add("Rewards");
        notificationType.add("Upgrade");

        notificationHeading = new ArrayList<>();
        notificationHeading.add("This Deal is truly unreal.");
        notificationHeading.add("You missed!!");
        notificationHeading.add("Added New Rewards.");
        notificationHeading.add("Schedule Maintenance");

        notificationOffer = new ArrayList<>();
        notificationOffer.add("Buy 1 style, get 2 free - 1 hour only!");
        notificationOffer.add("You are close to 500 points please complete your workout.");
        notificationOffer.add("Check this out, New rewards in your account.");
        notificationOffer.add("Schedule Maintenance start from Sunday 6/6/2021 @ 12:00 IST");


        time = new ArrayList<>();
        time.add("45m ago");
        time.add("50m ago");
        time.add("01h ago");
        time.add("01h ago");

        notificationRecyclerAdapter = new NotificationRecyclerAdapter(getActivity(),
                logoimage, notificationType, notificationHeading, notificationOffer, time, this);


        notification_recycler.setAdapter(notificationRecyclerAdapter);


    }

}