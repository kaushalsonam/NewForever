package com.forever.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;

import org.jetbrains.annotations.NotNull;


public class GenderFragment extends Fragment implements View.OnClickListener {


    private ImageView male_icon,female_icon,non_binary_icon,back_btn;
    private TextView txt_male,txt_female,txt_non_binary,txt_skip_btn;
    private CardView save_btn;

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
        return inflater.inflate(R.layout.fragment_gender, container, false);


    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        male_icon=view.findViewById(R.id.male_icon);
        female_icon=view.findViewById(R.id.female_icon);
        non_binary_icon=view.findViewById(R.id.non_binary_icon);
        back_btn=view.findViewById(R.id.back_btn);

        txt_male=view.findViewById(R.id.txt_male);
        txt_female=view.findViewById(R.id.txt_female);
        txt_non_binary=view.findViewById(R.id.txt_non_binary);
        txt_skip_btn=view.findViewById(R.id.txt_skip_btn);

        save_btn=view.findViewById(R.id.save_btn);

    }

    private void viewSetup() {

        male_icon.setOnClickListener(this);
        female_icon.setOnClickListener(this);
        non_binary_icon.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        txt_skip_btn.setOnClickListener(this);
        save_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.male_icon:

                male_icon.setColorFilter(getResources().getColor(R.color.white));
                male_icon.setBackgroundColor(getResources().getColor(R.color.dotcolor));

                female_icon.setColorFilter(getResources().getColor(R.color.female_gender));
                female_icon.setBackgroundColor(getResources().getColor(R.color.white));

                non_binary_icon.setColorFilter(getResources().getColor(R.color.non_binary));
                non_binary_icon.setBackgroundColor(getResources().getColor(R.color.white));

                txt_male.setTextColor(getResources().getColor(R.color.black));
                txt_female.setTextColor(getResources().getColor(R.color.non_binary));
                txt_non_binary.setTextColor(getResources().getColor(R.color.non_binary));


                break;

            case R.id.female_icon:


                female_icon.setColorFilter(getResources().getColor(R.color.white));
                female_icon.setBackgroundColor(getResources().getColor(R.color.female_gender));

                male_icon.setColorFilter(getResources().getColor(R.color.dotcolor));
                male_icon.setBackgroundColor(getResources().getColor(R.color.white));

                non_binary_icon.setColorFilter(getResources().getColor(R.color.non_binary));
                non_binary_icon.setBackgroundColor(getResources().getColor(R.color.white));

                txt_male.setTextColor(getResources().getColor(R.color.non_binary));
                txt_non_binary.setTextColor(getResources().getColor(R.color.non_binary));
                txt_female.setTextColor(getResources().getColor(R.color.black));

                break;

            case R.id.non_binary_icon:

                non_binary_icon.setColorFilter(getResources().getColor(R.color.white));
                non_binary_icon.setBackgroundColor(getResources().getColor(R.color.non_binary));

                female_icon.setColorFilter(getResources().getColor(R.color.female_gender));
                female_icon.setBackgroundColor(getResources().getColor(R.color.white));

                male_icon.setColorFilter(getResources().getColor(R.color.dotcolor));
                male_icon.setBackgroundColor(getResources().getColor(R.color.white));


                txt_male.setTextColor(getResources().getColor(R.color.non_binary));
                txt_female.setTextColor(getResources().getColor(R.color.non_binary));
                txt_non_binary.setTextColor(getResources().getColor(R.color.black));

                break;

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

                
            case R.id.txt_skip_btn:

                Toast.makeText(getActivity(), "skip", Toast.LENGTH_SHORT).show();
                
                break;

            case R.id.save_btn:

                Toast.makeText(getActivity(), "save", Toast.LENGTH_SHORT).show();

                break;

        }

    }
}