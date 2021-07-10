package com.forever.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.adapter.AgeSpinnerRecycler;
import com.forever.fragments.home.HomeFragment;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class AgeFragment extends Fragment implements View.OnClickListener {

    private TextView txt_skip_btn;
    private ImageView back_btn;
    private CardView save_btn;
    private RelativeLayout save_rl;


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

        txt_skip_btn = view.findViewById(R.id.txt_skip_btn);
        back_btn = view.findViewById(R.id.back_btn);
        save_btn = view.findViewById(R.id.save_btn);
        save_rl = view.findViewById(R.id.save_rl);

    }

    private void viewSetup() {

        txt_skip_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        save_btn.setOnClickListener(this);
        save_rl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.txt_skip_btn:
            case R.id.save_btn:
            case R.id.save_rl:

                ((HomeActivity)getActivity()).replaceFragment(new HomeFragment(),true,
                        KeyClass.FRAGMENT_HOME,KeyClass.FRAGMENT_HOME);

                break;

            case R.id.back_btn:
                getActivity().onBackPressed();

                break;

        }
    }
}