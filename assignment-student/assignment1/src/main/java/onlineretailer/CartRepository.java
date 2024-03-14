package onlineretailer;

import java.util.Map;

public interface CartRepository {
    void add(int itemId, int quantity);
    void remove(int itemId);
    Map<Integer, Integer> getAll();
}
