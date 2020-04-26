package cl.mobdev.prueba.serviciobreeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ServicioBreedsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioBreedsApplication.class, args);
    }

}
