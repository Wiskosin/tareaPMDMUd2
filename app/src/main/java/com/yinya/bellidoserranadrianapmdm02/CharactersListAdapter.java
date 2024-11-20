package com.yinya.bellidoserranadrianapmdm02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yinya.bellidoserranadrianapmdm02.databinding.CardCharactersListItemBinding;

import java.util.ArrayList;

public class CharactersListAdapter extends RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder> {

    private final ArrayList<CharacterCardData> characters;
    private final Context context;

    public CharactersListAdapter(ArrayList<CharacterCardData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardCharactersListItemBinding binding = CardCharactersListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterCardData currentCharacter = characters.get(position);
        holder.characterName.setText(currentCharacter.getCharacterName());
        holder.characterImage.setImageResource(currentCharacter.getImage());

    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private ImageView characterImage;
        private TextView characterName;

        public CharacterViewHolder(@NonNull CardCharactersListItemBinding binding) {
            super(binding.getRoot());
            characterImage = binding.ivCharactersListCardView;
            characterName = binding.tvCharactersListCardView;
        }
    }

}
