package cl.mobdev.prueba.serviciobreeds.domain.repository;

public interface GetAllBreeds {

    public String[] getAllSubBreedsByBreed(String breed);

    public String getAllBreeds();
}
