package SDAIronHack.ArtHouse.Controller.impl;

import SDAIronHack.ArtHouse.Repository.CinemaRepository;
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
class CinemaControllerTest {
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @AfterEach
    public void tearDown() {
        cinemaRepository.deleteById(9L);
    }
    @Test
    void getAllCinema_validRequest_allCinema() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Steven Spielberg"));
    }
    @Test
    void getAllCinema_inValidRequest_notFound() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void getCinemaById_validId_correctCinema() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getById/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Drama"));
    }
    @Test
    void getCinemaById_inValidId_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getById/90"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getCinemaByReleaseYear_validReleaseYear_correctCinema() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getByReleaseYear/2008"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Christopher Nolan"));
    }
    @Test
    void getCinemaByReleaseYear_inValidReleaseYear_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getByReleaseYear/2030"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getCinemaByDirector_validDirector_correctCinema() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getByDirector/Sidney Lumet"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Drama"));
    }
    @Test
    void getCinemaByDirector_inValidDirector_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getByDirector/nobody"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getCinemaByCategory_validCategory_correctCinema() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getByCategory/category?category=Drama"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Steven Spielberg"));
    }
    @Test
    void getCinemaByCategory_inValidCategory_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Cinema/getByCategory/category?category=Horror"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    // ===============================================================



    @Test
    void addCinema() {
    }

    @Test
    void deleteCinemaById() {
    }
}