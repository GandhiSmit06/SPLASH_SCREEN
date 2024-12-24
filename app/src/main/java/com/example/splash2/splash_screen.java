package com.example.splash2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize views
        ImageView logo = findViewById(R.id.logo);
        TextView appName = findViewById(R.id.app_name);
        TextView tagline = findViewById(R.id.tagline);

        // Load animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);

        // Start animations
        logo.startAnimation(zoomIn);
        appName.startAnimation(fadeIn);
        tagline.startAnimation(fadeIn);

        // Delay for splash screen and navigate to main activity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // 3 seconds delay
    }
}
