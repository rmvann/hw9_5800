package proxy;

import java.util.List;

public class Song implements SongService {
    String title;
    String artist;
    String album;
    int duration;

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    @Override
    public Song searchById(Integer songID) {
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return List.of();
    }
}
