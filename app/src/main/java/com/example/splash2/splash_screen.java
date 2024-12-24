package com.example.splash2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize logo
        ImageView logoImage = findViewById(R.id.logoImage);

        // Load animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        Animation scaleOut = AnimationUtils.loadAnimation(this, R.anim.scale_out);

        // Start with fade-in
        logoImage.startAnimation(fadeIn);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Start bounce animation after fade-in
                logoImage.startAnimation(bounce);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        bounce.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Start scale-out animation after bounce
                logoImage.startAnimation(scaleOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        // Move to the next activity after the animations
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // Total duration: 3 seconds
    }
}
