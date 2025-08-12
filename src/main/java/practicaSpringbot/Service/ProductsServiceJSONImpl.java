package practicaSpringbot.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import org.springframework.stereotype.Service;
import practicaSpringbot.domain.Product;

import java.io.IOException;
import java.util.List;

//@Primary                //NOTACION PRIMARY establece cual BEAN se utiliza primero
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductsServiceJSONImpl implements ProductService {


    @Override
    public List<Product> getProducts() {
        //biblioteca JACKSON !
        List<Product> products;              // GENERAMOS UNA NUEVA LISTA

        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});

            return products;

        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
