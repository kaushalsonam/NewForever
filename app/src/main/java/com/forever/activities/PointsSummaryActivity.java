package com.forever.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.forever.R;
import com.forever.utilities.Constant;

public class PointsSummaryActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_day,txt_week,txt_month;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_summary);


        Intent intent = getIntent();

        type = intent.getStringExtra(Constant.Type);

        bindView();
        viewSetup();
    }

    private void bindView() {

        txt_day=findViewById(R.id.txt_day);
        txt_week=findViewById(R.id.txt_week);
        txt_month=findViewById(R.id.txt_month);

    }

    private void viewSetup() {

        if (type!=null){

            if(type.equalsIgnoreCase("Day")){

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_day.setTextColor(getResources().getColor(R.color.white));

            }else {

                txt_day.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_day.setTextColor(getResources().getColor(R.color.dotcolor));

            }

            if(type.equalsIgnoreCase("week")){

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue_dark));
                txt_week.setTextColor(getResources().getColor(R.color.white));

            }else {

                txt_week.setBackground(getResources().getDrawable(R.drawable.rounded_corner_skyblue));
                txt_week.setTextColor(getResources().getColor(R.color.dotcolor));

            }

        }

    }

    @Override
    public void onClick(View v) {

    }
}