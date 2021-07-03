package com.forever.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.forever.R;
import com.forever.adapter.AgeSpinnerRecycler;

import org.jetbrains.annotations.NotNull;


public class AgeFragment extends Fragment {

    private RecyclerView age_spinner_recycler;
    private AgeSpinnerRecycler adapter;




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
        return inflater.inflate(R.layout.fragment_age, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

//        age_spinner_recycler=view.findViewById(R.id.age_spinner_recycler);

        



    }

    private void viewSetup() {

        age_spinner_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter= new AgeSpinnerRecycler(getActivity());

        age_spinner_recycler.setAdapter(adapter);



    }
}