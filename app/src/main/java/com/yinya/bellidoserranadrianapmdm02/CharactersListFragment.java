package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.yinya.bellidoserranadrianapmdm02.databinding.FragmentCharactersListBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharactersListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersListFragment extends Fragment {

    private FragmentCharactersListBinding binding;
    private RecyclerView charactersRv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCharactersListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        charactersRv = binding.rvCharactersList;
        ArrayList<CharacterData> charactersList = initializeCharactersList();
        CharactersListAdapter adapter = initializeAdapter(charactersList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        charactersRv.setLayoutManager(layoutManager);
        charactersRv.setAdapter(adapter);
        Snackbar.make(requireActivity().findViewById(R.id.main), getSnackBarMessage(), Snackbar.LENGTH_LONG).show();
        return view;
    }

    private ArrayList<CharacterData> initializeCharactersList() {
        ArrayList<CharacterData> charactersList = new ArrayList<>();

        int[] imageIds = {
                R.drawable.character_1, R.drawable.character_2, R.drawable.character_3,
                R.drawable.character_4, R.drawable.character_5, R.drawable.character_6,
                R.drawable.character_7, R.drawable.character_8, R.drawable.character_9,
                R.drawable.character_10, R.drawable.character_11, R.drawable.character_12,
                R.drawable.character_13, R.drawable.character_14, R.drawable.character_15,
                R.drawable.character_16, R.drawable.character_17, R.drawable.character_18,
                R.drawable.character_19, R.drawable.character_20, R.drawable.character_21,
                R.drawable.character_22, R.drawable.character_23, R.drawable.character_24};

        String[] characterNames = getResources().getStringArray(R.array.character_names);
        String[] characterDescriptions = getResources().getStringArray(R.array.character_descriptions);
        String[] characterSkills = getResources().getStringArray(R.array.character_skills);

        if (imageIds.length != characterNames.length ||
                characterDescriptions.length != characterNames.length ||
                characterSkills.length != characterNames.length) {
            throw new IllegalStateException("Different data length");
        }

        for (int i = 0; i < imageIds.length; i++) {
            charactersList.add(new CharacterData(imageIds[i], characterNames[i], characterDescriptions[i], characterSkills[i]));
        }
        return charactersList;
    }

    @NonNull
    private CharactersListAdapter initializeAdapter(ArrayList<CharacterData> charactersList) {
        CharactersListAdapter adapter = new CharactersListAdapter(charactersList, requireContext());
        return adapter;
    }

    private String getSnackBarMessage() {
        return requireContext().getString(R.string.main_snackbar_welcome_message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}