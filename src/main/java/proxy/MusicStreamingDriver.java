package proxy;

import java.util.List;

public class MusicStreamingDriver {
    public static void main(String[] args) {
        SongService songService = createSongService();

        System.out.println("searching for songs with id: 3...");
        System.out.println(songService.searchById(3));
        System.out.println(songService.searchById(3));

        System.out.println();
        System.out.println("searching for songs with name: Flowers...");
        List<Song> flowers = songService.searchByTitle("Flowers");
        for (Song song : flowers) {
            System.out.println(song);
        }
        List<Song> flowers2 = songService.searchByTitle("Flowers");
        for (Song song : flowers2) {
            System.out.println(song);
        }

        System.out.println();
        System.out.println("searching for songs in album: After Hours...");
        List<Song> afterhours = songService.searchByAlbum("After Hours");
        for (Song song : afterhours) {
            System.out.println(song);
        }
        List<Song> afterhours2 = songService.searchByAlbum("After Hours");
        for (Song song : afterhours2) {
            System.out.println(song);
        }
    }

    public static SongService createSongService() {
        SongService songService = new SongCache();

        Song song1 = new Song("Blinding Lights", "The Weeknd", "After Hours", 200);
        Song song2 = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 355);
        Song song3 = new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301);
        Song song4 = new Song("Hotel California", "Eagles", "Hotel California", 390);
        Song song5 = new Song("Flowers", "Miley Cyrus", "Endless Summer Vacation", 200);
        Song song6 = new Song("Starboy", "The Weeknd", "After Hours", 230);
        Song song7 = new Song("Flowers", "Lauren Spencer Smith", "Mirror", 157);

        songService.addSong(1, song1);
        songService.addSong(2, song2);
        songService.addSong(3, song3);
        songService.addSong(4, song4);
        songService.addSong(5, song5);
        songService.addSong(6, song6);
        songService.addSong(7, song7);
        return songService;
    }
}
