package demo.restclients;

public class Product {

    private long id;
    private String description;
    private double price;

    public Product() {}

    public Product(String description, double price) {
        this(-1, description, price);
    }

    public Product(long id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s, GBP%.2f", id, description, price);
    }
}
