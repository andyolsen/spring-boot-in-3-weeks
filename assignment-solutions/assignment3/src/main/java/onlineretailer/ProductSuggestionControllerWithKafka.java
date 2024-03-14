package onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/productSuggestions")
@CrossOrigin
@Profile("with-kafka")
public class ProductSuggestionControllerWithKafka {

	@Autowired
	private ProductSuggestionRepository repository;

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	private String topic = "product_suggestions_topic";

	@GetMapping
    public ResponseEntity<Iterable<ProductSuggestion>> getAllProductSuggestions() {
    	Iterable<ProductSuggestion> result = repository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductSuggestion> getProductSuggestion(@PathVariable long id) {

		Optional<ProductSuggestion> optional = repository.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(optional.get());
		}
	}

	@PostMapping
	public ResponseEntity<ProductSuggestion> insertProductSuggestion(@RequestBody ProductSuggestion productSuggestion) {

		productSuggestion = repository.save(productSuggestion);

		kafkaTemplate.send(topic = "product_suggestions_topic", "inserted", productSuggestion.toString());

		URI uri = URI.create("/productSuggestions/" + productSuggestion.getId());
		return ResponseEntity.created(uri).body(productSuggestion);
	}

    @PutMapping("/modifyPrice/{id}")
	public ResponseEntity modifyPrice(@PathVariable long id, @RequestParam double newPrice) {

		if (repository.modifyPrice(newPrice, id) == 0) {
			return ResponseEntity.notFound().build();
		}
    	else {
			String message = String.format("ProductSuggestion ID %d, new price %.2f", id, newPrice);
			kafkaTemplate.send(topic = "product_suggestions_topic", "modifiedPrice", message);

			return ResponseEntity.ok().build();
		}
	}

    @PutMapping("/modifySales/{id}")
	public ResponseEntity modifySales(@PathVariable long id, @RequestParam long newSales) {

		if (repository.modifySales(newSales, id) == 0) {
			return ResponseEntity.notFound().build();
		}
		else {
			String message = String.format("ProductSuggestion ID %d, new sales %d", id, newSales);
			kafkaTemplate.send(topic = "product_suggestions_topic", "modifiedSales", message);

			return ResponseEntity.ok().build();
		}
	}

    @DeleteMapping
	public ResponseEntity deleteAllProductSuggestions() {
    	repository.deleteAll();
		kafkaTemplate.send(topic = "product_suggestions_topic", "deletedAll", "");
		return ResponseEntity.ok().build();
	}
}