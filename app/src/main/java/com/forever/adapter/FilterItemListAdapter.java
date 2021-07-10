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

import java.util.List;

public class FilterItemListAdapter extends RecyclerView.Adapter<FilterItemListAdapter.FilterItemViewHolder> {
    private Context mCtx;
    private List<String> item;

    public FilterItemListAdapter(Context mCtx, List<String> item) {
        this.mCtx = mCtx;
        this.item = item;

    }

    @NotNull
    @Override
    public FilterItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_filter_item_layout,parent,false);
        FilterItemViewHolder filterItemViewHolder = new FilterItemViewHolder(view);
        return filterItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilterItemViewHolder holder, int position) {
        holder.filter_item.setText(item.get(position));

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class FilterItemViewHolder extends RecyclerView.ViewHolder {
        private TextView filter_item;
        public FilterItemViewHolder(@NonNull View itemView) {
            super(itemView);
            filter_item = itemView.findViewById(R.id.filter_item);
        }
    }
}
