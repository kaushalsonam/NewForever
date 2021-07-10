package com.forever.fragments.reward;

import android.media.Image;
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
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.adapter.NewArrivalRecyclerAdapter;
import com.forever.utilities.AdapterItemClick;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class SearchByLocationFragment extends Fragment implements View.OnClickListener, AdapterItemClick {

    private ImageView close_btn;
    private RecyclerView rewards_recycler_view;
    private NewArrivalRecyclerAdapter adapter;
    private BottomNavigationView bottom_navigation;
    private TextView txt_see_all;
    private List<Integer> image_logo;
    private List<Integer> color;
    private List<String> offer_text;
    private List<String> expired_date;


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
        return inflater.inflate(R.layout.fragment_search_by_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottom_navigation=getActivity().findViewById(R.id.bottom_navigation);

        close_btn=view.findViewById(R.id.close_btn);
        rewards_recycler_view=view.findViewById(R.id.rewards_recycler_view);
        txt_see_all=view.findViewById(R.id.txt_see_all);




    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);

        close_btn.setOnClickListener(this);
        txt_see_all.setOnClickListener(this);

        adapterSetup();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.close_btn:

                getActivity().onBackPressed();

                break;

            case R.id.txt_see_all:

                Toast.makeText(getActivity(), "Share", Toast.LENGTH_SHORT).show();

                break;
        }

    }

    @Override
    public void onItemClick(int position) {

        ((HomeActivity)getActivity()).replaceFragment(new OfferDetailFragment(),true,
                KeyClass.FRAGMENT_OFFER_DETAILS,KeyClass.FRAGMENT_OFFER_DETAILS);

    }


    private void adapterSetup(){

        image_logo= new ArrayList<>();
        image_logo.add(R.drawable.ic_nike);
        image_logo.add(R.drawable.ic_being_human);
        image_logo.add(R.drawable.ic_daiya);


        offer_text= new ArrayList<>();
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");


        expired_date= new ArrayList<>();
        expired_date.add("Feb 22, 2021");
        expired_date.add("Feb 22, 2021");
        expired_date.add("Feb 22, 2021");

        color= new ArrayList<>();
        color.add(R.drawable.white_rounded_corner_white_bg);
        color.add(R.drawable.white_rounded_corner_white_bg);
        color.add(R.drawable.white_rounded_corner_white_bg);


        adapter= new NewArrivalRecyclerAdapter(getActivity(),image_logo,offer_text,expired_date,color,this);

        rewards_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        rewards_recycler_view.setAdapter(adapter);

    }
}