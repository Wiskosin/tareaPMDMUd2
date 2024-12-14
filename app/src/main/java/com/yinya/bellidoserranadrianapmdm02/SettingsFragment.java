package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.materialswitch.MaterialSwitch;
import com.yinya.bellidoserranadrianapmdm02.databinding.FragmentSettingsBinding;

/**
 * A {@link Fragment} subclass that represents the settings screen.
 * This fragment allows users to toggle the app's language setting between English and Spanish.
 */
public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private MaterialSwitch switchLanguage;

    /**
     * Called when the fragment is created.
     * This method is typically used for initializing components that do not rely on the view.
     *
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved data.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Called to create and return the view hierarchy associated with the fragment.
     * This method initializes the language switch and sets its behavior.
     *
     * @param inflater           A {@link LayoutInflater} to inflate the fragment's layout.
     * @param container          The parent view that this fragment's UI should be attached to.
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved data.
     * @return The root view of the fragment's layout.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using ViewBinding
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        // Initialize the language switch and set its initial state based on saved preferences
        switchLanguage = binding.settingsLanguageSwitch;
        MyApp app = (MyApp) requireActivity().getApplication();
        switchLanguage.setChecked(app.getSavedLanguage().equals("es"));
        // Set a listener to handle language changes when the switch is toggled
        switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String selectedLanguage = isChecked ? "es" : "en";
            app.saveLanguage(selectedLanguage);
            app.applyLanguage(selectedLanguage);
            requireActivity().recreate();
        });

        return view;
    }
}