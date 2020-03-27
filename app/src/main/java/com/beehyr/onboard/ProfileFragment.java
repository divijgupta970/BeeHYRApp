package com.beehyr.onboard;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beehyr.R;
import com.google.android.material.button.MaterialButton;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private Callback callback = null;
    private ImageView ivCamera;

    public ProfileFragment() {
        // Required empty public constructor
    }

    void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivCamera = view.findViewById(R.id.ivClickPhoto);
        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onUploadImageClicked();
            }
        });

        MaterialButton btnNext = view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onNextClicked();
            }
        });
    }

    void setImage(Uri imagePath) {

        ivCamera.setImageURI(imagePath);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    interface Callback {
        void onUploadImageClicked();

        void onNextClicked();
    }

}
