package proxy;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        Song smellsLikeTeenSpirit = new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind",
                278);
        Song smellsLikeTeenSpirit2 = new Song("Lithium", "Nirvana", "Nevermind", 256);
        Song comeAsYouAre = new Song("Come As You Are", "Nirvana", "Nevermind", 218);
        Song lithium = new Song("Smells Like Teen Spirit", "Nirvana", "Nirvana: The Box " +
                "Set", 310);
        Song youKnowYoureRight = new Song("You Know You're Right", "Nirvana", "Nirvana: The Box " +
                "Set", 218);

        SongServer server = new SongServer();
        server.addSong(smellsLikeTeenSpirit);
        server.addSong(lithium);
        server.addSong(smellsLikeTeenSpirit2);
        server.addSong(comeAsYouAre);
        server.addSong(youKnowYoureRight);

        SongServerProxy proxy = new SongServerProxy(server);

        long start;
        long end;
        double duration;

        start = System.currentTimeMillis();
        proxy.searchById(3);
        proxy.searchByTitle("Smells Like Teen Spirit");
        proxy.searchByAlbum("Nevermind");
        end = System.currentTimeMillis();
        duration = (double) (end - start) / 1000;
        System.out.println("Time spent before caching: " + duration + "s");

        start = System.currentTimeMillis();
        Song song1 = proxy.searchById(3);
        List<Song> smts = proxy.searchByTitle("Smells Like Teen Spirit");
        List<Song> nevermind = proxy.searchByAlbum("Nevermind");
        end = System.currentTimeMillis();
        duration = (double) (end - start) / 1000;
        System.out.println("Time spent AFTER caching: " + duration + "s");

        System.out.println("Songs: ");
        System.out.println(song1);
        System.out.println(smts);
        System.out.println(nevermind);
    }
}
