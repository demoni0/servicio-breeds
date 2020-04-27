package cl.mobdev.prueba.serviciobreeds.domain;

import cl.mobdev.prueba.serviciobreeds.domain.model.Breed;

public interface GetBreedDetailsUseCase {

    public Breed getBreed(String breed);
}
