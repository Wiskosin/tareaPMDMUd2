package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.yinya.bellidoserranadrianapmdm02.databinding.FragmentCharacterDetailsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterDetailsFragment extends Fragment {

    private FragmentCharacterDetailsBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
     * Generates a formatted toast message using the provided name.
     * <p>
     * This method retrieves a string resource from the `strings.xml` file that contains a placeholder
     * for a variable. The provided `name` parameter is used to replace the placeholder, resulting
     * in a dynamically formatted message.
     *
     * @param name the value to replace the placeholder in the string resource.
     * @return a formatted string with the `name` inserted in the appropriate position.
     */
    private String getToastMessage(String name) {
        return requireContext().getString(R.string.character_detail_toast, name);
    }

    private CharacterData getCharacterDetails() {
        int image = getArguments().getInt("image");
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String skills = getArguments().getString("skills");
        return new CharacterData(image, name, description, skills);
    }

    private void bindCharacterDetails(CharacterData characterDetails) {
        binding.tvCharacterDetailsName.setText(characterDetails.getName());
        binding.ivCharacterDetails.setImageResource(characterDetails.getImage());
        binding.tvCharacterDetailsDescription.setText(characterDetails.getDescription());
        binding.tvCharacterDetailsSkills.setText(characterDetails.getSkills());
    }
}