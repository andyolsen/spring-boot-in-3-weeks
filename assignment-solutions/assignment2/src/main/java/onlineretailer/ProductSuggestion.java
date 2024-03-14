package onlineretailer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
	
    private String description;
    private double recommendedPrice;
    private long estimatedAnnualSales;
	
    public ProductSuggestion() {}
    
    public ProductSuggestion(String description, double recommendedPrice, long estimatedAnnualSales) {
    	this.description = description;
    	this.recommendedPrice = recommendedPrice;
    	this.estimatedAnnualSales = estimatedAnnualSales;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRecommendedPrice() {
		return recommendedPrice;
	}

	public void setRecommendedPrice(double recommendedPrice) {
		this.recommendedPrice = recommendedPrice;
	}

	public long getEstimatedAnnualSales() {
		return estimatedAnnualSales;
	}

	public void setEstimatedAnnualSales(long estimatedAnnualSales) {
		this.estimatedAnnualSales = estimatedAnnualSales;
	}

	@Override
	public String toString() {
		return String.format("[%d] %s, recommended price £%.2f, estimated annual sales %d",
				             id, description, recommendedPrice, estimatedAnnualSales);
	}    
}
