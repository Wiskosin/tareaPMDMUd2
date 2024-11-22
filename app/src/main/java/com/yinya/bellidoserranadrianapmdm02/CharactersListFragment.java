package com.yinya.bellidoserranadrianapmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    public CharactersListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCharactersListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        charactersRv = binding.rvCharactersList;
        ArrayList<CharacterCardData> charactersList = initializeCharactersList();
        CharactersListAdapter adapter = initializeAdapter(charactersList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        charactersRv.setLayoutManager(layoutManager);
        charactersRv.setAdapter(adapter);
        return view;
    }

    private ArrayList<CharacterCardData> initializeCharactersList() {
        ArrayList<CharacterCardData> charactersList = new ArrayList();

        int[] imageIds = {
                R.drawable.character_1, R.drawable.character_2, R.drawable.character_3,
                R.drawable.character_4, R.drawable.character_5, R.drawable.character_6,
                R.drawable.character_7, R.drawable.character_8, R.drawable.character_9,
                R.drawable.character_10, R.drawable.character_11, R.drawable.character_12,
                R.drawable.character_13, R.drawable.character_14, R.drawable.character_15,
                R.drawable.character_16, R.drawable.character_17, R.drawable.character_18,
                R.drawable.character_19, R.drawable.character_20, R.drawable.character_21,
                R.drawable.character_22, R.drawable.character_23, R.drawable.character_24
        };
        String[] characterNames = getResources().getStringArray(R.array.character_names);

        if (imageIds.length != characterNames.length) {
            throw new IllegalStateException("El número de imágenes y nombres no coincide.");
        }

        for (int i = 0; i < imageIds.length; i++) {
            charactersList.add(new CharacterCardData(imageIds[i], characterNames[i]));
        }

        return charactersList;
    }

    private CharactersListAdapter initializeAdapter(ArrayList<CharacterCardData> charactersList) {
        CharactersListAdapter adapter = new CharactersListAdapter(charactersList, requireContext());
        return adapter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}