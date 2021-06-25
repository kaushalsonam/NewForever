package com.forever.fragments;

import android.bluetooth.le.ScanRecord;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forever.R;
import com.forever.activities.LoginActivity;
import com.forever.activities.MainActivity;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;


public class OnBoardScreen1Fragment extends Fragment implements View.OnClickListener {

    private TextView skip_btn,text1;

    public static OnBoardScreen1Fragment newInstance(String text) {

        OnBoardScreen1Fragment f = new OnBoardScreen1Fragment();
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
        return inflater.inflate(R.layout.fragment_on_board_screen1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        skip_btn = view.findViewById(R.id.skip_btn);
        text1 = view.findViewById(R.id.text1);

    }

    private void viewSetup() {

        skip_btn.setOnClickListener(this);
//        text1.setText(getArguments().getString("msg"));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.skip_btn:

//                Intent intent= new Intent(OnBoardScreen1Fragment.this, LoginActivity.class);



                break;

        }

    }
}