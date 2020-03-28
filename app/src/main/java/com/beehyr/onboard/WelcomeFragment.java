package com.beehyr.onboard;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beehyr.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private Callback callback;
    private RecyclerView rvAreas;
    private AreasRecyclerViewAdapter adapter = null;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvAreas = view.findViewById(R.id.rvAreas);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        rvAreas.setLayoutManager(manager);


        MaterialButton btnSearch = view.findViewById(R.id.btnSearchJobs);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onSearchClicked();
            }
        });

        setAdapter();

    }

    private void setAdapter() {
        ArrayList<AreasGridItem> list = new ArrayList<>();
        list.add(new AreasGridItem(getResources().getString(R.string.driver), R.drawable.driver));
        list.add(new AreasGridItem(getResources().getString(R.string.delivery), R.drawable.delivery));
        list.add(new AreasGridItem(getResources().getString(R.string.plumber), R.drawable.plumber));
        list.add(new AreasGridItem(getResources().getString(R.string.driver), R.drawable.driver));
        list.add(new AreasGridItem(getResources().getString(R.string.delivery), R.drawable.delivery));
        list.add(new AreasGridItem(getResources().getString(R.string.plumber), R.drawable.plumber));
        list.add(new AreasGridItem(getResources().getString(R.string.driver), R.drawable.driver));
        list.add(new AreasGridItem(getResources().getString(R.string.delivery), R.drawable.delivery));
        list.add(new AreasGridItem(getResources().getString(R.string.plumber), R.drawable.plumber));
        list.add(new AreasGridItem(getResources().getString(R.string.driver), R.drawable.driver));
        list.add(new AreasGridItem(getResources().getString(R.string.delivery), R.drawable.delivery));
        list.add(new AreasGridItem(getResources().getString(R.string.plumber), R.drawable.plumber));
        list.add(new AreasGridItem(getResources().getString(R.string.driver), R.drawable.driver));
        list.add(new AreasGridItem(getResources().getString(R.string.delivery), R.drawable.delivery));
        list.add(new AreasGridItem(getResources().getString(R.string.plumber), R.drawable.plumber));

        adapter = new AreasRecyclerViewAdapter(list, getContext());
        rvAreas.setAdapter(adapter);

    }

    interface Callback {
        void onSearchClicked();
    }

}
