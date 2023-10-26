package SDAIronHack.ArtHouse.Controller.impl;

import SDAIronHack.ArtHouse.Model.Music;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class MusicControllerTest {

    @Autowired
    MusicRepository musicRepository;
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    Music music;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        music = new Music ( 9L, "aabbccddeeff", "Stellar Beats", 2020);
        musicRepository.save(music);
    }


    /*
   @AfterEach
    public void tearDown() {
       Long id = musicRepository.findMusicByGenre("aabbccddeeff").get(0).getId();
       musicRepository.deleteById(id);
    }
     */


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
    void getMusicByArtist_inValidArtist_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Music/getByArtist/artist?artist=nobody"))
                .andExpect(status().isNotFound())
                .andReturn();
        }
    @Test
    void saveMusic_validBody_MusicSaved() throws Exception {
        String body = objectMapper.writeValueAsString(music);

        mockMvc.perform(post("/api/Music/addMusic").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(musicRepository.findAll().toString().contains("Pop"));
    }

    @Test
    void updateMusic_validBody_musicUpdated() throws Exception {
        music.setArtist("Serene Harmony");
        String body = objectMapper.writeValueAsString(music);

        Long id = musicRepository.findMusicByGenre("aabbccddeeff").get(0).getId();
        mockMvc.perform(put("/api/Music/updateById/"+ id).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();


        assertTrue(musicRepository.findAll().toString().contains("Serene Harmony"));

    }

    @Test
    void deleteMusic_validRequest_musicDeleted() throws Exception {
        Long id = musicRepository.findMusicByGenre("aabbccddeeff").get(0).getId();

        mockMvc.perform(delete("/api/Music/deleteById/" + id))
                .andExpect(status().isAccepted())
                .andReturn();

       assertFalse(musicRepository.findAll().toString().contains("aabbccddeeff"));
    }

}