package com.beehyr.questions;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragmentQuestion extends Fragment {

    private Callback callback;
    private ImageView ivCamera;


    public SecondFragmentQuestion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton btnNext = view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGoToResult();
            }
        });

        ivCamera = view.findViewById(R.id.ivCamera);
        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onUploadImageClicked();
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

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    interface Callback {
        void onGoToResult();
        void onUploadImageClicked();
    }

}
