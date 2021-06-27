package com.forever.fragments.onBoardingScreens;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.LoginActivity;
import com.forever.activities.MainActivity;

import org.jetbrains.annotations.NotNull;

public class OnBoardScreen2Fragment extends Fragment implements View.OnClickListener {

    private TextView skip_btn,text1;

    public static OnBoardScreen2Fragment newInstance(String text) {

        OnBoardScreen2Fragment f = new OnBoardScreen2Fragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }



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
        return inflater.inflate(R.layout.fragment_on_board_screen2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        skip_btn=view.findViewById(R.id.skip_btn);

    }

    private void viewSetup() {

        skip_btn.setOnClickListener(this);
//        text1.setText(getArguments().getString("msg"));


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.skip_btn:

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                ((MainActivity) getActivity()).startActivity(intent);
                ((MainActivity)getActivity()).finish();

                break;
        }

    }
}