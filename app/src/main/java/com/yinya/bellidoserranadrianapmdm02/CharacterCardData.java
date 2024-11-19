package com.yinya.bellidoserranadrianapmdm02;

public class CharacterCardData {
    private int image;
    private String characterName;


    public CharacterCardData(int image, String characterName) {
        this.image = image;
        this.characterName = characterName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
