package com.beehyr.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beehyr.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class AreasRecyclerViewAdapter extends RecyclerView.Adapter<AreasRecyclerViewAdapter.AreasViewHolder> {

    private List<AreasGridItem> itemList;
    private Context context;

    public AreasRecyclerViewAdapter(List<AreasGridItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public AreasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.areas_grid_item, parent, false);
        return new AreasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AreasViewHolder holder, int position) {
        final AreasGridItem item = itemList.get(position);
        holder.iv.setBackgroundResource(item.getImage());
        holder.tv.setText(item.getType());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardView.toggle();
                item.setSelected(holder.cardView.isSelected());
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class AreasViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tv;
        private MaterialCardView cardView;

        AreasViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            cardView = itemView.findViewById(R.id.card);
        }
    }

}
