package com.yinya.bellidoserranadrianapmdm02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Splash screen activity that is displayed when the app starts.
 * It shows a splash screen for a defined duration before transitioning to the main activity.
 */
public class SplashActivity extends AppCompatActivity {

    // Defines the duration of the splash screen in milliseconds
    private static final int SPLASH_DURATION = 3000; // 3 seconds

    /**
     * Called when the activity is created.
     * Sets up the splash screen layout, handles the safe area insets, and initiates the transition
     * to the main activity after a delay.
     *
     * @param savedInstanceState If the activity is being recreated, this Bundle contains
     *                           previously saved data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        setInsets();
        // Uses a Handler to post a delayed action for transitioning to the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Starts the main activity after the splash screen duration
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }

    /**
     * Sets the safe area insets (padding) for the splash screen view.
     * Ensures that the content does not overlap with system bars like the status bar and navigation bar.
     */
    private void setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}