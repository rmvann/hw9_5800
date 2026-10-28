package flyweight;

import java.util.HashMap;

public class CharacterStyleFactory {
    private HashMap<String, CharacterStyle> styles = new HashMap<String, CharacterStyle>();

    public CharacterStyle createStyle(Font font, Color color, int size) {
        String key = font.toString() + color.toString() + Integer.toString(size);
        if (!styles.containsKey(key)) {
            styles.put(key, new CharacterStyle(font, color, size));
        }
        return styles.get(key);
    }
}
