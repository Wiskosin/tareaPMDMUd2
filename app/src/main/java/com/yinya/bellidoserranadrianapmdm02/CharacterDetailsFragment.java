package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        //TODO Pasar a string.xml
        Toast.makeText(requireContext(), "Se ha seleccionado el personaje "+characterDetails.getName(), Toast.LENGTH_SHORT).show();
        return binding.getRoot();

    }

    private CharacterData getCharacterDetails(){
        int image = getArguments().getInt("image");
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String skills = getArguments().getString("skills");
        return new CharacterData(image, name, description, skills);
    }

    private void bindCharacterDetails(CharacterData characterDetails){
        binding.tvCharacterDetailsName.setText(characterDetails.getName());
        binding.ivCharacterDetails.setImageResource(characterDetails.getImage());
        binding.tvCharacterDetailsDescription.setText(characterDetails.getDescription());
        binding.tvCharacterDetailsSkills.setText(characterDetails.getSkills());
    }
}