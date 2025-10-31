package flyweight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class TextEditor {

    static CharacterFactory characterFactory = new CharacterFactory();

    static Character createCharacter(String fontName, String colorName, String sizeAmount) {
        Property font = characterFactory.getProperty(0);
        Property color = characterFactory.getProperty(1);
        Property size = characterFactory.getProperty(2);

        font.setProperty(fontName);
        color.setProperty(colorName);
        size.setProperty(String.valueOf(sizeAmount));

        return new Character(font, color, size);
    }

    public static void createNewFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.createNewFile()) {
            throw new IllegalArgumentException("File already exists");
        }
    }

    public static void writeCharacterToFile(String filename, String fontName, String colorName,
                             String sizeAmount) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            Character character = TextEditor.createCharacter(fontName, colorName, sizeAmount);
            fw.write(character.toString() + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
