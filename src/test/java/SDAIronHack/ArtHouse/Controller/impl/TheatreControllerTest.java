package SDAIronHack.ArtHouse.Controller.impl;

import SDAIronHack.ArtHouse.Controller.dto.TheatreCategoryDTO;
import SDAIronHack.ArtHouse.Model.Theatre;
import SDAIronHack.ArtHouse.Repository.TheatreRepository;
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
class TheatreControllerTest {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    Theatre theatre;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        theatre = new Theatre(23L,"aaabbbcccddd",10, "Tragedy");
        theatreRepository.save(theatre);

    }
    /*
    @AfterEach
    public void tearDown() {
        Long id = theatreRepository.findTheatreByPlayWright("aaabbbcccddd").get(0).getId();
        theatreRepository.deleteById(id);
    }

     */

    @Test
    void getAllTheatre_validRequest_allTheatre() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Tragedy"));
    }
    @Test
    void getAllTheatre_inValidRequest_notFound() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void getTheatreById_validId_correctTheatre() throws Exception {

        Long id = theatreRepository.findTheatreByPlayWright("aaabbbcccddd").get(0).getId();
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getById/"+id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Tragedy"));
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

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Comedy"));
    }
    @Test
    void getTheatreByPlayWright_inValidPlayWright_notFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByPlayWright/playWright?playWright=nobody"))
                .andExpect(status().isNotFound())
                .andReturn();

    }
    @Test
    void getTheatreByNumberOfActors_validNumberOfActors_correctTheatre() throws Exception  {

        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByNumberOfActors/6"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Comedy"));
    }
    @Test
    void getTheatreByNumberOfActors_inValidNumberOfActors_notFound() throws Exception  {
        MvcResult mvcResult = mockMvc.perform(get("/api/Theatre/getByNumberOfActors/19"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void saveTheatre_validBody_TheatreSaved() throws Exception {
        String body = objectMapper.writeValueAsString(theatre);

        mockMvc.perform(post("/api/Theatre/addTheatre").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(theatreRepository.findAll().toString().contains("William Shakespeare"));
    }
    @Test
    void updateTheatreCategory_validBody_theatreUpdated() throws Exception {

        TheatreCategoryDTO theatreCategoryDTO = new TheatreCategoryDTO("Comedy");
        String body = objectMapper.writeValueAsString(theatreCategoryDTO);

        Long id = theatreRepository.findTheatreByPlayWright("William Shakespeare").get(0).getId();
        mockMvc.perform(patch("/api/Theatre/changeCategory/"+ id).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();

        System.out.println(theatre);
        assertTrue(theatreRepository.findAll().toString().contains("Comedy"));
    }
    @Test
    void deleteTheatre_validRequest_theatreDeleted() throws Exception {
        Long id = theatreRepository.findTheatreByPlayWright("aaabbbcccddd").get(0).getId();

        mockMvc.perform(delete("/api/Theatre/deleteById/"+id))
                .andExpect(status().isAccepted())
                .andReturn();

        assertFalse(theatreRepository.findAll().toString().contains("aaabbbcccddd"));

    }
}