package onlineretailer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CartRepositoryImplTests {

    // Just create an instance directly, so it'll be a new instance for each test.
    CartRepositoryImpl repo = new CartRepositoryImpl();

    @Test
    void cart_emptyInitially() {
        int size = repo.getAll().size();
        assertEquals(0, size);
    }

    @Test
    void addItems_itemsAdded() {
        repo.add(1, 100);
        repo.add(2, 200);
        repo.add(3, 300);

        Map<Integer, Integer> result = repo.getAll();
        assertEquals(3, result.size());
        assertEquals(100, result.get(1));
        assertEquals(200, result.get(2));
        assertEquals(300, result.get(3));
    }

    @Test
    void addSameItem_countIncremented() {
        repo.add(1, 100);
        repo.add(2, 200);
        repo.add(2, 300);

        Map<Integer, Integer> result = repo.getAll();
        assertEquals(2, result.size());
        assertEquals(100, result.get(1));
        assertEquals(500, result.get(2));
    }

    @Test
    void removeItem_itemRemoved() {
        repo.add(1, 100);
        repo.add(2, 200);
        repo.add(3, 300);
        repo.remove(1);

        Map<Integer, Integer> result = repo.getAll();
        assertEquals(2, result.size());
        assertEquals(null, result.get(1));
        assertEquals(200, result.get(2));
        assertEquals(300, result.get(3));
    }
}
