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
public class OTPFragment extends Fragment {

    private Callback callback = null;

    public OTPFragment() {
    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton btnOtp = view.findViewById(R.id.btnOtp);
        btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGetOtpClicked();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    interface Callback {

        void onGetOtpClicked();
    }

}
