package com.forever.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forever.R;

import org.jetbrains.annotations.NotNull;

public class Terms_PrivacyFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn,close_btn;
    private TextView terms_and_condition;



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
        return inflater.inflate(R.layout.fragment_terms__privacy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        back_btn=view.findViewById(R.id.back_btn);
        close_btn=view.findViewById(R.id.close_btn);
        terms_and_condition=view.findViewById(R.id.terms_and_condition);

    }

    private void viewSetup() {

        back_btn.setOnClickListener(this);
        close_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back_btn:
            case R.id.close_btn:

                getActivity().onBackPressed();

                break;
        }

    }
}