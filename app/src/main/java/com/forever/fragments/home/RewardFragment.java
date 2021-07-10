package com.forever.fragments.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.forever.R;
import com.forever.adapter.CategoryListAdapter;
import com.forever.adapter.FilterItemListAdapter;
import com.forever.adapter.NewArrivalRecyclerAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RewardFragment extends Fragment implements View.OnClickListener {

    private NewArrivalRecyclerAdapter adapter;
    private RecyclerView new_arrival_recycler;
    private ImageView filter_ic;
    private Context mCtx;
    private List<String> category;
    private List<String> item;



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
        return inflater.inflate(R.layout.fragment_reward, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCtx = getContext();

        bindView(view);
        viewSetup();


    }

    private void bindView(View view) {

        new_arrival_recycler=view.findViewById(R.id.new_arrival_recycler);
        filter_ic = view.findViewById(R.id.filter_ic);

        category = new ArrayList<>();
        category.add("Category");
        category.add("Partner & Brands");
        category.add("All");

        item = new ArrayList<>();
        item.add("Active Wear");
        item.add("Fitness");
        item.add("Sleep Care");
        item.add("Health & Relaxation");
        item.add("Home & Kitchen");


    }

    private void viewSetup() {

        adapter= new NewArrivalRecyclerAdapter(getActivity());
        new_arrival_recycler.setLayoutManager(new LinearLayoutManager(mCtx));
        new_arrival_recycler.setAdapter(adapter);

        filter_ic.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.filter_ic:
                showDialog();
                break;

        }
    }
    private void showDialog(){
        BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(mCtx);
        View parentView = getLayoutInflater().inflate(R.layout.bottom_dailog_filter_layout,null);
        bottomSheerDialog.setContentView(parentView);
        RecyclerView recycler_FilterCategory,recycler_FilterCategoryItem;
        RecyclerView.LayoutManager layoutManager,layoutManager1;

        recycler_FilterCategoryItem = parentView.findViewById(R.id.recycler_FilterCategoryItem);
        layoutManager1 = new LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false);
        recycler_FilterCategoryItem.setLayoutManager(layoutManager1);

        FilterItemListAdapter filterItemListAdapter = new FilterItemListAdapter(mCtx,item);
        recycler_FilterCategoryItem.setAdapter(filterItemListAdapter);

        recycler_FilterCategory = parentView.findViewById(R.id.recycler_FilterCategory);
        layoutManager = new LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false);
        recycler_FilterCategory.setLayoutManager(layoutManager);

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(mCtx,category);
        recycler_FilterCategory.setAdapter(categoryListAdapter);




        bottomSheerDialog.show();
    }
}