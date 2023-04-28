package howard.edu.lsp.finals.problem; 

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class SongsDatabaseTest {

    @Test
    public void testAddSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        db.addSong("Pop", "California Gurls");
        db.addSong("R&B", "Differences");
        db.addSong("Rock", "Blue Suede Shoes");

        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(1, jazzSongs.size());
        assertTrue(jazzSongs.contains("Always There"));

        Set<String> popSongs = db.getSongs("Pop");
        assertEquals(1, popSongs.size());
        assertTrue(popSongs.contains("California Gurls"));

        Set<String> rbSongs = db.getSongs("R&B");
        assertEquals(1, rbSongs.size());
        assertTrue(rbSongs.contains("Differences"));

        Set<String> rockSongs = db.getSongs("Rock");
        assertEquals(1, rockSongs.size());
        assertTrue(rockSongs.contains("Blue Suede Shoes"));
    }

    @Test
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");

        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(1, jazzSongs.size());
        assertTrue(jazzSongs.contains("Always There"));
        
        db.addSong("Pop", "California Gurls");
        db.addSong("R&B", "Differences");
        db.addSong("Rock", "Blue Suede Shoes");

        
    }

    @Test
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        db.addSong("Pop", "California Gurls");
        db.addSong("R&B", "Differences");
        db.addSong("Rock", "Blue Suede Shoes");

        
        Set<String> rapSongs = db.getSongs("Rap");
        System.out.println("Rap songs: " + rapSongs); // [Savage, Gin and Juice]

        Set<String> popSongs = db.getSongs("Pop");
        System.out.println("Pop songs: " + popSongs); // [California Gurls]

        Set<String> rbSongs = db.getSongs("R&B");
        System.out.println("R&B songs: " + rbSongs); // [Differences]

        Set<String> rockSongs = db.getSongs("Rock");
        System.out.println("Rock songs: " + rockSongs); // [Blue Suede Shoes]

    }
}