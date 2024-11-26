package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setInsets();
        setDefaultActionBar();
        setNavController();

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

    private void setDefaultActionBar() {
        MaterialToolbar toolbar = findViewById(R.id.main_appbar);
        setSupportActionBar(toolbar);
    }

    private void setNavController() {
        try {
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.nav_host_fragment);

            if (navHostFragment != null) {
                navController = navHostFragment.getNavController();
                AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
                NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            } else {
                Log.e(TAG, "NavHostFragment not found.");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error configuring NavController: " + e.getMessage());
        }
    }

    public void showCharacterDetail(CharacterData characterData, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("image", characterData.getImage());
        bundle.putString("name", characterData.getName());
        bundle.putString("description", characterData.getDescription());
        bundle.putString("skills", characterData.getSkills());

        Navigation.findNavController(view).navigate(R.id.characterDetailsFragment, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}