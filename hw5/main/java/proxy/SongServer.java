package proxy;

import java.util.*;

public class SongServer implements SongService {

    private List<Song> songList;

    public SongServer() {
        this.songList = new ArrayList<>();
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception _) {}
    }

    @Override
    public Song searchById(Integer songID) {
        delay();
        if (!this.containsId(songID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return this.getSongList().stream().filter(s -> s.getId() == songID).toList().getFirst();
    }

    private boolean containsId(Integer songID) {
        return this.getSongList().stream().map(Song::getId).toList().contains(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay();
        return this.getSongList().stream().filter(s -> Objects.equals(s.getTitle(),
                title)).toList();
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay();
        return this.getSongList().stream().filter(s -> Objects.equals(s.getAlbum(),
                album)).toList();
    }

    public List<Song> getSongList() {
        return this.songList;
    }

    public void addSong(Song song) {
        this.getSongList().add(song);
    }

}
