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
        int image1 = R.drawable.mario;
        String name1 = getResources().getString(R.string.character_name_1);
        int image2 = R.drawable.luigi;
        String name2 = getResources().getString(R.string.character_name_2);
        CharacterCardData character1 = new CharacterCardData(image1, name1);
        CharacterCardData character2 = new CharacterCardData(image2, name2);
        charactersList.add(character1);
        charactersList.add(character2);
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