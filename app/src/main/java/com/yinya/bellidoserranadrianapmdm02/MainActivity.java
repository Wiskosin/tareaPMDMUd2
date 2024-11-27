package com.yinya.bellidoserranadrianapmdm02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_me) { // Action when "About Me" item is selected
            new MaterialAlertDialogBuilder(this)
                    .setTitle(getResources().getString(R.string.context_menu_about_me))
                    .setMessage(getResources().getString(R.string.context_menu_alert_dialog_text))
                    .setNeutralButton(R.string.context_menu_neutral_button, (dialog, which) -> dialog.dismiss())
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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