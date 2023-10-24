package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Model.Theatre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TheatreRepositoryTest {
    @Autowired
    TheatreRepository theatreRepository;

    Theatre theatre1 = new Theatre(23L,"William Shakespeare",10, "Tragedy");
    Theatre theatre2 = new Theatre(24L,"William Shakespeare",15, "Comedy");
    Theatre theatre3 = new Theatre(25L,"Oscar Wilde",7, "Tragedy");

    @BeforeEach
    public void setUp(){
        theatreRepository.save(theatre1);
        theatreRepository.save(theatre2);
        theatreRepository.save(theatre3);
    }
    @AfterEach
    public void tearDown(){
        theatreRepository.delete(theatre1);
        theatreRepository.delete(theatre2);
        theatreRepository.delete(theatre3);
    }
    @Test
    void getTheatreByPlayWright_withValidPlayWright() {
        String playWright = "William Shakespeare";
        List<Theatre> theatreList =theatreRepository.findTheatreByPlayWright(playWright);
        assertFalse(theatreList.isEmpty());
        assertEquals(6, theatreList.size());
    }

    @Test
    void getTheatreByPlayWright_withInValidPlayWright() {
        String playWright = "Nothing";
        List<Theatre> theatreList =theatreRepository.findTheatreByPlayWright(playWright);
        assertTrue(theatreList.isEmpty());
        assertEquals(0, theatreList.size());
    }
    @Test
    void getTheatreByPlayWright_withNullPlayWright() {
        String playWright = null;
        List<Theatre> theatreList =theatreRepository.findTheatreByPlayWright(playWright);
        assertTrue(theatreList.isEmpty());
        assertEquals(0, theatreList.size());
    }
    @Test
    void getTheatreByNumberOfActors_withValidNumberOfActors() {
        int numberOfActors = 10;
        List<Theatre> theatreList = theatreRepository.findTheatreByNumberOfActors(numberOfActors);
        assertFalse(theatreList.isEmpty());
        assertEquals(3, theatreList.size());

    }
    @Test
    void getTheatreByNumberOfActors_withInValidNumberOfActors() {
        int numberOfActors = 0;
        List<Theatre> theatreList = theatreRepository.findTheatreByNumberOfActors(numberOfActors);
        assertTrue(theatreList.isEmpty());
        assertEquals(0, theatreList.size());
    }
    @Test
    void getTheatreByCategory_withValidCategory() {
        String category = "Tragedy";
        List<Theatre> theatreList = theatreRepository.findTheatreByCategory(category);
        assertFalse(theatreList.isEmpty());
        assertEquals(5, theatreList.size());
    }
    @Test
    void getTheatreByCategory_withInValidCategory() {
        String category = "Nothing";
        List<Theatre> theatreList =theatreRepository.findTheatreByCategory(category);
        assertTrue(theatreList.isEmpty());
        assertEquals(0, theatreList.size());
    }

    @Test
    void getTheatreByCategory_withNullCategory() {
        String category = null;
        List<Theatre> theatreList =theatreRepository.findTheatreByCategory(category);
        assertTrue(theatreList.isEmpty());
        assertEquals(0, theatreList.size());
    }
}