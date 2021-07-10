package com.forever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forever.R;
import com.forever.activities.HomeActivity;
import com.forever.fragments.Terms_PrivacyFragment;
import com.forever.utilities.AdapterItemClick;
import com.forever.utilities.KeyClass;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewArrivalRecyclerAdapter extends RecyclerView.Adapter<NewArrivalRecyclerAdapter.NewArrivalRecyclerViewHolder> {

    private Context context;
    private List<Integer> image_logo;
    private List<String> offer_text;
    private List<String> expired_date;
    private List<Integer> color;
    private AdapterItemClick itemClick;

    public NewArrivalRecyclerAdapter(Context context, List<Integer> image_logo, List<String> offer_text, List<String> expired_date, List<Integer> color, AdapterItemClick itemClick) {
        this.context = context;
        this.image_logo = image_logo;
        this.offer_text = offer_text;
        this.expired_date = expired_date;
        this.color = color;
        this.itemClick = itemClick;
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

        holder.terms_and_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((HomeActivity)context).replaceFragment(new Terms_PrivacyFragment(),true,
                        KeyClass.FRAGMENT_TERMS_AND_PRIVACY,KeyClass.FRAGMENT_TERMS_AND_PRIVACY);


            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemClick.onItemClick(position);
            }
        });

        Glide.with(context).load(image_logo.get(position)).into(holder.logo_image);
        holder.txt_offer.setText(offer_text.get(position));
        holder.txt_date.setText(expired_date.get(position));
        holder.bg_color_rl.setBackground(context.getResources().getDrawable(color.get(position)));

    }

    @Override
    public int getItemCount() {
        return image_logo.size();
    }

    public class NewArrivalRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView terms_and_condition,txt_offer,txt_date;
        CircleImageView logo_image;
        RelativeLayout bg_color_rl;

        public NewArrivalRecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            terms_and_condition = itemView.findViewById(R.id.terms_and_condition);
            logo_image = itemView.findViewById(R.id.logo_image);
            txt_offer = itemView.findViewById(R.id.txt_offer);
            txt_date = itemView.findViewById(R.id.txt_date);
            bg_color_rl = itemView.findViewById(R.id.bg_color_rl);
        }
    }
}
