package practicaSpringbot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import practicaSpringbot.domain.Customer;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
        //Practica creacion de lista
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Aaron Gonzalez","Agonzalez", "pass123","Robles"),
            new Customer(456, "Sara Lopez", "Salopez", "pass456","Manzanarez"),
            new Customer(789, "Maite Gonzalez","Maigonza", "pass789","Rojas"),
            new Customer(1011,"Eithan Lopez", "Eilopez","pass1011", "Sanchez")
    ));


    //@GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>>  getCustomers() {
        return ResponseEntity.ok(customers);

    }

    //mostrar solo un cliente
    @GetMapping("/{userName}")
    //@RequestMapping(value = "/{userName}" , method = RequestMethod.GET)   // Utilizar un signo de interrogacion la respuesta puede variar
    public ResponseEntity<?> getCliente(@PathVariable String userName){              //El enbellezador del PathVariable es
        for (Customer c : customers){
            if (c.getUserName().equalsIgnoreCase(userName)){
                return ResponseEntity.ok(c);
                //return c;
            }
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con userName : " + userName);  // PROGRAMAR CODIGO DE RESPUESTA 404

    }

    //metodo el cual permite agregar un nuevo cliente
    //@PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>  postCliente(@RequestBody Customer customer){  //de esta manera se agregara a la lista
        customers.add(customer);

        URI location = ServletUriComponentsBuilder                                                                         // Crear una URI para enviar la solicitud POST
                .fromCurrentRequest()
                .path("/{userName}") // como se consume la API
                .buildAndExpand(customer.getUserName())
                .toUri();

        return ResponseEntity.created(location).body(customer);                                                             //Otra forma de mandar a imprimer la variable que se utiliza customer

                                                                                                                            // Con esto devolvemos la URI para poder consumir el recurso
                                                                                                                            //return ResponseEntity.created(location).build();
                                                                                                                            //return ResponseEntity.status(HttpStatus.CREATED).body("Se modifica el userName :" + customer.getUserName());
                                                                                                                            //return customer;


    }

    //@PutMapping
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?>  putCliente(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
                //return c; // FORMA DE RETORNAR CON METODO RESPONSEENTITY.
            }
        }
        return ResponseEntity.notFound().build();
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado :" + customer.getName());
        //return null;
    }

    //@DeleteMapping("/{id}")
    @RequestMapping(value = ("/{id}"), method = RequestMethod.DELETE)
    public ResponseEntity<?>  deleteCliente(@PathVariable int id){
        for (Customer c : customers){
            if (c.getId() == id){
                customers.remove(c);

                return ResponseEntity.noContent().build();
                //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("EL cliente eliminado ha sido : " + id);       // FORMA PARA RETURNAR CON REPSONSEENTITY.
                //return c; REGRESAR CODIGO DE RESPUESTA 204 PARA RESPUESTA EXITOSA SIN CONTENIDO
            }
        }

        return ResponseEntity.notFound().build();                                                                        // FORMA DE ejemplificar el return
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado : " + id);
        //return null;
    }

    //@PatchMapping
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getId() == customer.getId()){

                if (customer.getName() != null){
                    c.setName(customer.getName());
                }
                if (customer.getUserName() != null){
                    c.setUserName(customer.getUserName());
                }
                if (customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + customer.getId());
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CLiente no encontrado con ID :" + customer.getId());
        //return null;
    }

}
