package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongCache implements SongService {
    Map<String, Song> cache = new HashMap<>();

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
