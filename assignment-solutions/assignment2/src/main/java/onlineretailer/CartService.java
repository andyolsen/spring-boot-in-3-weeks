package onlineretailer;

import java.util.Map;

public interface CartService {
    void addItemToCart(int id, int quantity);
    void removeItemFromCart(int id);
    Map<Integer, Integer> getAllItemsInCart();
    double calculateCartCost();
}
