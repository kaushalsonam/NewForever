package com.forever.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forever.R;
import com.forever.adapter.NewArrivalRecyclerAdapter;

import org.jetbrains.annotations.NotNull;

public class RewardFragment extends Fragment implements View.OnClickListener {

    private NewArrivalRecyclerAdapter adapter;
    private RecyclerView new_arrival_recycler;



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
        return inflater.inflate(R.layout.fragment_reward, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        bindView(view);
        viewSetup();


    }

    private void bindView(View view) {

        new_arrival_recycler=view.findViewById(R.id.new_arrival_recycler);


    }

    private void viewSetup() {

        adapter= new NewArrivalRecyclerAdapter(getActivity());
        new_arrival_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        new_arrival_recycler.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


        }
    }
}