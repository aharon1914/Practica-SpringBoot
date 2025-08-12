package practicaSpringbot.Service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import practicaSpringbot.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
@Service()
@ConditionalOnProperty(name = "service.products" , havingValue = "list")
public class ProductsServiceImpl  implements  ProductService{

    public ProductsServiceImpl(){
        System.out.println("Instancia de la clase Products Service IMPL");
    }

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 780.0, 10 ),
            new Product(2, "ThinkPad" , 1000.0, 5),
            new Product(3, "Tablet Samsumg", 1500.0, 8),
            new Product(4, "SmartWatch", 2500.00, 7)

    ));


    @Override
    public List<Product> getProducts() {

        return products;
    }



}
