package com.yinya.bellidoserranadrianapmdm02;

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

/**
 * Main activity class that serves as the entry point for the app.
 * This activity manages the navigation, app bar configuration, and UI interactions.
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private NavController navController;

    /**
     * Called when the activity is created.
     * Initializes the activity's layout, sets the insets for safe areas,
     * sets the action bar, and configures the navigation controller.
     *
     * @param savedInstanceState If the activity is being recreated, this Bundle contains
     *                           previously saved data.
     */
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
     * Sets the insets for the safe areas, applying padding to the view based on the system bars.
     */
    private void setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Sets the default action bar using the material toolbar.
     */
    private void setDefaultActionBar() {
        MaterialToolbar toolbar = findViewById(R.id.main_appbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Inflates the options menu from the specified XML file.
     *
     * @param menu The options menu in which items are placed.
     * @return true if the menu was successfully inflated; false otherwise.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    /**
     * Handles item selections from the options menu.
     *
     * @param item The menu item that was selected.
     * @return true if the item was handled; false otherwise.
     */
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

    /**
     * Sets up the navigation controller for the app, configuring the action bar to interact
     * with the navigation graph.
     */
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


    /**
     * Navigates to the character details fragment, passing the character data as arguments.
     *
     * @param characterData The character's data to display in the details fragment.
     * @param view          The view that was clicked to trigger the navigation.
     */
    public void showCharacterDetail(CharacterData characterData, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("image", characterData.getImage());
        bundle.putString("name", characterData.getName());
        bundle.putString("description", characterData.getDescription());
        bundle.putString("skills", characterData.getSkills());

        Navigation.findNavController(view).navigate(R.id.characterDetailsFragment, bundle);
    }

    /**
     * Called when the user presses the up button in the action bar.
     * Navigates up in the navigation stack.
     *
     * @return true if navigation is handled; false otherwise.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}