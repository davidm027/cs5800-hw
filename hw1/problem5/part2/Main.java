package problem5.part2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Folder config = new Folder("config");
        Folder controllers = new Folder("controllers");
        Folder library = new Folder("library");
        Folder migrations = new Folder("migrations");
        Folder models = new Folder("models");
        Folder views = new Folder("views");

        ArrayList<Folder> appSubdirs = new ArrayList<>(Arrays.asList(config, controllers, library, migrations,
                models, views));

        // Folder app = new Folder("app", appSubdirs, new ArrayList<>());

        Folder phalcon = new Folder(".phalcon");
        Folder cache = new Folder("cache");
        Folder publicFolder = new Folder("public");
        ArrayList<Folder> sfSubdirs = new ArrayList<>(Arrays.asList(phalcon,
                cache, publicFolder));
        File htaccess = new File(".htaccess");
        File htrouter = new File("htrouter.php");
        File index = new File("index.html");
        ArrayList<File> sfFiles = new ArrayList<>(Arrays.asList(htaccess, htrouter,
                index));

        Folder sourceFiles = new Folder("Source Files", sfSubdirs, sfFiles);

        Folder includePath = new Folder("Include Path");
        Folder remoteFiles = new Folder("Remote Files");

        ArrayList<Folder> demo1Subdirs = new ArrayList<>(Arrays.asList(sourceFiles,
                includePath, remoteFiles));

        Folder demo1 = new Folder("demo1", demo1Subdirs, new ArrayList<>());

        System.out.println(demo1);
    }
}
