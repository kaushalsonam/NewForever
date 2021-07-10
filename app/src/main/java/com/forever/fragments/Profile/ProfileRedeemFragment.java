package com.forever.fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.forever.R;
import com.forever.adapter.NewArrivalRecyclerAdapter;
import com.forever.utilities.AdapterItemClick;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ProfileRedeemFragment extends Fragment implements View.OnClickListener, AdapterItemClick {

    private RecyclerView redeem_recycler_view;
    private ImageView ic_back;
    private NewArrivalRecyclerAdapter adapter;
    private List<Integer> image_logo;
    private List<Integer> color;
    private List<String> offer_text;
    private List<String> expired_date;
    private BottomNavigationView bottom_navigation;


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
        return inflater.inflate(R.layout.fragment_profile_redeem, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottom_navigation=getActivity().findViewById(R.id.bottom_navigation);

        redeem_recycler_view = view.findViewById(R.id.redeem_recycler_view);
        ic_back = view.findViewById(R.id.ic_back);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);

        ic_back.setOnClickListener(this);

        adapterSetup();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ic_back:

                getActivity().onBackPressed();

                break;
        }

    }


    private void adapterSetup() {

        image_logo = new ArrayList<>();
        image_logo.add(R.drawable.ic_nike);
        image_logo.add(R.drawable.ic_daiya);
        image_logo.add(R.drawable.ic_nike);


        offer_text = new ArrayList<>();
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");


        expired_date = new ArrayList<>();
        expired_date.add("Feb 22, 2021");
        expired_date.add("Feb 22, 2021");
        expired_date.add("Feb 22, 2021");

        color = new ArrayList<>();
        color.add(R.drawable.white_rounded_corner_white_bg);
        color.add(R.drawable.white_rounded_corner_white_bg);
        color.add(R.drawable.white_rounded_corner_white_bg);

        adapter = new NewArrivalRecyclerAdapter(getActivity(), image_logo, offer_text, expired_date, color, this);

        redeem_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        redeem_recycler_view.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {

    }
}