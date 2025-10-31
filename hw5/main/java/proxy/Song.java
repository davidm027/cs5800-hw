package proxy;

public class Song {

    private String title;
    private String artist;
    private String album;
    private int duration;

    private final int id;
    private static int counter = 0;

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.id = counter;
        counter += 1;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDurationInMinSec() {
        int minutes = this.getDuration() / 60;
        int seconds = this.getDuration() % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public String toString() {
        return "Title : " + this.getTitle() + "\n" +
                "Artist : " + this.getArtist() + "\n" +
                "Album : " + this.getAlbum() + "\n" +
                "Duration : " + this.getDurationInMinSec() + "\n" +
                "ID: " + this.getId() + "\n";
    }

}
