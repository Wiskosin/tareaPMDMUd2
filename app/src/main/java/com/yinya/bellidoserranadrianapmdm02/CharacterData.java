package com.yinya.bellidoserranadrianapmdm02;

/**
 * Represents the data of a character, including its image, name, description, and skills.
 */
public class CharacterData {
    private int image;
    private String name;
    private String description;
    private String skills;

    /**
     * Constructs a new CharacterData object with the specified image, name, description, and skills.
     *
     * @param image       the identifier of the character's image
     * @param name        the name of the character
     * @param description a brief description of the character
     * @param skills      the skills or abilities of the character
     */
    public CharacterData(int image, String name, String description, String skills) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    /**
     * Gets the identifier of the character's image.
     *
     * @return the image identifier
     */
    public int getImage() {
        return image;
    }

    /**
     * Sets the identifier of the character's image.
     *
     * @param image the new image identifier
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Gets the name of the character.
     *
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name of the character.
     *
     * @return the character's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the character.
     *
     * @return the character's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the character.
     *
     * @param description the new description for the character
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the skills or abilities of the character.
     *
     * @return the character's skills
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Sets the skills or abilities of the character.
     *
     * @param skills the new skills for the character
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }
}
