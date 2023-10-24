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
    void getAllTheatre_inValidRequest_notFound() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/"))
                .andExpect(status().isNotFound())
                .andReturn();
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
    void getTheatreByCategory_validCategory_correctTheatre() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByCategory/category?category=Comedy"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("William Shakespeare"));
    }
    @Test
    void getTheatreByCategory_inValidCategory_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByCategory/category?category=Horror"))
                .andExpect(status().isNotFound())
                .andReturn();

    }

    @Test
    void getTheatreByPlayWright_validPlayWright_correctTheatre() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByPlayWright/playWright?playWright=William Shakespeare"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Tragedy"));
    }
    @Test
    void getTheatreByPlayWright_inValidPlayWright_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByPlayWright/playWright?playWright=nobody"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getTheatreByNumberOfActors_validNumberOfActors_correctTheatre() throws Exception  {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByNumberOfActors/10"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Comedy"));
    }
    @Test
    void getTheatreByNumberOfActors_inValidNumberOfActors_correctTheatre() throws Exception  {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByNumberOfActors/19"))
                .andExpect(status().isNotFound())
                .andReturn();
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