package practicaSpringbot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({"/hello", "/hw" , "/AHO"})
    public String helloWorld(){
        System.out.println("Solicitud Ejecutada");
        return  "Hello, World";
    }


}
