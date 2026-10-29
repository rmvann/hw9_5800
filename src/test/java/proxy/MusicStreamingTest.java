package proxy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MusicStreamingTest {
    private static SongService service;

    // to avoid re-instantiation of the service (which would clear cache in each test)
    @BeforeAll
    public static void beforeAll(){
        service = MusicStreamingDriver.createSongService();
    }

    @Test
    public void testSearchByID() {
        Song search = service.searchById(3);
        assertEquals("Smells Like Teen Spirit", search.getTitle());
    }

    // timeout if the lookup is slow (if not using cache)
    @Test
    @Timeout(1)
    public void testSearchByIDCache() {
        Song search = service.searchById(3);
        assertEquals("Smells Like Teen Spirit", search.getTitle());
    }

    @Test
    public void testSearchByTitle() {
        List<Song> flowers = service.searchByTitle("Flowers");
        List<String> actual = new ArrayList<>();
        for (Song song : flowers) {
            actual.add(song.getArtist());
        }

        List<String> expected = new ArrayList<>();
        expected.add("Miley Cyrus");
        expected.add("Lauren Spencer Smith");

        assertEquals(expected, actual);
    }

    @Test
    @Timeout(1)
    public void testSearchByTitleCache() {
        List<Song> flowers = service.searchByTitle("Flowers");
        List<String> actual = new ArrayList<>();
        for (Song song : flowers) {
            actual.add(song.getArtist());
        }

        List<String> expected = new ArrayList<>();
        expected.add("Miley Cyrus");
        expected.add("Lauren Spencer Smith");

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> afterhours = service.searchByAlbum("After Hours");
        List<String> actual = new ArrayList<>();
        for (Song song : afterhours) {
            actual.add(song.getTitle());
        }

        List<String> expected = new ArrayList<>();
        expected.add("Blinding Lights");
        expected.add("Starboy");

        assertEquals(expected, actual);
    }

    @Test
    @Timeout(1)
    public void testSearchByAlbumCache() {
        List<Song> afterhours = service.searchByAlbum("After Hours");
        List<String> actual = new ArrayList<>();
        for (Song song : afterhours) {
            actual.add(song.getTitle());
        }

        List<String> expected = new ArrayList<>();
        expected.add("Blinding Lights");
        expected.add("Starboy");

        assertEquals(expected, actual);
    }
}
