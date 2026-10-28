package flyweight;

public class Character {
    private CharacterStyle characterStyle;
    private char character;

    public Character (char character, CharacterStyle characterStyle) {
        this.character = character;
        this.characterStyle = characterStyle;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterStyle getStyle() {
        return characterStyle;
    }
}
