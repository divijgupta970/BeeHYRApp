package com.beehyr.jobSearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beehyr.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class JobsRecyclerAdapter extends RecyclerView.Adapter<JobsRecyclerAdapter.JobsViewHolder> {

    private List<JobItem> jobItems;
    private Context context;
    private ApplyListener listener;

    public JobsRecyclerAdapter(List<JobItem> jobItems, Context context, ApplyListener listener) {
        this.jobItems = jobItems;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_jobs, parent, false);
        return new JobsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, int position) {
        final JobItem item = jobItems.get(position);
        holder.ivIcon.setBackgroundResource(item.getJobIcon());
        holder.tvJobType.setText(item.getJobType());
        holder.tvSalary.setText(item.getSalary());
        holder.tvLocation.setText(item.getLocation());
        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onApplyClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobItems.size();
    }

    class JobsViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivIcon;
        private TextView tvJobType, tvSalary, tvLocation;
        private MaterialButton btnApply;

        public JobsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvJobType = itemView.findViewById(R.id.tvJob);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            btnApply = itemView.findViewById(R.id.btnApply);
        }
    }

    interface ApplyListener {
        void onApplyClicked(JobItem item);
    }
}
