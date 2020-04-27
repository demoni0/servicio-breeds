package cl.mobdev.prueba.serviciobreeds.data.remote.model;

import cl.mobdev.prueba.serviciobreeds.data.remote.api.BreedClientRest;
import cl.mobdev.prueba.serviciobreeds.data.remote.model.response.BreedResponse;
import cl.mobdev.prueba.serviciobreeds.domain.repository.GetAllBreeds;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllBreedImpl implements GetAllBreeds {
    @Autowired
    BreedClientRest breedClientRest;

    @Override
    public String[] getAllSubBreedsByBreed(String breed) {
        String[] subBreeds = null;
        String resultado = this.getAllBreeds();
        if (resultado != null) {
            subBreeds = new Gson().fromJson(resultado, BreedResponse.class).getMessage().get(breed);
        }
        return subBreeds;
    }

    @Override
    public String getAllBreeds() {
        String resultado = breedClientRest.getAllBreeds();
        return resultado;
    }
}
