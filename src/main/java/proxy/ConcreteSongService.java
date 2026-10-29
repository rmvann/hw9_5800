package proxy;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSongService implements SongService {
    List<Song> songs = new ArrayList<>();

    @Override
    public Song searchById(Integer songID) {
        try{
            Thread.sleep(1000);
        } catch (Exception _) {}

        return songs.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try{
            Thread.sleep(1000);
        } catch (Exception _) {}

        List<Song> matches = new ArrayList<>();

        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                matches.add(song);
            }
        }
        return matches;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try{
            Thread.sleep(1000);
        } catch (Exception _) {}

        List<Song> matches = new ArrayList<>();

        for (Song song : songs) {
            if (song.getAlbum().equals(album)) {
                matches.add(song);
            }
        }
        return matches;
    }
}
