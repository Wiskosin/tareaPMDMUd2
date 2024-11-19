package com.yinya.bellidoserranadrianapmdm02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yinya.bellidoserranadrianapmdm02.databinding.CardMainListItemBinding;

import java.util.ArrayList;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.CharacterViewHolder> {

    private final ArrayList<CharacterCardData> characters;
    private final Context context;

    public MainListAdapter(ArrayList<CharacterCardData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.characterName.setText(characters.get(position).getCharacterName());

    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private ImageView characterImage;
        private TextView characterName;

        public CharacterViewHolder(@NonNull CardMainListItemBinding binding) {
            super(binding.getRoot());
            characterImage = binding.ivMainListCardView;
            characterName = binding.tvMainListCardView;
        }
    }

}
