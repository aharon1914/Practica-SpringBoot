package practicaSpringbot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practicaSpringbot.Service.ProductService;
import practicaSpringbot.configuration.ExternalizedConfigurations;
import practicaSpringbot.domain.Product;

import java.util.List;

@RestController
@RequestMapping("/productos")                           //para generar un ENdPoint
public class ProductController {

    // ESTOS ES POLIMOSFISMO DINAMICO
    //ProductService productsService = new ProductsServiceImpl();   //Se crea un nuevo objeto de la clase  ProductsServiceImpl


    // esto es INYECCION de DEPENDENCIAS

    @Autowired
    @Lazy
    private ProductService productsService;

    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;

    @GetMapping
    public ResponseEntity<?> getproducts(){

        System.out.println(externalizedConfigurations.toString());

        List<Product> products = productsService.getProducts();   // mandar a llamar al objeto productService . getProduct

        return  ResponseEntity.ok(products);
    }


}
