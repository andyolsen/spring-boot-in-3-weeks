package onlineretailer;

public class Item {

	private int id;
	private String description;
	private double price;
	
	public Item(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
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
		return String.format("[%02d], %s, £%.2f", id, description, price);
	}
}
