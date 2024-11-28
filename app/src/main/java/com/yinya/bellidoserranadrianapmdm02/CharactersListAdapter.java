package com.yinya.bellidoserranadrianapmdm02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.yinya.bellidoserranadrianapmdm02.databinding.CardCharactersListItemBinding;

import java.util.ArrayList;

/**
 * Adapter for managing and displaying a list of character items in a RecyclerView.
 */
public class CharactersListAdapter extends RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder> {

    private final ArrayList<CharacterData> characters;
    private final Context context;

    /**
     * Constructor for the CharactersListAdapter.
     *
     * @param characters A list of {@link CharacterData} objects to be displayed.
     * @param context    The context in which the adapter is used.
     */
    public CharactersListAdapter(ArrayList<CharacterData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new {@link CharacterViewHolder} to represent an item.
     *
     * @param parent   The parent ViewGroup into which the new view will be added.
     * @param viewType The view type of the new view.
     * @return A new {@link CharacterViewHolder} instance.
     */
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardCharactersListItemBinding binding = CardCharactersListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    /**
     * Returns the total number of items in the dataset.
     *
     * @return The number of characters in the list.
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }

    /**
     * Binds the data of a {@link CharacterData} object to a ViewHolder.
     *
     * @param holder   The {@link CharacterViewHolder} to bind data to.
     * @param position The position of the item in the dataset.
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = characters.get(position);
        holder.characterName.setText(currentCharacter.getName());
        holder.characterImage.setImageResource(currentCharacter.getImage());
        View.OnClickListener onClickListener = view -> itemClicked(currentCharacter, view);
        holder.characterCard.setOnClickListener(onClickListener);
    }

    /**
     * Handles item click events by delegating to the main activity to display character details.
     *
     * @param characterData The {@link CharacterData} object associated with the clicked item.
     * @param view          The view that was clicked.
     */
    private void itemClicked(CharacterData characterData, View view) {
        ((MainActivity) context).showCharacterDetail(characterData, view);
    }

    /**
     * ViewHolder class for character items. Holds references to UI components for a single item view.
     */
    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private ImageView characterImage;
        private TextView characterName;
        private MaterialCardView characterCard;

        /**
         * Constructor for CharacterViewHolder.
         *
         * @param binding The binding object for the character list item layout.
         */
        public CharacterViewHolder(@NonNull CardCharactersListItemBinding binding) {
            super(binding.getRoot());
            characterImage = binding.ivCharactersListCardView;
            characterName = binding.tvCharactersListCardView;
            characterCard = binding.cvCharactersList;
        }
    }

}
