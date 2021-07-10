package com.forever.fragments.reward;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.adapter.CategoryListAdapter;
import com.forever.adapter.FilterItemListAdapter;
import com.forever.adapter.MegaOfferRecyclerAdapter;
import com.forever.adapter.NewArrivalRecyclerAdapter;
import com.forever.fragments.Profile.ProfileFragment;
import com.forever.utilities.AdapterItemClick;
import com.forever.utilities.KeyClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RewardFragment extends Fragment implements View.OnClickListener, TextWatcher, AdapterItemClick {

    private NewArrivalRecyclerAdapter adapter;
    private RecyclerView new_arrival_recycler, recommeded_recycler, mega_offer_recycler;
    private ImageView filter_ic, map_img, cut_btn;
    private Context mCtx;
    private List<String> category;
    private List<String> item;
    private BottomNavigationView bottomNavigationView;
    private EditText search_et;
    private LinearLayout main_data_ll, empty_rewards_ll;
    private SwitchCompat toggle_btn;
    private BottomNavigationView bottom_navigation;
    private List<Integer> image_logo;
    private List<Integer> color;
    private List<String> offer_text;
    private List<String> expired_date;
    private MegaOfferRecyclerAdapter megaOfferRecyclerAdapter;


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

        bottom_navigation = getActivity().findViewById(R.id.bottom_navigation);

        new_arrival_recycler = view.findViewById(R.id.new_arrival_recycler);
        recommeded_recycler = view.findViewById(R.id.recommeded_recycler);
        mega_offer_recycler = view.findViewById(R.id.mega_offer_recycler);
        filter_ic = view.findViewById(R.id.filter_ic);
        search_et = view.findViewById(R.id.search_et);
        map_img = view.findViewById(R.id.map_img);
        cut_btn = view.findViewById(R.id.cut_btn);
        main_data_ll = view.findViewById(R.id.main_data_ll);
        empty_rewards_ll = view.findViewById(R.id.empty_rewards_ll);
        toggle_btn = view.findViewById(R.id.toggle_btn);


        bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);

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

        bottom_navigation.setVisibility(View.VISIBLE);

        bottomNavigationView.setVisibility(View.VISIBLE);


        filter_ic.setOnClickListener(this);
        cut_btn.setOnClickListener(this);
        map_img.setOnClickListener(this);

        search_et.addTextChangedListener(this);

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
        adapterSetup();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.filter_ic:

                showDialog();

                break;

            case R.id.cut_btn:

                search_et.setText("");
                map_img.setVisibility(View.VISIBLE);
                cut_btn.setVisibility(View.GONE);

                break;

            case R.id.map_img:

                ((HomeActivity) getActivity()).replaceFragment(new SearchByLocationFragment(), true,
                        KeyClass.FRAGMENT_SEARCH_BY_LOCATION, KeyClass.FRAGMENT_SEARCH_BY_LOCATION);

                break;

        }
    }

    private void showDialog() {
        BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(mCtx);
        View parentView = getLayoutInflater().inflate(R.layout.bottom_dailog_filter_layout, null);
        bottomSheerDialog.setContentView(parentView);
        RecyclerView recycler_FilterCategory, recycler_FilterCategoryItem;
        RecyclerView.LayoutManager layoutManager, layoutManager1;

        recycler_FilterCategoryItem = parentView.findViewById(R.id.recycler_FilterCategoryItem);
        layoutManager1 = new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false);
        recycler_FilterCategoryItem.setLayoutManager(layoutManager1);

        FilterItemListAdapter filterItemListAdapter = new FilterItemListAdapter(mCtx, item);
        recycler_FilterCategoryItem.setAdapter(filterItemListAdapter);

        recycler_FilterCategory = parentView.findViewById(R.id.recycler_FilterCategory);
        layoutManager = new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false);
        recycler_FilterCategory.setLayoutManager(layoutManager);

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(mCtx, category);
        recycler_FilterCategory.setAdapter(categoryListAdapter);


        bottomSheerDialog.show();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (search_et.getText().toString().length() > 0) {

            cut_btn.setVisibility(View.VISIBLE);
            map_img.setVisibility(View.GONE);
            main_data_ll.setVisibility(View.GONE);
            empty_rewards_ll.setVisibility(View.VISIBLE);

        } else {

            cut_btn.setVisibility(View.GONE);
            map_img.setVisibility(View.VISIBLE);
            main_data_ll.setVisibility(View.VISIBLE);
            empty_rewards_ll.setVisibility(View.GONE);

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onItemClick(int position) {

        ((HomeActivity) getActivity()).replaceFragment(new OfferDetailFragment(), true,
                KeyClass.FRAGMENT_OFFER_DETAILS, KeyClass.FRAGMENT_OFFER_DETAILS);

    }

    private void adapterSetup() {

        image_logo = new ArrayList<>();
        image_logo.add(R.drawable.ic_nike);
        image_logo.add(R.drawable.ic_daiya);
        image_logo.add(R.drawable.ic_nike);


        offer_text = new ArrayList<>();
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");
        offer_text.add("Lorem Ipsum is simply dummy text of the printing.");


        expired_date = new ArrayList<>();
        expired_date.add("Feb 22, 2021");
        expired_date.add("Feb 22, 2021");
        expired_date.add("Feb 22, 2021");

        color = new ArrayList<>();
        color.add(R.drawable.white_rounded_corner_white_bg);
        color.add(R.drawable.white_rounded_corner_white_bg);
        color.add(R.drawable.white_rounded_corner_white_bg);


        adapter = new NewArrivalRecyclerAdapter(getActivity(), image_logo, offer_text, expired_date, color, this);
        new_arrival_recycler.setLayoutManager(new LinearLayoutManager(mCtx));
        new_arrival_recycler.setAdapter(adapter);


        recommeded_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recommeded_recycler.setAdapter(adapter);

        megaOfferRecyclerAdapter = new MegaOfferRecyclerAdapter(getActivity());
        mega_offer_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mega_offer_recycler.setAdapter(megaOfferRecyclerAdapter);
    }
}