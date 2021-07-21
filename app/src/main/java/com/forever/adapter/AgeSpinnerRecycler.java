package com.forever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forever.R;

import org.jetbrains.annotations.NotNull;

public class AgeSpinnerRecycler extends RecyclerView.Adapter<AgeSpinnerRecycler.AgeSpinneViewHolder> {

    private Context context;
    private int age=10;


    public AgeSpinnerRecycler(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public AgeSpinneViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.age_spinner_recycler_item, parent, false);
        return new AgeSpinnerRecycler.AgeSpinneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AgeSpinneViewHolder holder, int position) {

        holder.txt_age.setText(String.valueOf(age++));




    }

    @Override
    public int getItemCount() {
        return age;
    }

    public class AgeSpinneViewHolder extends RecyclerView.ViewHolder {

        TextView txt_age;

        public AgeSpinneViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txt_age=itemView.findViewById(R.id.txt_age);


        }
    }
}
