package cl.mobdev.prueba.serviciobreeds.domain.repository;

import cl.mobdev.prueba.serviciobreeds.domain.model.Image;

public interface GetAllImage {

    public String getAllImagesForBreed(String breed);
    public Image[] getAllImagesForBreedAndSubBreeds(String breed);
}
