package com.yinya.bellidoserranadrianapmdm02;

import android.content.Context;
import android.telephony.CarrierConfigManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
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
        View.OnClickListener onClickListener = view -> {
            // Action to be performed on click event
            Toast.makeText(view.getContext(), "Elemento clickeado", Toast.LENGTH_SHORT).show();
        };
        holder.characterCard.setOnClickListener(onClickListener);
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private ImageView characterImage;
        private TextView characterName;
        private MaterialCardView characterCard;

        public CharacterViewHolder(@NonNull CardCharactersListItemBinding binding) {
            super(binding.getRoot());
            characterImage = binding.ivCharactersListCardView;
            characterName = binding.tvCharactersListCardView;
            characterCard = binding.cvCharactersList;
        }
    }

}
