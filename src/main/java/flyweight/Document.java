package flyweight;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Document {
    private List<Character> characters = new ArrayList<>();
    private final CharacterStyleFactory styleFactory;

    public Document(CharacterStyleFactory styleFactory) {
        this.styleFactory = styleFactory;
    }

    public void addCharacter(char character, Font font, Color color, int size) {
        CharacterStyle style = styleFactory.createStyle(font, color, size);
        Character c = new Character(character, style);
        characters.add(c);
    }

    public void editCharacter(int index, char character, Font font, Color color, int size) {
        CharacterStyle style = styleFactory.createStyle(font, color, size);
        Character c = new Character(character, style);
        characters.set(index, c);
    }

    public String getText() {
        StringBuilder text = new StringBuilder();

        for (Character character : characters) {
            text.append(character.getCharacter());
        }

        return text.toString();
    }

    public void displayDocument() {
        System.out.println("Document text: " + getText());
        System.out.println("Character styles:");

        for (Character character : characters) {
            CharacterStyle style =
                    character.getStyle();

            System.out.println(
                    "Character: " + character.getCharacter()
                            + ", Font: " + style.getFont()
                            + ", Color: " + style.getColor()
                            + ", Size: " + style.getSize()
            );
        }
    }

    public void saveFile(String filename) throws IOException {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filename))) {

            for (Character character : characters) {
                CharacterStyle style =
                        character.getStyle();

                writer.write(
                        character.getCharacter()
                                + "," + style.getFont()
                                + "," + style.getColor()
                                + "," + style.getSize()
                );

                writer.newLine();
            }
        }
    }

    public static Document loadFile(String filename, CharacterStyleFactory factory) throws IOException {

        Document document = new Document(factory);

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                char character = data[0].charAt(0);
                Font font = Font.valueOf(data[1]);
                Color color = Color.valueOf(data[2]);
                int size = Integer.parseInt(data[3]);

                document.addCharacter(character, font, color, size);
            }
        }

        return document;
    }
}
