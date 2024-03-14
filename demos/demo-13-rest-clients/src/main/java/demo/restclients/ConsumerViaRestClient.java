package demo.restclients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.net.URI;
import java.util.List;

@Component("viaRestClient")
public class ConsumerViaRestClient implements Consumer {

	private String baseAddress = "http://localhost:8080/full";

	RestClient client = RestClient.create();

	public void demoGetOne() {

		try {
			ResponseEntity<Product> response = client
					.get()
					.uri(URI.create(baseAddress + "/products/1"))
					.retrieve()
					.toEntity(Product.class);

			System.out.printf("\nGot product 1, response details:");
			System.out.printf("  Status code: %d\n", response.getStatusCodeValue());
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
			ResponseEntity<List<Product>> response = client
					.get()
					.uri(URI.create(baseAddress + "/products"))
					.retrieve()
					.toEntity(new ParameterizedTypeReference<>() {
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
			ResponseEntity<Product> response = client
					.post()
					.uri(URI.create(baseAddress + "/products"))
					.body(new Product("Lear jet", 15_000_000))
					.retrieve()
					.toEntity(Product.class);

			System.out.println("\nInserted product, response details:");
			System.out.printf("  Status code: %d\n", response.getStatusCodeValue());
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
			Product product1 = client
					.get()
					.uri(URI.create(baseAddress + "/products/1"))
					.retrieve()
					.body(Product.class);

			product1.setPrice(product1.getPrice() * 2);

			ResponseEntity<Void> response = client
					.put()
					.uri(URI.create(baseAddress + "/products/1"))
					.body(product1)
					.retrieve()
					.toBodilessEntity();

			System.out.println("\nUpdated product, response details:");
			System.out.printf("  Status code: %d\n", response.getStatusCodeValue());
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
			ResponseEntity<Void> response = client
					.delete()
					.uri(URI.create(baseAddress + "/products/2"))
					.retrieve()
					.toBodilessEntity();

			System.out.println("\nDeleted product 2, response details:");
			System.out.printf("  Status code: %d\n", response.getStatusCodeValue());
		}
		catch (ResourceAccessException ex) {
			System.out.printf("\nDeleting product 2, ResourceAccessException occurred\n");
		}
		catch (RestClientResponseException ex) {
			System.out.printf("\nDeleting product 2, RestClientResponseException occurred, status code: %d\n", ex.getStatusCode().value());
		}
	}
}