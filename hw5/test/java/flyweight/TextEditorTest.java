package flyweight;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    TextEditor editor;
    Property font;
    Property color;
    Property size;

    @BeforeEach
    void setup() {
        editor = new TextEditor();
        font = new Font();
        color = new Color();
        size = new Size();

        font.setProperty("Arial");
        color.setProperty("Red");
        size.setProperty("12");
    }

    @AfterEach
    void tearDown() {
        File file1 = new File("file.txt");
        file1.delete();
    }

    @Test
    void testCreateCharacter() {
        Character c = TextEditor.createCharacter("Arial", "Red", "12");
        assertEquals("[(FONT:Arial)(COLOR:Red)(SIZE:12)]", c.toString());
    }

    @Test
    void testCreateNewFile() throws IOException {
        TextEditor.createNewFile("file.txt");
        File file = new File("file.txt");
        assertTrue(file.exists());
    }

    @Test
    void testCreateNewFileAlreadyExists() throws IOException {
        TextEditor.createNewFile("file.txt");
        Exception e = assertThrows(IllegalArgumentException.class, () -> TextEditor.createNewFile("file.txt"));
        String expectedMessage = "File already exists";
        assertTrue(expectedMessage.contains(e.getMessage()));
    }

    @Test
    void testWriteToNewFile() throws IOException {
        TextEditor.writeCharacterToFile("file.txt", font.getProperty(), color.getProperty(),
                size.getProperty());
        String content = Files.readString(Paths.get("file.txt"), StandardCharsets.UTF_8);
        content = content.strip();
        assertEquals("[(FONT:Arial)(COLOR:Red)(SIZE:12)]", content);
    }

    @Test
    void testWriteToExistingFile() throws IOException {
        TextEditor.createNewFile("file.txt");
        TextEditor.writeCharacterToFile("file.txt", font.getProperty(), color.getProperty(),
                size.getProperty());
        // TODO: how to check file contents?
        String content = Files.readString(Paths.get("file.txt"), StandardCharsets.UTF_8);
        content = content.strip();
        assertEquals("[(FONT:Arial)(COLOR:Red)(SIZE:12)]", content);
    }

}
