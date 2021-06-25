package com.forever.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forever.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;


public class OnBoardScreen3Fragment extends Fragment implements View.OnClickListener {

    private TextView done_btn,text1;

    public static OnBoardScreen3Fragment newInstance(String text) {

        OnBoardScreen3Fragment f = new OnBoardScreen3Fragment();
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
        return inflater.inflate(R.layout.fragment_on_board_screen3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();

    }

    private void bindView(View view) {

        done_btn=view.findViewById(R.id.done_btn);
        text1=view.findViewById(R.id.text1);

    }

    private void viewSetup() {
        done_btn.setOnClickListener(this);
//        text1.setText(getArguments().getString("msg"));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.done_btn:

                break;
        }

    }
}