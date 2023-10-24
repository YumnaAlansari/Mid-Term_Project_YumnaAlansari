package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Cinema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CinemaRepositoryTest {

    @Autowired
    CinemaRepository cinemaRepository;
    Cinema cinema1 = new Cinema ( 16L,"Frank Darabont", 10, 1994, "Drama");
    Cinema cinema2 = new Cinema (17L,"rancis Ford Coppola", 8, 1972, "Crime");
    Cinema cinema3 = new Cinema (18L,"Christopher Nolan", 6, 2008, "Action");

    @BeforeEach
    public void setUp(){
       cinemaRepository.save(cinema1);
       cinemaRepository.save(cinema2);
       cinemaRepository.save(cinema3);
    }

    @AfterEach
    public void tearDown(){
        cinemaRepository.delete(cinema1);
        cinemaRepository.delete(cinema2);
        cinemaRepository.delete(cinema3);
    }
    @Test
    void findCinemaByDirector_withValidDirectory() {
        String director = "Frank Darabont";
        List<Cinema> cinemaList = cinemaRepository.findCinemaByDirector(director);
        assertFalse(cinemaList.isEmpty());
        assertEquals(2, cinemaList.size());
    }
    @Test
    void findCinemaByDirector_withInValidDirectory() {
        String director = "Incorrect Director";
        List<Cinema> cinemaList = cinemaRepository.findCinemaByDirector(director);
        assertTrue(cinemaList.isEmpty());
        assertEquals(0, cinemaList.size());
    }
    @Test
    void findCinemaByDirector_withNullDirector() {
        String director = null;
        List<Cinema> cinemaList = cinemaRepository.findCinemaByDirector(director);
        assertTrue(cinemaList.isEmpty());
        assertEquals(0, cinemaList.size());
    }
    @Test
    void findCinemaByReleaseYear_withValidReleaseYear() {
        int releaseYear = 1972;
        List<Cinema> cinemaList = cinemaRepository.findCinemaByReleaseYear(releaseYear);
        assertFalse(cinemaList.isEmpty());
        assertEquals(2, cinemaList.size());

    }
    @Test
    void findCinemaByReleaseYear_withInValidReleaseYear() {
        int releaseYear = 2030;
        List<Cinema> cinemaList = cinemaRepository.findCinemaByReleaseYear(releaseYear);
        assertTrue(cinemaList.isEmpty());
        assertEquals(0, cinemaList.size());
    }
    @Test
    void findCinemaByCategory_withValidCategory() {
        String category = "Drama";
        List<Cinema> cinemaList = cinemaRepository.findCinemaByCategory(category);
        assertFalse(cinemaList.isEmpty());
        assertEquals(4, cinemaList.size());
    }

    @Test
    void findCinemaByCategory_withInValidCategory() {
        String category = "Horror";
        List<Cinema> cinemaList = cinemaRepository.findCinemaByCategory(category);
        assertTrue(cinemaList.isEmpty());
        assertEquals(0, cinemaList.size());
    }
    @Test
    void findCinemaByCategory_withNullCategory() {
        String category = null;
        List<Cinema> cinemaList = cinemaRepository.findCinemaByCategory(category);
        assertTrue(cinemaList.isEmpty());
        assertEquals(0, cinemaList.size());
    }


}