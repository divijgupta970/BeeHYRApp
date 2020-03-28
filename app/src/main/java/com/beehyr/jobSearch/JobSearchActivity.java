package com.beehyr.jobSearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.beehyr.R;
import com.beehyr.questions.QuestionsActivity;

public class JobSearchActivity extends AppCompatActivity implements JobResultsFragment.Callback, ApplyFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_search);

        JobResultsFragment jobResultsFragment = new JobResultsFragment();
        replaceFragment(jobResultsFragment);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private void replaceFragmentBackEnabled(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

        if (fragment instanceof JobResultsFragment) {
            JobResultsFragment jobResultsFragment = (JobResultsFragment) fragment;
            jobResultsFragment.setCallback(this);
        } else if(fragment instanceof ApplyFragment) {
            ApplyFragment applyFragment = (ApplyFragment) fragment;
            applyFragment.setCallback(this);
        }
    }

    @Override
    public void onApplyClicked(JobItem item) {
        ApplyFragment applyFragment = new ApplyFragment();
        replaceFragmentBackEnabled(applyFragment);
    }

    @Override
    public void onGoToQuestionsClicked() {
        startActivity(new Intent(this, QuestionsActivity.class));
    }
}
