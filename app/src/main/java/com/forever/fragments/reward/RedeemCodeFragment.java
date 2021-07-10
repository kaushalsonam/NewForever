package com.forever.fragments.reward;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;

import org.jetbrains.annotations.NotNull;

public class RedeemCodeFragment extends Fragment implements View.OnClickListener {


    private ImageView close_btn;
    private WebView redeem_webview;
    private TextView txt_reload;


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
        return inflater.inflate(R.layout.fragment_redeem_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();

    }

    private void bindView(View view) {

        close_btn=view.findViewById(R.id.close_btn);
        redeem_webview=view.findViewById(R.id.redeem_webview);
        txt_reload=view.findViewById(R.id.txt_reload);


    }

    private void viewSetup() {

        close_btn.setOnClickListener(this);
        txt_reload.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.close_btn:

                getActivity().onBackPressed();

                break;

            case R.id.txt_reload:

                Toast.makeText(getActivity(), "reload", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}