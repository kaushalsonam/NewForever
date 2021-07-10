package com.forever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forever.R;
import com.forever.utilities.AdapterItemClick;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.NotificationRecyclerViewHolder> {

    private Context context;
    private List<Integer> logiImage;
    private List<String> notificationType;
    private List<String> notificationHeading;
    private List<String> notificationOffer;
    private List<String> time;
    private AdapterItemClick itemClick;

    public NotificationRecyclerAdapter(Context context, List<Integer> logiImage, List<String> notificationType, List<String> notificationHeading, List<String> notificationOffer, List<String> time, AdapterItemClick itemClick) {
        this.context = context;
        this.logiImage = logiImage;
        this.notificationType = notificationType;
        this.notificationHeading = notificationHeading;
        this.notificationOffer = notificationOffer;
        this.time = time;
        this.itemClick = itemClick;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.notification_recycler_item, parent, false);
        return new NotificationRecyclerAdapter.NotificationRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationRecyclerViewHolder holder, int position) {

        Glide.with(context).load(logiImage.get(position)).into(holder.logo_img);
        holder.notification_heading.setText(notificationHeading.get(position));
        holder.notification_offer_txt.setText(notificationOffer.get(position));
        holder.txt_type_of_notification.setText(notificationType.get(position));
        holder.used_time_txt.setText(time.get(position));


    }

    @Override
    public int getItemCount() {
        return logiImage.size();
    }

    public class NotificationRecyclerViewHolder extends RecyclerView.ViewHolder {

        CircleImageView logo_img;
        TextView txt_type_of_notification,used_time_txt,notification_heading,notification_offer_txt;

        public NotificationRecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);


            logo_img=itemView.findViewById(R.id.logo_img);
            txt_type_of_notification=itemView.findViewById(R.id.txt_type_of_notification);
            used_time_txt=itemView.findViewById(R.id.used_time_txt);
            notification_heading=itemView.findViewById(R.id.notification_heading);
            notification_offer_txt=itemView.findViewById(R.id.notification_offer_txt);


        }
    }
}
