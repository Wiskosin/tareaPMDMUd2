package com.yinya.bellidoserranadrianapmdm02;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

/* BaseActivity is a base class for activities in the application.
 * It provides functionality to apply a specific language setting for the app context.
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * The name of the SharedPreferences file used to store application preferences.
     */
    protected static final String PREFS_NAME = "AppPreferences";

    /**
     * The key used to store and retrieve the language preference from SharedPreferences.
     */
    protected static final String KEY_LANGUAGE = "language";

    /**
     * Attaches a new base context to the activity with the specified language configuration.
     *
     * @param newBase the base context to attach.
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(applyLanguageContext(newBase));
    }

    /**
     * Applies the language configuration to the given context based on the saved preferences.
     *
     * @param context the context to modify with the desired language setting.
     * @return a new context with the applied language configuration.
     */
    private Context applyLanguageContext(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String language = preferences.getString(KEY_LANGUAGE, "en");

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        return context.createConfigurationContext(config);
    }
}