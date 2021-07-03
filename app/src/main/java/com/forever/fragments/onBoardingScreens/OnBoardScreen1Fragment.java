package com.forever.fragments.onBoardingScreens;

import android.content.Intent;
import android.database.Observable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forever.Model.OnBoardingModel;
import com.forever.R;
import com.forever.ViewModel.OnBoardingViewModel;
import com.forever.activities.LoginActivity;
import com.forever.activities.MainActivity;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class OnBoardScreen1Fragment extends Fragment implements View.OnClickListener, Observer<OnBoardingModel> {

    private TextView skip_btn, text1,dot1,dot2,dot3;
    private OnBoardingViewModel onBoardingViewModel;


    public static OnBoardScreen1Fragment newInstance() {

        OnBoardScreen1Fragment f = new OnBoardScreen1Fragment();
        Bundle b = new Bundle();
        f.setArguments(b);

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        viewModelSetup();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_board_screen1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        onBoardingViewModel.onBoardingScreen(getActivity());
    }

    private void bindView(View view) {

        skip_btn = view.findViewById(R.id.skip_btn);
        text1 = view.findViewById(R.id.text1);
        dot1 = view.findViewById(R.id.dot1);
        dot2 = view.findViewById(R.id.dot2);
        dot3 = view.findViewById(R.id.dot3);

    }

    private void viewSetup() {

        skip_btn.setOnClickListener(this);
        dot1.setOnClickListener(this);
        dot2.setOnClickListener(this);
        dot3.setOnClickListener(this);
//        text1.setText(getArguments().getString("msg"));

    }

    private void viewModelSetup() {

        onBoardingViewModel = new ViewModelProvider(this).get(OnBoardingViewModel.class);
        onBoardingViewModel.onBoarding.observe(this, this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.skip_btn:

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                ((MainActivity) getActivity()).startActivity(intent);
                ((MainActivity)getActivity()).finish();


                break;



            case R.id.dot2:

                ((MainActivity)getActivity()).replaceFragment(new OnBoardScreen2Fragment(),true,
                        KeyClass.FRAGMENT_ONBOARDING_SCREEN_2,KeyClass.FRAGMENT_ONBOARDING_SCREEN_2);

                break;

            case R.id.dot3:

                ((MainActivity)getActivity()).replaceFragment(new OnBoardScreen3Fragment(),true,
                        KeyClass.FRAGMENT_ONBOARDING_SCREEN_3,KeyClass.FRAGMENT_ONBOARDING_SCREEN_3);

                break;
        }

    }

    @Override
    public void onChanged(OnBoardingModel onBoardingModel) {

        if(onBoardingModel!=null && onBoardingModel.getData()!=null){

            text1.setText(onBoardingModel.getData().getOnboardingText1());

        }

    }
}