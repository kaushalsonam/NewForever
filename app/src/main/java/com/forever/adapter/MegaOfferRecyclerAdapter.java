package com.forever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.fragments.reward.OfferDetailFragment;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;

public class MegaOfferRecyclerAdapter extends RecyclerView.Adapter<MegaOfferRecyclerAdapter.MegaOfferRecyclerViewHolder> {

    private Context context;

    public MegaOfferRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MegaOfferRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mega_offer_recycler_item, parent, false);
        return new MegaOfferRecyclerAdapter.MegaOfferRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MegaOfferRecyclerViewHolder holder, int position) {

        holder.next_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((HomeActivity)context).replaceFragment(new OfferDetailFragment(),true,
                        KeyClass.FRAGMENT_OFFER_DETAILS,KeyClass.FRAGMENT_OFFER_DETAILS);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MegaOfferRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView next_arrow;

        public MegaOfferRecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            next_arrow=itemView.findViewById(R.id.next_arrow);
        }
    }
}
