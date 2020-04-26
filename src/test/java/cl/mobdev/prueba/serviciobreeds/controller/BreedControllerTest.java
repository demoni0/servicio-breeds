package cl.mobdev.prueba.serviciobreeds.controller;

import cl.mobdev.prueba.serviciobreeds.models.Breed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.BDDMockito.given;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class BreedControllerTest {

    public Breed breedTest;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BreedController breedController;

    @Before
   public void setUp() {
        breedTest = new Breed();
        breedTest.setBreed("bulldog");
        breedTest.setSubBreeds(null);
        breedTest.setImages(null);
    }

    @Test
    public void getBreedTest200Ok() throws Exception {
        String breed = "bulldog";

        given(breedController.getBreed(breed)).willReturn(new ResponseEntity<Breed>(breedTest, HttpStatus.OK));

        mockMvc.perform(get("/api/breed/"+breed)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBreedIsOKTest() throws Exception {
        String breed = "bulldog";

        given(breedController.getBreed(breed)).willReturn(new ResponseEntity<Breed>(breedTest, HttpStatus.OK));

        mockMvc.perform(get("/api/breed/"+breed)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("breed", is(breed)));
    }

    @Test
    public void getBreedIsNoOKTest() throws Exception {
        String breed = "african";

        given(breedController.getBreed(breed)).willReturn(new ResponseEntity<Breed>(breedTest, HttpStatus.OK));

        mockMvc.perform(get("/api/breed/"+breed)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("breed", not(breed)));
    }

}
