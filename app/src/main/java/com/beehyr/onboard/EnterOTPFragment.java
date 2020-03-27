package com.beehyr.onboard;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beehyr.R;
import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterOTPFragment extends Fragment {

    private Callback callback = null;


    public EnterOTPFragment() {
        // Required empty public constructor
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_otp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton btnGoToProfile = view.findViewById(R.id.btnOtp);
        btnGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGoToProfileClicked();
            }
        });

        MaterialButton btnOtpAgain = view.findViewById(R.id.btnOtpAgain);
        btnOtpAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGetOtpAgainClicked();
            }
        });


    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    interface Callback {
        void onGoToProfileClicked();

        void onGetOtpAgainClicked();
    }

}
