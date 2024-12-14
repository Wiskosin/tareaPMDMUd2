package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.yinya.bellidoserranadrianapmdm02.databinding.ActivityMainBinding;

/**
 * Main activity class that serves as the entry point for the app.
 * This activity manages the navigation, app bar configuration, and UI interactions,
 * including a navigation drawer and an action bar with options.
 */
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private NavController navController;
    private ActivityMainBinding binding;
    private AppBarConfiguration appBarDrawerConfiguration;

    /**
     * Called when the activity is created.
     * This method sets up the UI components, enables edge-to-edge insets, initializes the
     * navigation controller, and configures the navigation drawer and action bar.
     *
     * @param savedInstanceState If the activity is being recreated, this Bundle contains
     *                           previously saved data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        setInsets();
        setDefaultActionBar();
        setNavController();
        setNavigationDrawer();
    }

    /**
     * Sets the insets for the safe areas, ensuring proper padding for views based on system bars
     * such as the status bar, navigation bar, and cutouts.
     */
    private void setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.includeMainContent.mainCoordinator, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Set insets to the toolbar for the main view (CoordinatorLayout)
            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    0
            );
            binding.navDrawer.setPadding(systemBars.left,
                    0,
                    systemBars.right,
                    systemBars.bottom);
            return insets;
        });
    }

    /**
     * Configures the navigation drawer, linking it to the navigation controller.
     * This method also sets up the app bar configuration to manage navigation hierarchy.
     */
    private void setNavigationDrawer() {
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navDrawer = binding.navDrawer;
        appBarDrawerConfiguration = new AppBarConfiguration.Builder(
                R.id.characters_list_fragment, R.id.settings_fragment)
                .setOpenableLayout(drawer)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarDrawerConfiguration);
        NavigationUI.setupWithNavController(navDrawer, navController);
    }

    /**
     * Sets the default action bar using a MaterialToolbar.
     * Configures the AppBarLayout to disable lift-on-scroll behavior.
     */
    private void setDefaultActionBar() {
        MaterialToolbar toolbar = findViewById(R.id.main_appbar);
        setSupportActionBar(toolbar);
        AppBarLayout appBarLayout = findViewById(R.id.main_appbar_layout);
        appBarLayout.setLiftOnScroll(false);
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
     * Displays an alert dialog when the "About Me" menu item is selected.
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
     * Sets up the navigation controller for the app, linking it to the navigation host fragment
     * and configuring the action bar to work with the navigation graph.
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
     * The data includes the character's image, name, description, and skills.
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

        Navigation.findNavController(view).navigate(R.id.character_details_fragment, bundle);
    }

    /**
     * Called when the user presses the up button in the action bar.
     * Navigates up in the navigation stack or delegates to the parent implementation if
     * navigation is not handled.
     *
     * @return true if navigation is handled; false otherwise.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarDrawerConfiguration) || super.onSupportNavigateUp();
    }
}