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
        int image3 = R.drawable.princesa_peach;
        String name3 = getResources().getString(R.string.character_name_3);
        int image4 = R.drawable.bowser;
        String name4 = getResources().getString(R.string.character_name_4);
        int image5 = R.drawable.toad;
        String name5 = getResources().getString(R.string.character_name_5);
        int image6 = R.drawable.yoshi;
        String name6 = getResources().getString(R.string.character_name_6);
        int image7 = R.drawable.princesa_daisy;
        String name7 = getResources().getString(R.string.character_name_7);
        int image8 = R.drawable.wario;
        String name8 = getResources().getString(R.string.character_name_8);
        int image9 = R.drawable.waluigi;
        String name9 = getResources().getString(R.string.character_name_9);
        int image10 = R.drawable.donkey_kong;
        String name10 = getResources().getString(R.string.character_name_10);
        int image11 = R.drawable.toadette;
        String name11 = getResources().getString(R.string.character_name_11);
        int image12 = R.drawable.rosalina;
        String name12 = getResources().getString(R.string.character_name_12);
        int image13 = R.drawable.luma;
        String name13 = getResources().getString(R.string.character_name_13);
        int image14 = R.drawable.bowser_jr;
        String name14 = getResources().getString(R.string.character_name_14);
        int image15 = R.drawable.kamek;
        String name15 = getResources().getString(R.string.character_name_15);
        int image16 = R.drawable.shy_guy;
        String name16 = getResources().getString(R.string.character_name_16);
        int image17 = R.drawable.koopa_troopa;
        String name17 = getResources().getString(R.string.character_name_17);
        int image18 = R.drawable.goompa;
        String name18 = getResources().getString(R.string.character_name_18);
        int image19 = R.drawable.lakitu;
        String name19 = getResources().getString(R.string.character_name_19);
        int image20 = R.drawable.chain_chomp;
        String name20 = getResources().getString(R.string.character_name_20);
        int image21 = R.drawable.boo;
        String name21 = getResources().getString(R.string.character_name_21);
        int image22 = R.drawable.bullet_bill;
        String name22 = getResources().getString(R.string.character_name_22);
        int image23 = R.drawable.piranha_plant;
        String name23 = getResources().getString(R.string.character_name_23);
        int image24 = R.drawable.king_boo;
        String name24 = getResources().getString(R.string.character_name_24);
        CharacterCardData character1 = new CharacterCardData(image1, name1);
        CharacterCardData character2 = new CharacterCardData(image2, name2);
        CharacterCardData character3 = new CharacterCardData(image3, name3);
        CharacterCardData character4 = new CharacterCardData(image4, name4);
        CharacterCardData character5 = new CharacterCardData(image5, name5);
        CharacterCardData character6 = new CharacterCardData(image6, name6);
        CharacterCardData character7 = new CharacterCardData(image7, name7);
        CharacterCardData character8 = new CharacterCardData(image8, name8);
        CharacterCardData character9 = new CharacterCardData(image9, name9);
        CharacterCardData character10 = new CharacterCardData(image10, name10);
        CharacterCardData character11 = new CharacterCardData(image11, name11);
        CharacterCardData character12 = new CharacterCardData(image12, name12);
        CharacterCardData character13 = new CharacterCardData(image13, name13);
        CharacterCardData character14 = new CharacterCardData(image14, name14);
        CharacterCardData character15 = new CharacterCardData(image15, name15);
        CharacterCardData character16 = new CharacterCardData(image16, name16);
        CharacterCardData character17 = new CharacterCardData(image17, name17);
        CharacterCardData character18 = new CharacterCardData(image18, name18);
        CharacterCardData character19 = new CharacterCardData(image19, name19);
        CharacterCardData character20 = new CharacterCardData(image20, name20);
        CharacterCardData character21 = new CharacterCardData(image21, name21);
        CharacterCardData character22 = new CharacterCardData(image22, name22);
        CharacterCardData character23 = new CharacterCardData(image23, name23);
        CharacterCardData character24 = new CharacterCardData(image24, name24);
        charactersList.add(character1);
        charactersList.add(character2);
        charactersList.add(character3);
        charactersList.add(character4);
        charactersList.add(character5);
        charactersList.add(character6);
        charactersList.add(character7);
        charactersList.add(character8);
        charactersList.add(character9);
        charactersList.add(character10);
        charactersList.add(character11);
        charactersList.add(character12);
        charactersList.add(character13);
        charactersList.add(character14);
        charactersList.add(character15);
        charactersList.add(character16);
        charactersList.add(character17);
        charactersList.add(character18);
        charactersList.add(character19);
        charactersList.add(character20);
        charactersList.add(character21);
        charactersList.add(character22);
        charactersList.add(character23);
        charactersList.add(character24);
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