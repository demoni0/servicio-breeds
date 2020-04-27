package cl.mobdev.prueba.serviciobreeds.data.remote;

import cl.mobdev.prueba.serviciobreeds.data.remote.api.BreedClientRest;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.ImageResponse;
import cl.mobdev.prueba.serviciobreeds.domain.model.Image;
import cl.mobdev.prueba.serviciobreeds.domain.repository.GetAllImage;
import com.google.gson.Gson;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GetAllImageImpl implements GetAllImage {
    @Autowired
    private BreedClientRest breedClientRest;

    @Override
    public String getAllImagesForBreed(String breed) {
        String resultado = "";
        try {
             resultado = breedClientRest.getAllImagesForBreed(breed);
        } catch (FeignException fex) {
            resultado = null;
        }
        return resultado;
    }
    public Image[] getAllImagesForBreedAndSubBreeds(String breed) {
        Image[] data = null;
        String[] images = null;
        String resultado = this.getAllImagesForBreed(breed);
        if (resultado != null) {
            images = new Gson().fromJson(resultado, ImageResponse.class).getMessage();
            data = Arrays.stream(images)
                    .map(s -> new Image(s.toLowerCase()))
                    .toArray(Image[]::new);
        }
        return data;
    }
}
