package cl.mobdev.prueba.serviciobreeds.service.impl;

import cl.mobdev.prueba.serviciobreeds.clients.BreedClientRest;
import cl.mobdev.prueba.serviciobreeds.models.Breed;
import cl.mobdev.prueba.serviciobreeds.models.BreedResponse;
import cl.mobdev.prueba.serviciobreeds.models.Image;
import cl.mobdev.prueba.serviciobreeds.models.ImageResponse;
import cl.mobdev.prueba.serviciobreeds.service.BreedService;
import com.google.gson.*;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private BreedClientRest breedClientRest;

    @Override
    public String[] getAllSubBreedsByBreed(String breed) {
        String[] subBreeds = null;
        String resultado = breedClientRest.getAllBreeds();
        if (resultado != null) {
            subBreeds = new Gson().fromJson(resultado, BreedResponse.class).getMessage().get(breed);
        }
        return subBreeds;
    }

    @Override
    public Image[] getAllImagesForBreedAndSubBreeds(String breed) {
        String[] images = null;
        Image[] data = null;
        try {
            String resultado = breedClientRest.getAllImagesForBreed(breed);
            if (resultado != null) {
                images = new Gson().fromJson(resultado, ImageResponse.class).getMessage();
                data = Arrays.stream(images)
                        .map(s -> new Image(s.toLowerCase()))
                        .toArray(Image[]::new);
            }
            return data;
        } catch (FeignException fex) {
            return null;
        }
    }

    @Override
    public Breed getBreed(String breed) {
        Breed breedResponse = new Breed();
        breedResponse.setSubBreeds(this.getAllSubBreedsByBreed(breed));
        breedResponse.setImages(this.getAllImagesForBreedAndSubBreeds(breed));
        breedResponse.setBreed(breed);

        return breedResponse;
    }


}
