package com.beehyr.jobSearch;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beehyr.R;
import com.skydoves.expandablelayout.ExpandableLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyFragment extends Fragment {

    private boolean isExpanded = false;


    public ApplyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apply, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ExpandableLayout expandableLayout1 = view.findViewById(R.id.expandableLayout1);
        expandableLayout1.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    expandableLayout1.collapse();
                    isExpanded = false;
                } else {
                    expandableLayout1.expand();
                    isExpanded = true;
                }
            }
        });

        final ExpandableLayout expandableLayout2 = view.findViewById(R.id.expandableLayout2);
        expandableLayout2.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    expandableLayout2.collapse();
                    isExpanded = false;
                } else {
                    expandableLayout2.expand();
                    isExpanded = true;
                }
            }
        });
    }
}
