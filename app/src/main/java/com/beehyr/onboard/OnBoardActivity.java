package com.beehyr.onboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.beehyr.R;
import com.theartofdev.edmodo.cropper.CropImage;

public class OnBoardActivity extends AppCompatActivity implements OTPFragment.Callback, EnterOTPFragment.Callback, ProfileFragment.Callback, WelcomeFragment.Callback {

    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        OTPFragment otpFragment = new OTPFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, otpFragment).commit();
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

        if (fragment instanceof OTPFragment) {

            OTPFragment otpFragment = (OTPFragment) fragment;
            otpFragment.setCallback(this);

        } else if (fragment instanceof EnterOTPFragment) {

            EnterOTPFragment enterOTPFragment = (EnterOTPFragment) fragment;
            enterOTPFragment.setCallback(this);

        } else if (fragment instanceof ProfileFragment) {

            ProfileFragment profileFragment = (ProfileFragment) fragment;
            profileFragment.setCallback(this);

        } else if (fragment instanceof WelcomeFragment) {
            WelcomeFragment welcomeFragment = (WelcomeFragment) fragment;
            welcomeFragment.setCallback(this);
        }
    }

    @Override
    public void onGetOtpClicked() {
        EnterOTPFragment enterOTPFragment = new EnterOTPFragment();
        replaceFragment(enterOTPFragment, "OTPFragment");
    }

    @Override
    public void onGoToProfileClicked() {
        profileFragment = new ProfileFragment();
        replaceFragment(profileFragment, "ProfileFragment");
    }

    @Override
    public void onGetOtpAgainClicked() {

    }

    private void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, tag).commit();
    }

    @Override
    public void onUploadImageClicked() {
        CropImage.activity()
                .setAspectRatio(1, 1)
                .start(this);
    }

    @Override
    public void onNextClicked() {
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        replaceFragment(welcomeFragment, "WelcomeFragment");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                profileFragment.setImage(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Log.e("OnBoardActivity", result.getError().getMessage(), result.getError());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSearchClicked() {
        SearchingFragment searchingFragment = new SearchingFragment();
        replaceFragment(searchingFragment, "SearchingFragment");
    }
}
