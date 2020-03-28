package com.beehyr.jobSearch;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beehyr.R;
import com.beehyr.onboard.WelcomeFragment;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobResultsFragment extends Fragment implements JobsRecyclerAdapter.ApplyListener{

    private Callback callback = null;
    private RecyclerView rvJobs;


    public JobResultsFragment() {
        // Required empty public constructor
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvJobs = view.findViewById(R.id.rvJobs);
        rvJobs.setLayoutManager(new LinearLayoutManager(getContext()));

        setUpAdapter();
    }

    private void setUpAdapter() {
        ArrayList<JobItem> items = new ArrayList<>();
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        items.add(new JobItem(R.drawable.zomato, getResources().getString(R.string.delivery_executive), "15000 - 30000", "लखनऊ"));
        JobsRecyclerAdapter adapter = new JobsRecyclerAdapter(items, getContext(), this);
        rvJobs.setAdapter(adapter);
    }

    @Override
    public void onApplyClicked(JobItem item) {
        callback.onApplyClicked(item);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    interface Callback {
        void onApplyClicked(JobItem item);
    }
}
