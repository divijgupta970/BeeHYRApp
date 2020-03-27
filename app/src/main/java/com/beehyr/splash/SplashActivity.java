package com.beehyr.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.beehyr.MainActivity;
import com.beehyr.R;
import com.beehyr.onboard.OnBoardActivity;
import com.beehyr.util.StringConstants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ConstraintLayout layout = findViewById(R.id.layout);
        ImageView ivLogo = findViewById(R.id.ivLogo);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                onAnimationEndFunction();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        layout.animate()
                .setDuration(StringConstants.ANIM_DURATION)
                .alpha(1)
                .start();

        ivLogo.startAnimation(anim);

    }

    private void onAnimationEndFunction() {
        startActivity(new Intent(this, OnBoardActivity.class));
        finish();
    }
}
