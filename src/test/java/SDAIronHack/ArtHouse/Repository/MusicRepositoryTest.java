package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MusicRepositoryTest {

    @Autowired
    MusicRepository musicRepository;
    Music music1 = new Music ( 9L, "Pop", "Stellar Beats", 2020);
    Music music2 = new Music (17L,"Pop", "GLENN MILLER", 1972);
    Music music3 = new Music (18L,"Pop", "Stellar Beats", 2008);

    @BeforeEach
    public void setUp(){
        musicRepository.save(music1);
        musicRepository.save(music2);
        musicRepository.save(music3);
    }
    @AfterEach
    public void tearDown(){
        musicRepository.delete(music1);
        musicRepository.delete(music2);
        musicRepository.delete(music3);
    }

    @Test
    void findMusicByGenre_withValidGenre() {
        String genre = "Pop";
        List<Music> musicList = musicRepository.findMusicByGenre(genre);
        assertFalse(musicList.isEmpty());
        assertEquals(4, musicList.size());
    }
    @Test
    void findMusicByGenre_withInValidGenre() {
        String genre = "JK";
        List<Music> musicList = musicRepository.findMusicByGenre(genre);
        assertTrue(musicList.isEmpty());
        assertEquals(0, musicList.size());
    }
    @Test
    void findMusicByGenre_withNullGenre() {
        String genre = null;
        List<Music> musicList = musicRepository.findMusicByGenre(genre);
        assertTrue(musicList.isEmpty());
        assertEquals(0, musicList.size());
    }
    @Test
    void findMusicByArtist_withValidArtist() {
        String artist = "Stellar Beats";
        List<Music> musicList = musicRepository.findMusicByArtist(artist);
        assertFalse(musicList.isEmpty());
        assertEquals(3, musicList.size());
    }
    @Test
    void findMusicByArtist_withInValidArtist() {
        String artist = "Potato";
        List<Music> musicList = musicRepository.findMusicByArtist(artist);
        assertTrue(musicList.isEmpty());
        assertEquals(0, musicList.size());
    }
    @Test
    void findMusicByArtist_withNullArtist() {
        String artist = null;
        List<Music> musicList = musicRepository.findMusicByArtist(artist);
        assertTrue(musicList.isEmpty());
        assertEquals(0, musicList.size());
    }
    @Test
    void findMusicByReleaseYear_withValidReleaseYear() {
        int releaseYear = 2020;
        List<Music> musicList = musicRepository.findMusicByReleaseYear(releaseYear);
        assertFalse(musicList.isEmpty());
        assertEquals(1, musicList.size());
    }
    @Test
    void findMusicByReleaseYear_withInValidReleaseYear() {
        int releaseYear = 2030;
        List<Music> cinemaList = musicRepository.findMusicByReleaseYear(releaseYear);
        assertTrue(cinemaList.isEmpty());
        assertEquals(0, cinemaList.size());
    }
}