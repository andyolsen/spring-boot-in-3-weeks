package onlineretailer;

import org.junit.jupiter.api.Test;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class CartServiceImplTests {

    @MockBean
    private CartRepository mockRepo;

    @Autowired
    CartServiceImpl service;

    @Test
    void addItemToCart_itemAdded() {
        service.addItemToCart(1, 100);
        verify(mockRepo).add(eq(1), eq(100));
    }

    @Test
    void addUnknownItemToCart_noAction() {
        service.addItemToCart(1234, 100);
        verify(mockRepo, times(0)).add(anyInt(), anyInt());
    }

    @Test
    void removeItemFromCart_itemRemoved() {
        service.removeItemFromCart(1);
        verify(mockRepo).remove(eq(1));
    }

    @Test
    void removeUnknownItemFromCart_noAction() {
        service.removeItemFromCart(1234);
        verify(mockRepo, times(0)).remove(anyInt());
    }

    @Test
    void calculateCartCost_correctCostReturned() {
        Map<Integer, Integer> cart = new HashMap<>();
        cart.put(2, 1);     // OLED 64in TV, 1 @ 1800
        cart.put(3, 2);     // Wireless Mouse, 2 @ 10.50 each
        cart.put(4, 5);     // Virtual Reality Headset, 5 @ 200 each
        when(mockRepo.getAll()).thenReturn(cart);

        double cartCost = service.calculateCartCost();
        assertEquals(2821, cartCost);
    }
}
