package com.forever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forever.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {
    private Context mCtx;
    private List<String> category;

    public CategoryListAdapter(Context mCtx, List<String> category) {
        this.category = category;
        this.mCtx = mCtx;
    }

    @NotNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_filter_category_layout,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryViewHolder holder, int position) {


        holder.filter_category.setText(category.get(position));

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
         TextView filter_category;
         RelativeLayout filter_rl;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            filter_category = itemView.findViewById(R.id.filter_category);
            filter_rl = itemView.findViewById(R.id.filter_rl);

            filter_category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}
