package cl.mobdev.prueba.serviciobreeds.data.remote.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="${url.name}", url = "${url.servicio}")
public interface BreedClientRest {

    @GetMapping("${url.servicio.all}")
    public String getAllBreeds();

    @GetMapping("${url.servicio.images}")
    public String getAllImagesForBreed(@PathVariable("breed") String breed);
}
