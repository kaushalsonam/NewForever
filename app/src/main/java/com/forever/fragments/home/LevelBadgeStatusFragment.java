package com.forever.fragments.home;

import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.adapter.LevelBadgeRecyclerAdapter;
import com.forever.customLibararies.CustomRecycler.CircleRecyclerView;
import com.forever.customLibararies.CustomRecycler.ScaleXViewMode;
import com.forever.fragments.Profile.ProfileFragment;
import com.forever.fragments.reward.RewardFragment;
import com.forever.utilities.CenterLayoutManagerHorizontal;
import com.forever.utilities.EndlessRecyclerOnScrollListener;
import com.forever.utilities.KeyClass;
import com.forever.utilities.ScaleCenterItemLayoutManager;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelBadgeStatusFragment extends Fragment implements View.OnClickListener {

    private BottomNavigationView bottom_navigation;
    private RelativeLayout rl_upload;
    private ImageView back_btn;
    private SwitchCompat toggle_btn;
    private CardView next_btn;
    private CircleRecyclerView level_badge_recycler;
    private LevelBadgeRecyclerAdapter badgeRecyclerAdapter;
    private List<Integer> badgeImage;
    private List<String> badgeName;
    private CenterLayoutManagerHorizontal centerLayoutManagerHorizontal;
    private ScaleXViewMode scaleXViewMode;
    private LineChart level_chart;
    private LineData lineData;
    private LineDataSet lineDataSet;
    private List<Entry> entryList = new ArrayList<>();


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
        return inflater.inflate(R.layout.fragment_level_badge_status, container, false);
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
        toggle_btn = view.findViewById(R.id.toggle_btn);
        next_btn = view.findViewById(R.id.next_btn);


        level_badge_recycler = view.findViewById(R.id.level_badge_recycler);

        level_chart = view.findViewById(R.id.level_chart);


    }


    private void viewSetup() {
        //        level_badge_recycler.setHasFixedSize(true);
//
//        level_badge_recycler.setPadding(50,50,50,50);


        bottom_navigation.setVisibility(View.GONE);
        rl_upload.setVisibility(View.GONE);

        back_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);


        adapterSetup();

        setLevelGraph();


        toggle_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (toggle_btn.isPressed()) {

                    ((HomeActivity) getActivity()).replaceFragment(new ProfileFragment(), true,
                            KeyClass.FRAGMENT_PROFILE, KeyClass.FRAGMENT_PROFILE);


                    toggle_btn.setChecked(false);
                }

            }
        });


    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.back_btn:

                getActivity().onBackPressed();

                break;

            case R.id.next_btn:

                ((HomeActivity) getActivity()).replaceFragment(new RewardFragment(), true,
                        KeyClass.FRAGMENT_REWARD, KeyClass.FRAGMENT_REWARD);

                break;


        }
    }


    private void adapterSetup() {

        badgeImage = new ArrayList<>();
        badgeImage.add(R.drawable.ic_badge_level);
        badgeImage.add(R.drawable.ic_level1);
        badgeImage.add(R.drawable.ic_level2);
        badgeImage.add(R.drawable.ic_badge_level);
        badgeImage.add(R.drawable.ic_level1);
        badgeImage.add(R.drawable.ic_level2);

        badgeName = new ArrayList<>();
        badgeName.add("Gold");
        badgeName.add("Bronze");
        badgeName.add("Silver");
        badgeName.add("Gold");
        badgeName.add("Bronze");
        badgeName.add("Silver");


        scaleXViewMode = new ScaleXViewMode();


        centerLayoutManagerHorizontal = new CenterLayoutManagerHorizontal(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        //ScaleCenterItemLayoutManager layoutManager= new ScaleCenterItemLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        badgeRecyclerAdapter = new LevelBadgeRecyclerAdapter(getActivity(), badgeImage, badgeName);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        level_badge_recycler.setLayoutManager(centerLayoutManagerHorizontal);
        level_badge_recycler.setViewMode(scaleXViewMode);
        level_badge_recycler.setNeedCenterForce(true); // when SCROLL_STATE_IDLE == state, nearly center itemview scroll to center
//        level_badge_recycler.setNeedLoop(true); // default is true
        level_badge_recycler.setAdapter(badgeRecyclerAdapter);


    }

    private void setLevelGraph() {


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        List<String> xAxisValues = new ArrayList<>(Arrays.asList("Bronze", "Silver", "Gold", "Gold"));
        List<Entry> incomeEntries = getIncomeEntries();
        dataSets = new ArrayList<>();
        LineDataSet set1;

        set1 = new LineDataSet(incomeEntries, "Platinum");
        set1.setColor(getResources().getColor(R.color.dotcolor));
        set1.setValueTextColor(getResources().getColor(R.color.et_hint_color ));
        set1.setValueTextSize(10f);
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSets.add(set1);

//customization

        level_chart.setTouchEnabled(true);
        level_chart.setDragEnabled(true);
        level_chart.setScaleEnabled(false);
        level_chart.setPinchZoom(false);
        level_chart.setDrawGridBackground(false);
        
        //to hide background lines
        level_chart.getXAxis().setDrawGridLines(true);
        level_chart.getAxisLeft().setDrawGridLines(false);
        level_chart.getAxisRight().setDrawGridLines(false);


        //to hide right Y and top X border
        YAxis rightYAxis = level_chart.getAxisRight();
        rightYAxis.setEnabled(false);
        YAxis leftYAxis = level_chart.getAxisLeft();
        leftYAxis.setEnabled(false);
        XAxis topXAxis = level_chart.getXAxis();
        topXAxis.setEnabled(false);


        XAxis xAxis = level_chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setEnabled(true);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        set1.setLineWidth(5f);
        set1.setCircleRadius(5f);
        set1.setDrawValues(false);
        set1.setCircleHoleColor(getResources().getColor(R.color.dotcolor));
        set1.setCircleColor(getResources().getColor(R.color.dotcolor));

        //String setter in x-Axis
        level_chart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(xAxisValues));

        LineData data = new LineData(dataSets);
        level_chart.setData(data);
        level_chart.invalidate();
        level_chart.getLegend().setEnabled(false);
        level_chart.getDescription().setEnabled(false);


    }


    private List<Entry> getIncomeEntries() {
        ArrayList<Entry> incomeEntries = new ArrayList<>();

        incomeEntries.add(new Entry(1, 10));
        incomeEntries.add(new Entry(2, 20));
        incomeEntries.add(new Entry(3, 30));
        incomeEntries.add(new Entry(4, 40));


        return incomeEntries.subList(0, 4);
    }

}