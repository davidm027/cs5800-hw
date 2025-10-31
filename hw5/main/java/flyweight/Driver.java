package flyweight;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
    public static void main(String[] args) throws IOException {
        TextEditor editor = new TextEditor();

        File f = new File("HelloWorldCS5800");
        if (f.exists()) {
            f.delete();
        }
        TextEditor.createNewFile("HelloWorldCS5800");

        TextEditor.writeCharacterToFile("HelloWorldCS5800", "Arial", "Red",
                "12");
        TextEditor.writeCharacterToFile("HelloWorldCS5800", "Arial", "Black",
                "10");
        TextEditor.writeCharacterToFile("HelloWorldCS5800", "Times New Roman", "Red",
                "12");
        TextEditor.writeCharacterToFile("HelloWorldCS5800", "Arial", "Blue",
                "12");
        TextEditor.writeCharacterToFile("HelloWorldCS5800", "Comic Sans", "Blue",
                "12");

        String content = Files.readString(Paths.get("HelloWorldCS5800"), StandardCharsets.UTF_8);
        System.out.println(content.strip());
    }
}
