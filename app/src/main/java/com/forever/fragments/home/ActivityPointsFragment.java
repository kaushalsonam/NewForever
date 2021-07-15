package com.forever.fragments.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.fragments.Profile.FoodActivityPointsFragment;
import com.forever.utilities.Constant;
import com.forever.utilities.KeyClass;
import com.forever.utilities.PrefrenceShared;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

public class ActivityPointsFragment extends Fragment implements View.OnClickListener {

    private ImageView back_btn, info_btn, close_btn, txt_today_iv, txt_yesterday_iv, txt_last_week_iv,
            txt_last_month_iv, txt_custom_date_iv;
    private CardView custom_date_btn, total_steps_cv, gym_points_cv, food_points_cv, user_points_cv,
            custom_date_close_btn;
    private TextView txt_activity_points, txt_today, txt_yesterday, txt_last_week, txt_last_month,
            txt_custom_date, done_btn;
    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload, txt_today_rl, txt_yesterday_rl, txt_last_week_rl, txt_last_month_rl,
            txt_custom_date_rl;
    private BottomSheetDialog bottomSheetDialog, pointsBottomSheetDialog;
    private LinearLayout card_view_ll, no_activity_points_ll;


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
        return inflater.inflate(R.layout.fragment_activity_points, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);
        viewSetup();
    }

    private void bindView(View view) {

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);
        rl_upload = getActivity().findViewById(R.id.rl_upload);

        back_btn = view.findViewById(R.id.back_btn);
        info_btn = view.findViewById(R.id.info_btn);

        custom_date_btn = view.findViewById(R.id.custom_date_btn);
        total_steps_cv = view.findViewById(R.id.total_steps_cv);
        gym_points_cv = view.findViewById(R.id.gym_points_cv);
        food_points_cv = view.findViewById(R.id.food_points_cv);
        user_points_cv = view.findViewById(R.id.user_points_cv);

        txt_activity_points = view.findViewById(R.id.txt_activity_points);

        card_view_ll = view.findViewById(R.id.card_view_ll);
        no_activity_points_ll = view.findViewById(R.id.no_activity_points_ll);

    }

    private void viewSetup() {

        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        custom_date_btn.setOnClickListener(this);
        total_steps_cv.setOnClickListener(this);
        gym_points_cv.setOnClickListener(this);
        food_points_cv.setOnClickListener(this);
        user_points_cv.setOnClickListener(this);
        txt_activity_points.setOnClickListener(this);
        info_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back_btn:

                getActivity().onBackPressed();


                break;

            case R.id.custom_date_btn:

               setCustomDateBottomDialog();

                break;

            case R.id.total_steps_cv:
            case R.id.gym_points_cv:
            case R.id.user_points_cv:
            case R.id.food_points_cv:

                ((HomeActivity) getActivity()).replaceFragment(new PointsSummaryFragment(), true,
                        KeyClass.FRAGMENT_POINTS_SUMMARY, KeyClass.FRAGMENT_POINTS_SUMMARY);

                break;

            case R.id.txt_activity_points:
            case R.id.info_btn:

               setActivityPointsBottomDialog();

                break;



            case R.id.custom_date_close_btn:

                bottomSheetDialog.dismiss();

                break;

            case R.id.txt_today_rl:

                txt_today.setTextColor(getResources().getColor(R.color.black));
                txt_today_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_enable));

                txt_yesterday.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_yesterday_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_week.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_week_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_month.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_month_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_custom_date.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_custom_date_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                break;

            case R.id.txt_yesterday_rl:

                txt_yesterday.setTextColor(getResources().getColor(R.color.black));
                txt_yesterday_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_enable));

                txt_today.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_today_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_week.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_week_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_month.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_month_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_custom_date.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_custom_date_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));


                break;

            case R.id.txt_last_week_rl:

                txt_last_week.setTextColor(getResources().getColor(R.color.black));
                txt_last_week_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_enable));

                txt_today.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_today_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_yesterday.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_yesterday_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_month.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_month_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_custom_date.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_custom_date_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                break;

            case R.id.txt_last_month_rl:

                txt_last_month.setTextColor(getResources().getColor(R.color.black));
                txt_last_month_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_enable));

                txt_today.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_today_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_yesterday.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_yesterday_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_week.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_week_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_custom_date.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_custom_date_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                break;

            case R.id.txt_custom_date_rl:

                txt_custom_date.setTextColor(getResources().getColor(R.color.black));
                txt_custom_date_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_enable));

                txt_today.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_today_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_yesterday.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_yesterday_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_week.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_week_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                txt_last_month.setTextColor(getResources().getColor(R.color.et_hint_color));
                txt_last_month_iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_disable));

                break;

            case R.id.done_btn:

                bottomSheetDialog.dismiss();
                card_view_ll.setVisibility(View.GONE);
                no_activity_points_ll.setVisibility(View.VISIBLE);

                break;

            case R.id.close_btn:

                pointsBottomSheetDialog.dismiss();

                break;


        }

    }


    private void setCustomDateBottomDialog() {


        bottomSheetDialog = new BottomSheetDialog(getActivity());
        View parentView = getLayoutInflater().inflate(R.layout.custom_date_dialog, null);
        bottomSheetDialog.setContentView(parentView);


        custom_date_close_btn = parentView.findViewById(R.id.custom_date_close_btn);

        txt_today_rl = parentView.findViewById(R.id.txt_today_rl);
        txt_yesterday_rl = parentView.findViewById(R.id.txt_yesterday_rl);
        txt_last_week_rl = parentView.findViewById(R.id.txt_last_week_rl);
        txt_last_month_rl = parentView.findViewById(R.id.txt_last_month_rl);
        txt_custom_date_rl = parentView.findViewById(R.id.txt_custom_date_rl);

        txt_today = parentView.findViewById(R.id.txt_today);
        txt_yesterday = parentView.findViewById(R.id.txt_yesterday);
        txt_last_week = parentView.findViewById(R.id.txt_last_week);
        txt_last_month = parentView.findViewById(R.id.txt_last_month);
        txt_custom_date = parentView.findViewById(R.id.txt_custom_date);

        txt_today_iv = parentView.findViewById(R.id.txt_today_iv);
        txt_yesterday_iv = parentView.findViewById(R.id.txt_yesterday_iv);
        txt_last_week_iv = parentView.findViewById(R.id.txt_last_week_iv);
        txt_last_month_iv = parentView.findViewById(R.id.txt_last_month_iv);
        txt_custom_date_iv = parentView.findViewById(R.id.txt_custom_date_iv);

        done_btn = parentView.findViewById(R.id.done_btn);


        custom_date_close_btn.setOnClickListener(this);

        txt_today_rl.setOnClickListener(this);
        txt_yesterday_rl.setOnClickListener(this);
        txt_last_week_rl.setOnClickListener(this);
        txt_last_month_rl.setOnClickListener(this);
        txt_custom_date_rl.setOnClickListener(this);

        done_btn.setOnClickListener(this);

        bottomSheetDialog.show();


    }


    private void setActivityPointsBottomDialog() {

        pointsBottomSheetDialog = new BottomSheetDialog(getActivity());
        View parentView = getLayoutInflater().inflate(R.layout.activity_points_dialog, null);
        pointsBottomSheetDialog.setContentView(parentView);


        close_btn = parentView.findViewById(R.id.close_btn);

        close_btn.setOnClickListener(this);


        pointsBottomSheetDialog.show();


    }
}