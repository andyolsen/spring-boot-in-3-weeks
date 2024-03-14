package onlineretailer;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductSuggestionControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    static long id;

    @Test
    @Order(1)
    public void testInsertProductSuggestion() {

        ProductSuggestion ps = new ProductSuggestion("Product AAA", 1.11, 111);

        ResponseEntity<ProductSuggestion> responseEntity = restTemplate.postForEntity(
                "/productSuggestions", ps, ProductSuggestion.class);

        ProductSuggestion responseBody = responseEntity.getBody();
        id = responseBody.getId();

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(-1, responseBody.getId());
        assertEquals("Product AAA", responseBody.getDescription());
        assertEquals(1.11, responseBody.getRecommendedPrice());
        assertEquals(111, responseBody.getEstimatedAnnualSales());
    }

    @Test
    @Order(2)
    public void testGetAllProductSuggestions() {

        ResponseEntity<List<ProductSuggestion>> responseEntity = restTemplate.exchange(
                "/productSuggestions", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductSuggestion>>() {});

        List<ProductSuggestion> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseBody.size());
    }

    @Test
    @Order(3)
    public void testGetProductSuggestion() {

        ProductSuggestion responseBody = restTemplate.getForObject("/productSuggestions/" + id, ProductSuggestion.class);

        assertEquals(id, responseBody.getId());
        assertEquals("Product AAA", responseBody.getDescription());
        assertEquals(1.11, responseBody.getRecommendedPrice());
        assertEquals(111, responseBody.getEstimatedAnnualSales());
    }

    @Test
    @Order(4)
    public void testModifyPrice() {

        restTemplate.put("/productSuggestions/modifyPrice/" + id + "?newPrice=1.99", null);

        ProductSuggestion responseBody = restTemplate.getForObject("/productSuggestions/" + id, ProductSuggestion.class);

        assertEquals(id, responseBody.getId());
        assertEquals("Product AAA", responseBody.getDescription());
        assertEquals(1.99, responseBody.getRecommendedPrice());
        assertEquals(111, responseBody.getEstimatedAnnualSales());
    }

    @Test
    @Order(5)
    public void testModifySales() {

        restTemplate.put("/productSuggestions/modifySales/" + id + "?newSales=199", null);

        ProductSuggestion responseBody = restTemplate.getForObject("/productSuggestions/" + id, ProductSuggestion.class);

        assertEquals(id, responseBody.getId());
        assertEquals("Product AAA", responseBody.getDescription());
        assertEquals(1.99, responseBody.getRecommendedPrice());
        assertEquals(199, responseBody.getEstimatedAnnualSales());
    }

    @Test
    @Order(6)
    public void testDeleteAll() {

        restTemplate.delete("/productSuggestions");

        ResponseEntity<List<ProductSuggestion>> responseEntity = restTemplate.exchange(
                "/productSuggestions", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductSuggestion>>() {});

        List<ProductSuggestion> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(0, responseBody.size());
    }
}
