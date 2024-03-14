package demo.restclients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("viaRestTemplate")
public class ConsumerViaRestTemplate implements Consumer {

	private String baseAddress = "http://localhost:8080/full";

	RestTemplate template = new RestTemplate();

	public void demoGetOne() {

		try {
			ResponseEntity<Product> response = template.getForEntity(baseAddress + "/products/1", Product.class);

			System.out.println("\nGot product 1, response details:");
			System.out.printf("  Status code: %d\n", response.getStatusCode().value());
			System.out.printf("  Response body: %s\n", response.getBody());
		}
		catch (ResourceAccessException ex) {
			System.out.printf("\nGetting product 1, ResourceAccessException occurred\n");
		}
		catch (RestClientResponseException ex) {
			System.out.printf("\nGetting product 1, RestClientResponseException occurred, status code: %d\n", ex.getStatusCode().value());
		}
	}

	public void demoGetAll() {

		try {
			ResponseEntity<List<Product>> response = template.exchange(
					baseAddress + "/products",
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<>() {
					});

			System.out.println("\nAll products: ");
			for (Product p : response.getBody()) {
				System.out.printf("  %s\n", p);
			}
		}
		catch (ResourceAccessException ex) {
			System.out.printf("\nGetting all products, ResourceAccessException occurred\n");
		}
		catch (RestClientResponseException ex) {
			System.out.printf("\nGetting all products, RestClientResponseException occurred, status code: %d\n", ex.getStatusCode().value());
		}
	}

	public void demoInsert() {

		try {
			ResponseEntity<Product> response = template.postForEntity(
					baseAddress + "/products",
					new Product("Lear jet", 15_000_000),
					Product.class
			);

			System.out.println("\nInserted product, response details:");
			System.out.printf("  Status code: %d\n", response.getStatusCode().value());
			System.out.printf("  Location header: %s\n", response.getHeaders().getLocation());
			System.out.printf("  Response body: %s\n", response.getBody());
		}
		catch (ResourceAccessException ex) {
			System.out.printf("\nInserting product, ResourceAccessException occurred\n");
		}
		catch (RestClientResponseException ex) {
			System.out.printf("\nInserting product, RestClientResponseException occurred, status code: %d\n", ex.getStatusCode().value());
		}
	}

	public void demoUpdate() {

		try {
			Product product1 = template.getForObject(baseAddress + "/products/1", Product.class);
			product1.setPrice(product1.getPrice() * 2);

			template.put(baseAddress + "/products/1", product1);
			System.out.println("\nUpdated product 1");
		}
		catch (ResourceAccessException ex) {
			System.out.printf("\nUpdating product 1, ResourceAccessException occurred\n");
		}
		catch (RestClientResponseException ex) {
			System.out.printf("\nUpdating product 1, RestClientResponseException occurred, status code: %d\n", ex.getStatusCode().value());
		}
	}

	public void demoDelete() {

		try {
			template.delete(baseAddress + "/products/2");
			System.out.println("\nDeleted product 2");
		}
		catch (ResourceAccessException ex) {
			System.out.printf("\nDeleting product 2, ResourceAccessException occurred\n");
		}
		catch (RestClientResponseException ex) {
			System.out.printf("\nDeleting product 2, RestClientResponseException occurred, status code: %d\n", ex.getStatusCode().value());
		}
	}
}