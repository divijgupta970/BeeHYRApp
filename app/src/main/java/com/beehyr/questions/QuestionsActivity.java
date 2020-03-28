package com.beehyr.questions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.beehyr.R;
import com.beehyr.jobSearch.JobSearchActivity;
import com.theartofdev.edmodo.cropper.CropImage;

public class QuestionsActivity extends AppCompatActivity implements ResultFragment.Callback, FirstQuestionFragment.Callback, SecondFragmentQuestion.Callback{

    private SecondFragmentQuestion secondFragmentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        FirstQuestionFragment firstQuestionFragment = new FirstQuestionFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstQuestionFragment).commit();
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

        if (fragment instanceof ResultFragment) {
            ResultFragment resultFragment = (ResultFragment) fragment;
            resultFragment.setCallback(this);
        } else if (fragment instanceof FirstQuestionFragment) {
            FirstQuestionFragment firstQuestionFragment = (FirstQuestionFragment) fragment;
            firstQuestionFragment.setCallback(this);
        } else if (fragment instanceof SecondFragmentQuestion) {
            SecondFragmentQuestion secondFragmentQuestion = (SecondFragmentQuestion) fragment;
            secondFragmentQuestion.setCallback(this);
        }
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onSearchAgainClicked() {
        Intent intent = new Intent(this, JobSearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void onGoToSecondQuestion() {
        secondFragmentQuestion = new SecondFragmentQuestion();
        replaceFragment(secondFragmentQuestion);
    }

    @Override
    public void onGoToResult() {
        ResultFragment resultFragment = new ResultFragment();
        replaceFragment(resultFragment);
    }

    @Override
    public void onUploadImageClicked() {
        CropImage.activity()
                .setAspectRatio(16, 9)
                .start(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                secondFragmentQuestion.setImage(resultUri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
