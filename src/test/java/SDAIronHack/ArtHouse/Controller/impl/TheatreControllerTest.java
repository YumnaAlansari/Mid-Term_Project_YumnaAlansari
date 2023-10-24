package SDAIronHack.ArtHouse.Controller.impl;

import SDAIronHack.ArtHouse.Repository.TheatreRepository;
import SDAIronHack.ArtHouse.Service.impl.TheatreService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
class TheatreControllerTest {

    @Autowired
    TheatreService theatreService;
    @Autowired
    TheatreRepository theatreRepository;
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
        theatreRepository.deleteById(9L);
    }
    @Test
    void getAllTheatre_validRequest_allTheatre() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("William Shakespeare"));
    }

    @Test
    void getAllTheatre_inValidRequest_allTheatre() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Nobody"));
    }

    @Test
    void getTheatreById_validId_correctTheatre() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getById/11"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Comedy"));
    }

    @Test
    void getTheatreById_inValidId_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getById/90"))
                .andExpect(status().isNotFound())
                .andReturn();

    }

    @Test
    void getTheatreByPlayWright() {
    }

    @Test
    void getTheatreByNumberOfActors() {
    }

    @Test
    void getTheatreByCategory() {
    }

    @Test
    void addTheatre() {
    }

    @Test
    void changeTheatreCategory() {
    }

    @Test
    void deleteTheatreById() {
    }
}