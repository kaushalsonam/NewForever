package com.forever.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forever.R;
import com.forever.activities.OfferDetailsActivity;

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
        holder.rl_offer_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, OfferDetailsActivity.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class NewArrivalRecyclerViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout rl_offer_details;

        public NewArrivalRecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            rl_offer_details = itemView.findViewById(R.id.rl_offer_details);
        }
    }
}
