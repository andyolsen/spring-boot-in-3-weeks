package onlineretailer;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest  // Configures in-mem db, and does JPA-related config only.
class ProductSuggestionRepositoryTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ProductSuggestionRepository repo;

    @Test
    public void testModifyPrice() {
        ProductSuggestion ps = em.persist(new ProductSuggestion("Bermuda short", 50.00, 100));
        long id = ps.getId();

        int rowsAffected = repo.modifyPrice(150, id);
        assertEquals(1, rowsAffected);

        ProductSuggestion productSuggestion = repo.findById(id).get();
        assertEquals(productSuggestion.getRecommendedPrice(), 150);
    }

    @Test
    public void testModifySales() {
        ProductSuggestion ps = em.persist(new ProductSuggestion("Bermuda short", 50.00, 100));
        long id = ps.getId();

        int rowsAffected = repo.modifySales(200, id);
        assertEquals(1, rowsAffected);

        ProductSuggestion productSuggestion = repo.findById(id).get();
        assertEquals(productSuggestion.getEstimatedAnnualSales(), 200);
   }
}
