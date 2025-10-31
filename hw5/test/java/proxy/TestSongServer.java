package proxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSongServer {

    static Song smellsLikeTeenSpirit;
    static Song smellsLikeTeenSpirit2;
    static Song lithium;
    SongServer server;

    @BeforeAll
    public static void setupAll() {
        smellsLikeTeenSpirit = new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 278);
        lithium = new Song("Lithium", "Nirvana", "Nevermind", 256);
        smellsLikeTeenSpirit2 = new Song("Smells Like Teen Spirit", "Nirvana", "Nirvana: The Box " +
                "Set", 310);
    }

    @BeforeEach
    public void setupEach() {
        server = new SongServer();
        server.addSong(smellsLikeTeenSpirit);
        server.addSong(lithium);
        server.addSong(smellsLikeTeenSpirit2);
    }

    @Test
    public void testSearchByValidId() {
        assertEquals(lithium, server.searchById(1));
    }

    @Test
    public void testSearchByInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> server.searchById(42));
        String expectedMessage = "Invalid ID";
        assertTrue(expectedMessage.contains(e.getMessage()));
    }

    @Test
    public void testSearchByTitle() {
        List<Song> smts = new ArrayList<>(List.of(smellsLikeTeenSpirit, smellsLikeTeenSpirit2));
        assertEquals(smts, server.searchByTitle("Smells Like Teen Spirit"));
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> nevermind = new ArrayList<>(List.of(smellsLikeTeenSpirit,
                lithium));
        assertEquals(nevermind, server.searchByAlbum("Nevermind"));
    }

}
