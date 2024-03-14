package demo.restservices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetProductById() {

        ResponseEntity<Product> responseEntity = restTemplate.getForEntity("/full/products/1", Product.class);

        Product responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseBody.getId());
        assertProductValueEquals(responseBody, "Swansea City shirt", 45);
    }

    @Test
    public void testGetProductsWithMinValue() {

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "/full/products?min=300", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {});

        List<Product> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseBody.size());
        assertProductValueEquals(responseBody.get(0), "Carving skis", 350);
        assertProductValueEquals(responseBody.get(1), "Bugatti Divo", 4_000_000);
    }

    @Test
    public void testInsertProduct() {

        Product product = new Product("Bucket hat", 9.99);
        ResponseEntity<Product> responseEntity = restTemplate.postForEntity("/full/products", product, Product.class);

        Product responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("/full/products/5", responseEntity.getHeaders().getLocation().getPath());
        assertEquals(5, responseBody.getId());
        assertProductValueEquals(responseBody, "Bucket hat", 9.99);
    }

    // Etc...

    private void assertProductValueEquals(Product product, String description, double price) {
        assertEquals(product.getDescription(), description);
        assertEquals(product.getPrice(), price);
    }
}
