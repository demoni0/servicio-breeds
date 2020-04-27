package cl.mobdev.prueba.serviciobreeds.data.remote.model;

import cl.mobdev.prueba.serviciobreeds.domain.GetBreedDetailsUseCase;
import cl.mobdev.prueba.serviciobreeds.domain.model.Breed;
import cl.mobdev.prueba.serviciobreeds.domain.repository.GetAllBreeds;
import cl.mobdev.prueba.serviciobreeds.domain.repository.GetAllImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetBreedDetailsImpl implements GetBreedDetailsUseCase {

    @Autowired
    private GetAllBreeds getAllBreeds;

    @Autowired
    private GetAllImage getAllImage;

    @Override
    public Breed getBreed(String breed) {
        Breed breedResponse = new Breed();
        breedResponse.setSubBreeds(getAllBreeds.getAllSubBreedsByBreed(breed));
        breedResponse.setImages(getAllImage.getAllImagesForBreedAndSubBreeds(breed));
        breedResponse.setBreed(breed);

        return breedResponse;
    }


}
