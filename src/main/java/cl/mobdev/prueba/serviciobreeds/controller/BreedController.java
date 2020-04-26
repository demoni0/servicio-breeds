package cl.mobdev.prueba.serviciobreeds.controller;

import cl.mobdev.prueba.serviciobreeds.models.Breed;
import cl.mobdev.prueba.serviciobreeds.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BreedController {

    @Autowired
    private BreedService breedService;

    @GetMapping("/breed/{breed}")
    public ResponseEntity<Breed> getBreed(@PathVariable("breed") String breed){
        Breed breedResponse = breedService.getBreed(breed);
        return new ResponseEntity<Breed>(breedResponse, HttpStatus.OK);
    }
}
