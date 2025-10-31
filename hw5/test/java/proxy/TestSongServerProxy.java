package proxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSongServerProxy {

    static Song smellsLikeTeenSpirit;
    static Song smellsLikeTeenSpirit2;
    static Song lithium;
    SongServer server;
    static SongServerProxy proxy;

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
        proxy = new SongServerProxy(server);
    }

    @Test
    public void testSearchByValidId() {
        assertEquals(lithium, proxy.searchById(1));
    }

    @Test
    public void testSearchByValidIdCached() {
        assertTrue(proxy.getSongCache().isEmpty());
        Song s = proxy.searchById(1);
        assertEquals(1, proxy.getSongCache().size());
        assertEquals(s, proxy.searchById(1));
    }

    @Test
    public void testSearchByInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> proxy.searchById(42));
        String expectedMessage = "Invalid ID";
        assertTrue(expectedMessage.contains(e.getMessage()));
    }

    @Test
    public void testSearchByTitle() {
        List<Song> smts = new ArrayList<>(List.of(smellsLikeTeenSpirit, smellsLikeTeenSpirit2));
        assertTrue(proxy.getSongCache().isEmpty());
        List<Song> smtsCache = proxy.searchByTitle("Smells Like Teen Spirit");
        assertEquals(2, proxy.getSongCache().size());
        assertEquals(smts, smtsCache);
    }

    @Test
    public void testSearchByTitleCached() {
        proxy.searchByTitle("Smells Like Teen Spirit");
        long start = System.currentTimeMillis();
        proxy.searchByTitle("Smells Like Teen Spirit");
        long end = System.currentTimeMillis();
        long duration = end - start;
        assertTrue(duration < 1000);
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> nevermind = new ArrayList<>(List.of(smellsLikeTeenSpirit,
                lithium));
        assertTrue(proxy.getSongCache().isEmpty());
        List<Song> nevermindCache = proxy.searchByAlbum("Nevermind");
        assertEquals(2, proxy.getSongCache().size());
        assertEquals(nevermind, nevermindCache);
    }

    @Test
    public void testSearchByAlbumCached() {
        proxy.searchByAlbum("Nevermind");
        long start = System.currentTimeMillis();
        proxy.searchByAlbum("Nevermind");
        long end = System.currentTimeMillis();
        long duration = end - start;
        assertTrue(duration < 1000);
    }

}
