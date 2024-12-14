package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.yinya.bellidoserranadrianapmdm02.databinding.FragmentCharactersListBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass that displays a list of characters using a RecyclerView.
 * This fragment initializes and populates a list of characters and allows the user to interact
 * with the data through a scrollable view.
 */
public class CharactersListFragment extends Fragment {

    private FragmentCharactersListBinding binding;
    private RecyclerView charactersRv;

    /**
     * Called when the fragment is created.
     * Use this method to initialize components that do not require the fragment's view.
     *
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved state data.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Called to create and return the view hierarchy associated with the fragment.
     * This method inflates the layout, initializes the RecyclerView, sets up its adapter,
     * and binds the data.
     *
     * @param inflater           A {@link LayoutInflater} to inflate the fragment's layout.
     * @param container          The parent view that this fragment's UI should be attached to.
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved state data.
     * @return The root view of the fragment's layout.
     */
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
        return view;
    }

    /**
     * Called after the fragment's view has been created.
     * Displays a welcome message to the user using a Snackbar.
     *
     * @param view               The root view of the fragment.
     * @param savedInstanceState If the fragment is being recreated, this Bundle contains
     *                           previously saved state data.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Snackbar.make(view, getSnackBarMessage(), Snackbar.LENGTH_LONG).show();
    }

    /**
     * Initializes and populates the list of characters to be displayed in the RecyclerView.
     * This method retrieves character data from resources and validates that all arrays have
     * the same length. If the lengths differ, an {@link IllegalStateException} is thrown.
     *
     * @return An {@link ArrayList} of {@link CharacterData} objects containing character details.
     * @throws IllegalStateException If the lengths of the character data arrays do not match.
     */
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

    /**
     * Initializes the adapter for the RecyclerView with the provided character list.
     *
     * @param charactersList An {@link ArrayList} of {@link CharacterData} objects to be displayed.
     * @return A configured {@link CharactersListAdapter} for the RecyclerView.
     */
    @NonNull
    private CharactersListAdapter initializeAdapter(ArrayList<CharacterData> charactersList) {
        CharactersListAdapter adapter = new CharactersListAdapter(charactersList, requireContext());
        return adapter;
    }

    /**
     * Retrieves the message to be displayed in a Snackbar when the fragment is created.
     *
     * @return A string containing the welcome message for the user.
     */
    private String getSnackBarMessage() {
        return requireContext().getString(R.string.main_snackbar_welcome_message);
    }

    /**
     * Called when the fragment's view is destroyed.
     * Cleans up binding references to avoid memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}