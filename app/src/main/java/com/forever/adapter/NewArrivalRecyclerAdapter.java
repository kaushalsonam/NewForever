package com.forever.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.activities.OfferDetailsActivity;
import com.forever.fragments.Terms_PrivacyFragment;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;

public class NewArrivalRecyclerAdapter extends RecyclerView.Adapter<NewArrivalRecyclerAdapter.NewArrivalRecyclerViewHolder> {

    private Context context;

    public NewArrivalRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public NewArrivalRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.new_arrival_recycler_item, parent, false);
        return new NewArrivalRecyclerAdapter.NewArrivalRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewArrivalRecyclerViewHolder holder, int position) {
//        holder.rl_offer_details.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity(new Intent(context, OfferDetailsActivity.class));
//            }
//        });

        holder.terms_and_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((HomeActivity)context).replaceFragment(new Terms_PrivacyFragment(),true,
                        KeyClass.FRAGMENT_TERMS_AND_PRIVACY,KeyClass.FRAGMENT_TERMS_AND_PRIVACY);


            }
        });


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class NewArrivalRecyclerViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rl_offer_details;
        TextView terms_and_condition;

        public NewArrivalRecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            rl_offer_details = itemView.findViewById(R.id.rl_offer_details);
            terms_and_condition = itemView.findViewById(R.id.terms_and_condition);
        }
    }
}
