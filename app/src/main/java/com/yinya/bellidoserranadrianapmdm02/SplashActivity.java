package com.yinya.bellidoserranadrianapmdm02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    // Establece la duración de la pantalla de presentación en milisegundos
    private static final int SPLASH_DURATION = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        setInsets();
        // Usa un Handler para publicar una acción retrasada para la transición a la actividad principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Inicia la actividad principal después de la duración de la pantalla de presentación
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }

    /**
     * Function to set the safe areas insets (padding).
     */
    private void setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}