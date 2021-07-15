package com.forever.fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.fragments.home.PointsSummaryFragment;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class FoodActivityPointsFragment extends Fragment implements View.OnClickListener {

    private CardView next_btn_cv;
    private ImageView back_btn;


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
        return inflater.inflate(R.layout.fragment_food_activity_points, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        next_btn_cv = view.findViewById(R.id.next_btn_cv);
        back_btn = view.findViewById(R.id.back_btn);

    }

    private void viewSetup() {

        next_btn_cv.setOnClickListener(this);
        back_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.next_btn_cv:

                ((HomeActivity) getActivity()).replaceFragment(new PointsSummaryFragment(), true,
                        KeyClass.FRAGMENT_POINTS_SUMMARY, KeyClass.FRAGMENT_POINTS_SUMMARY);

                break;

            case R.id.back_btn:

                getActivity().onBackPressed();

                break;


        }
    }
}