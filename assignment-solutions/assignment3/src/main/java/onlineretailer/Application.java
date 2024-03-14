package onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        CartServiceImpl service = context.getBean(CartServiceImpl.class);

        System.out.printf("Welcome to Acme retailers (email: %s)\n", service.getContactEmail());

        // Buy an OLED 64in TV.
        service.addItemToCart(2, 1);

        // Buy 5 Virtual Reality HeadSets.
        service.addItemToCart(4, 3);
        service.addItemToCart(4, 2);

        // Get total cost of items in basket so far.
        System.out.println("\nInterim details...");
        System.out.printf("Total cart cost £%.2f, sales tax %.2f, delivery charge £%.2f\n",
                service.calculateCartCost(),
                service.calculateSalesTax(),
                service.calculateDeliveryCharge());

        // Buy an Apple Mac Book Pro.
        service.addItemToCart(0, 1);

        // Get total cost of items now.
        System.out.println("\nDetails after adding Apple Mac Book Pro...");
        System.out.printf("Total cart cost £%.2f, sales tax %.2f, delivery charge £%.2f\n",
                service.calculateCartCost(),
                service.calculateSalesTax(),
                service.calculateDeliveryCharge());

        // Get profile-specific properties.
        ResourcesBean resourcesBean = context.getBean(ResourcesBean.class);
        System.out.println("Profile-specific properties: " + resourcesBean);
    }

    @Bean
    public Map<Integer, Item> catalog() {
        Map<Integer, Item> items = new HashMap<>();
        items.put(0, new Item(0, "Apple Mac Book Pro", 2499.99));
        items.put(1, new Item(1, "32GB San Disk", 15.99));
        items.put(2, new Item(2, "OLED 64in TV", 1800));
        items.put(3, new Item(3, "Wireless Mouse", 10.50));
        items.put(4, new Item(4, "Virtual Reality HeadSet", 200));
        return items;
    }
}
