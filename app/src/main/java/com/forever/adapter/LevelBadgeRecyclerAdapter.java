package com.forever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forever.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LevelBadgeRecyclerAdapter extends RecyclerView.Adapter<LevelBadgeRecyclerAdapter.LevelBadgeRecyclerViewHolder> {


    private Context context;
    private List<Integer> badgeImages;
    private List<String> badgeName;


    public LevelBadgeRecyclerAdapter(Context context, List<Integer> badgeImages, List<String> badgeName) {
        this.context = context;
        this.badgeImages = badgeImages;
        this.badgeName = badgeName;
    }

    @NonNull
    @NotNull
    @Override
    public LevelBadgeRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.level_badge_recycler_item, parent, false);
        return new LevelBadgeRecyclerAdapter.LevelBadgeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LevelBadgeRecyclerViewHolder holder, int position) {

        Glide.with(context).load(badgeImages.get(position)).into(holder.ic_level_badge);
        holder.txt_level_badge.setText(badgeName.get(position));

    }

    @Override
    public int getItemCount() {
        return badgeImages.size();
    }

    public class LevelBadgeRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView ic_level_badge;
        TextView txt_level_badge;

        public LevelBadgeRecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            ic_level_badge=itemView.findViewById(R.id.ic_level_badge);
            txt_level_badge=itemView.findViewById(R.id.txt_level_badge);
        }
    }

}
