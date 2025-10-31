package proxy;

import java.util.*;

public class SongServerProxy implements SongService {

    private List<Song> songCache;
    private final SongServer server;

    public SongServerProxy(SongServer server) {
        this.server = server;
        this.songCache = new ArrayList<>();
    }

    @Override
    public Song searchById(Integer songID) {
        Song song;
        if (!this.containsId(songID)) {
            this.getSongCache().add(this.server.searchById(songID));
        }
        return this.getSongCache().stream().filter(s -> s.getId() == songID).toList().getFirst();
    }

    private boolean containsId(Integer songID) {
        return this.getSongCache().stream().map(Song::getId).toList().contains(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> localByTitle =
                new ArrayList<>(this.getSongCache().stream().filter(s -> Objects.equals(s.getTitle(), title)).toList());
        if (localByTitle.isEmpty()) {
            List<Song> remoteByTitle = this.server.searchByTitle(title);
            updateSongCache(localByTitle, remoteByTitle);
        }
        return localByTitle;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> localByAlbum =
                new ArrayList<>(this.getSongCache().stream().filter(s -> Objects.equals(s.getAlbum(), album)).toList());
        if (localByAlbum.isEmpty()) {
            List<Song> remoteByAlbum = this.server.searchByAlbum(album);
            updateSongCache(localByAlbum, remoteByAlbum);
        }
        return localByAlbum;
    }

    private void updateSongCache(List<Song> localByAlbum, List<Song> remoteByAlbum) {
        List<Song> newCacheEntries = new ArrayList<>(remoteByAlbum);
        newCacheEntries.removeAll(localByAlbum);
        localByAlbum.addAll(newCacheEntries);
        for (Song s : newCacheEntries) {
            this.getSongCache().add(s);
        }
    }

    public List<Song> getSongCache() {
        return this.songCache;
    }
}
