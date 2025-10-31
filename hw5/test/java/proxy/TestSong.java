package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSong {

    Song song2;
    Song comeAsYouAre;

    @BeforeEach
    public void setup() {
        song2 = new Song("Song 2", "Blur", "Blur (self-titled)", 122);
        comeAsYouAre = new Song("Come As You Are", "Nirvana", "Nevermind", 218);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Song 2", song2.getTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals("Blur", song2.getArtist());
    }

    @Test
    public void testGetAlbum() {
        assertEquals("Blur (self-titled)", song2.getAlbum());
    }

    @Test
    public void testGetDuration() {
        assertEquals(122, song2.getDuration());
    }

    @Test
    public void testSetTitle() {
        song2.setTitle("Smells Like Teen Spirit");
        assertEquals("Smells Like Teen Spirit", song2.getTitle());
    }

    @Test
    public void testSetArtist() {
        song2.setArtist("Nirvana");
        assertEquals("Nirvana", song2.getArtist());
    }

    @Test
    public void testSetAlbum() {
        song2.setAlbum("Nevermind");
        assertEquals("Nevermind", song2.getAlbum());
    }

    @Test
    public void testSetDuration() {
        song2.setDuration(278);
        assertEquals(278, song2.getDuration());
    }

    @Test
    public void testGetDurationInMinSec() {
        assertEquals("3:38", comeAsYouAre.getDurationInMinSec());
    }

    @Test
    public void testGetDurationInMinSecLeadingZero() {
        assertEquals("2:02", song2.getDurationInMinSec());
    }

}
