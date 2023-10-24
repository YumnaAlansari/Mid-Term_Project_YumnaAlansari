package SDAIronHack.ArtHouse.Controller.impl;

import SDAIronHack.ArtHouse.Repository.MusicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class MusicControllerTest {

    @Autowired
    MusicRepository musicRepository;
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

       /*
        Music music1 = new Music ( 9L, "Pop", "Stellar Beats", 2020);
        Optional<Music> musicOptional = musicRepository.findById(9L);
        assertTrue(musicOptional.isPresent());

        */

    }

   @AfterEach
    public void tearDown() {
        musicRepository.deleteById(9L);
    }

    @Test
    void getAllMusic_validRequest_allMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Pop"));
    }
    @Test
    void getAllMusic_inValidRequest_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void getMusicById_validId_correctMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getById/7"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("GLENN MILLER"));
    }
    @Test
    void getMusicById_inValidId_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getById/90"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void getMusicByGenre_validGenre_correctMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByGenre/pop"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("GLENN MILLER"));
    }
    @Test
    void getMusicByGenre_inValidGenre_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByGenre/poop"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getMusicByReleaseYear_validReleaseYear_correctMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByReleaseYear/2022"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Electronic"));
    }
    @Test
    void getMusicByReleaseYear_inValidReleaseYear_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByReleaseYear/2030"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getMusicByArtist_validArtist_correctMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByArtist/artist?artist=DJ Harmony"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Electronic"));

    }
    @Test
    void getMusicByArtist_inValidArtist_correctMusic() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByArtist/artist?artist=nobody"))
                .andExpect(status().isNotFound())
                .andReturn();
        }


    @Test
    void addMusic() {
    }
    @Test
    void updateMusicById() {
    }
    @Test
    void deleteMusicById() {
    }

}