package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ConcreteSongService implements SongService {
    Map<Integer, Song> songs = new HashMap<>();

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

        songs.forEach((key, song) -> {
            if (song.getTitle().equals(title)) {
                matches.add(song);
            }
        });
        return matches;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try{
            Thread.sleep(1000);
        } catch (Exception _) {}

        List<Song> matches = new ArrayList<>();

        songs.forEach((key, song) -> {
            if (song.getAlbum().equals(album)) {
                matches.add(song);
            }
        });
        return matches;
    }
}
