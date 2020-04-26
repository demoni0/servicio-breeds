package cl.mobdev.prueba.serviciobreeds.service;

import cl.mobdev.prueba.serviciobreeds.models.Breed;
import cl.mobdev.prueba.serviciobreeds.models.Image;

public interface BreedService {

    public String[] getAllSubBreedsByBreed(String breed);

    public Image[] getAllImagesForBreedAndSubBreeds(String breed);

    public Breed getBreed(String breed);
}
