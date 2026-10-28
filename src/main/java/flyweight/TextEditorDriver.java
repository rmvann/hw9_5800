package flyweight;

import java.io.IOException;

import static flyweight.Document.loadFile;

public class TextEditorDriver {
    public static void main(String[] args) throws IOException {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        Document doc = new Document(factory);

        doc.addCharacter('H', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('e', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('l', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('l', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('o', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('W', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('o', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('r', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('l', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('d', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('C', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('S', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('5', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('8', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('0', Font.CALIBRI, Color.BLACK, 12);
        doc.addCharacter('0', Font.CALIBRI, Color.BLACK, 12);

        doc.saveFile("newDocument");
        doc.editCharacter(0, 'H', Font.ARIAL, Color.BLACK, 14);
        doc.saveFile("newDocument_v2");
        doc.editCharacter(5, 'W', Font.CALIBRI, Color.RED, 14);
        doc.saveFile("newDocument_v3");
        doc.editCharacter(10, 'C', Font.VERDANA, Color.BLUE, 20);
        doc.saveFile("newDocument_v4");

        doc.displayDocument();
    }
}
