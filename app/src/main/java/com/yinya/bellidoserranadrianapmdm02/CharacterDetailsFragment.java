package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.yinya.bellidoserranadrianapmdm02.databinding.FragmentCharacterDetailsBinding;

/**
 * Fragment that displays the details of a character.
 */
public class CharacterDetailsFragment extends Fragment {

    private FragmentCharacterDetailsBinding binding;

    /**
     * Called when the fragment is created.
     * Use this method to initialize components that do not depend on the fragment's view.
     *
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved data.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Called to inflate the fragment's view and bind the character data.
     *
     * @param inflater           A {@link LayoutInflater} object to inflate the view.
     * @param container          The container where the fragment's view will be added.
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved data.
     * @return The root of the inflated view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false);
        CharacterData characterDetails = getCharacterDetails();
        bindCharacterDetails(characterDetails);
        String message = getToastMessage(characterDetails.getName());
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
        return binding.getRoot();
    }

    /**
     * Generates a Toast message formatted with the character's name.
     * This method retrieves a string resource from `strings.xml`, which includes a placeholder
     * for a variable. The provided name is inserted into the placeholder.
     *
     * @param name The character's name to include in the message.
     * @return A formatted string containing the character's name.
     */
    private String getToastMessage(String name) {
        return requireContext().getString(R.string.character_detail_toast, name);
    }

    /**
     * Retrieves the character details from the fragment's arguments.
     *
     * @return A {@link CharacterData} object containing the character's details.
     */
    private CharacterData getCharacterDetails() {
        int image = getArguments().getInt("image");
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String skills = getArguments().getString("skills");
        return new CharacterData(image, name, description, skills);
    }

    /**
     * Binds the character details to the UI elements.
     *
     * @param characterDetails A {@link CharacterData} object containing the character's details.
     */
    private void bindCharacterDetails(CharacterData characterDetails) {
        binding.tvCharacterDetailsName.setText(characterDetails.getName());
        binding.ivCharacterDetails.setImageResource(characterDetails.getImage());
        binding.tvCharacterDetailsDescription.setText(characterDetails.getDescription());
        binding.tvCharacterDetailsSkills.setText(characterDetails.getSkills());
    }
}