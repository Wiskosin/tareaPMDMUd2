package com.yinya.bellidoserranadrianapmdm02;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Custom application class for managing global application state.
 * This class handles saving and applying the application's language preferences.
 */
public class MyApp extends Application {

    protected static final String PREFS_NAME = "AppPreferences";
    protected static final String KEY_LANGUAGE = "language";

    /**
     * Called when the application is created.
     * Initializes the application by retrieving the saved language preference
     * and applying it globally.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        String savedLanguage = getSavedLanguage();
        applyLanguage(savedLanguage);
    }


    /**
     * Retrieves the saved language preference from SharedPreferences.
     * If no language is saved, it defaults to "en" (English).
     *
     * @return The saved language code (e.g., "en" for English, "es" for Spanish).
     */
    public String getSavedLanguage() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return preferences.getString(KEY_LANGUAGE, "en");
    }

    /**
     * Saves the specified language preference to SharedPreferences.
     *
     * @param language The language code to save (e.g., "en", "es").
     */
    public void saveLanguage(String language) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LANGUAGE, language);
        editor.apply();
    }

    /**
     * Applies the specified language to the application context.
     * This method updates the application's configuration to use the given language.
     *
     * @param language The language code to apply (e.g., "en", "es").
     */
    public void applyLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        Context context = getBaseContext().createConfigurationContext(config);
        getBaseContext().getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}
