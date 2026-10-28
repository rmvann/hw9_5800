package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    // Ensure that flyweight is correctly avoiding duplication and saving memory
    @Test
    public void testFlyweightMemoryUsage() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        factory.createStyle(Font.VERDANA, Color.BLACK, 10);
        int initialStyles = factory.numStyles();

        factory.createStyle(Font.VERDANA, Color.BLACK, 10);
        int newStyles = factory.numStyles();

        assertEquals(initialStyles, newStyles);
    }

    @Test
    public void testDocumentAddCharacter() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        Document doc = new Document(factory);

        doc.addCharacter('p', Font.CALIBRI, Color.BLACK, 12);
        String expected = "p";
        String actual = doc.getText();

        assertEquals(expected, actual);
    }

    @Test
    public void testDocumentEditCharacter() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        Document doc = new Document(factory);

        doc.addCharacter('p', Font.CALIBRI, Color.BLACK, 12);
        doc.editCharacter(0, 'f', Font.CALIBRI, Color.BLACK, 12);

        String expected = "f";
        String actual = doc.getText();
        assertEquals(expected, actual);
    }

}
