package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongCache implements SongService {
    Map<Integer, Song> idCache = new HashMap<>();
    Map<String, List<Song>> titleCache = new HashMap<>();
    Map<String, List<Song>> albumCache = new HashMap<>();
    ConcreteSongService concreteSongService = new ConcreteSongService();

    @Override
    public Song searchById(Integer songID) {
        if (idCache.containsKey(songID)) {
            return idCache.get(songID);
        }
        // no cache hit
        Song song = concreteSongService.searchById(songID);
        idCache.put(songID, song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (titleCache.containsKey(title)){
            return titleCache.get(title);
        }
        List<Song> songs = concreteSongService.searchByTitle(title);
        titleCache.put(title, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (albumCache.containsKey(album)){
            return albumCache.get(album);
        }
        List<Song> songs = concreteSongService.searchByAlbum(album);
        albumCache.put(album, songs);
        return songs;
    }
}
