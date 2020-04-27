package cl.mobdev.prueba.serviciobreeds.service;

import cl.mobdev.prueba.serviciobreeds.data.remote.api.BreedClientRest;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.GetAllBreedImpl;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.GetAllImageImpl;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.GetBreedDetailsImpl;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.response.BreedResponse;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.response.ImageResponse;
import cl.mobdev.prueba.serviciobreeds.domain.model.Image;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BreedServiceTest {
        BreedResponse message;
        ImageResponse images;

        @Mock
        private BreedClientRest breedClientRest;

        @InjectMocks
        private GetBreedDetailsImpl breedService;

        @InjectMocks
        private GetAllBreedImpl getAllBreed;

        @InjectMocks
        private GetAllImageImpl getAllImage;

        @Before
        public void setUp() {
            Map<String,String[]> expectedResults = new HashMap<String, String[]>();
            expectedResults.put("bulldog",new String[]{"boston","english","french"});
            expectedResults.put("african",new String[]{});
            message = new BreedResponse();
            message.setMessage(expectedResults);
            message.setStatus("success");

            images = new ImageResponse();
            images.setMessage(new String[]{
                    "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg",
                    "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10452.jpg",
                    "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10596.jpg",
                    "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10604.jpg",
            });
            images.setStatus("success");
        }

        @Test
        public void whenBreedIsBulldogSubBreedsIsNotEmptyTest() {
            String breed = "bulldog";

            given(breedClientRest.getAllBreeds()).willReturn(new Gson().toJson(message));

            String[] subBreeds = getAllBreed.getAllSubBreedsByBreed(breed);

            Assert.assertEquals(3, subBreeds.length);
        }

    @Test
    public void whenBreedIsAfricanSubBreedsIsEmptyTest() {
        String breed = "african";

        given(breedClientRest.getAllBreeds()).willReturn(new Gson().toJson(message));

        String[] subBreeds = getAllBreed.getAllSubBreedsByBreed(breed);

        Assert.assertEquals(0, subBreeds.length);
    }

    @Test
    public void whenBreedIsEmptyImagesIsNullTest() {
        String breed = "";

        given(breedClientRest.getAllImagesForBreed(breed)).willReturn(null);

        Image[] images = getAllImage.getAllImagesForBreedAndSubBreeds(breed);

        Assert.assertNull(images);
    }

    @Test
    public void whenBreedIsValidBreedImagesIsNotNullTest() {
        String breed = "bulldog";

        given(breedClientRest.getAllImagesForBreed(breed)).willReturn(new Gson().toJson(images));

        Image[] images = getAllImage.getAllImagesForBreedAndSubBreeds(breed);

        Assert.assertNotNull(images);
    }
}
