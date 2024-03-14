package demo.restservices;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {

    private long nextId = 1;
    private Map<Long, Product> catalog;

    public ProductRepository() {
        catalog = new HashMap<>();
        insert(new Product("Swansea City shirt", 45));
        insert(new Product("Cardiff City shirt", 55));
        insert(new Product("Carving skis", 350));
        insert(new Product("Bugatti Divo", 4_000_000));
    }

    public Collection<Product> getAll() {
        return catalog.values();
    }

    public Product getById(long id) {
        return catalog.get(id);
    }

    public Product insert(Product product) {
        product.setId(nextId++);
        catalog.put(product.getId(), product);
        return product;
    }

    public boolean update(Product product) {
        if (!catalog.containsKey(product.getId())) {
            return false;
        }
        else {
            catalog.put(product.getId(), product);
            return true;
        }
    }

    public boolean delete(long id) {
        if (!catalog.containsKey(id)) {
            return false;
        }
        else {
            catalog.remove(id);
            return true;
        }
    }
}