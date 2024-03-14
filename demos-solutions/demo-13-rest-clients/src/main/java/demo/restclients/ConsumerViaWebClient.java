package demo.restclients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Component("viaWebClient")
public class ConsumerViaWebClient implements Consumer {

	private String baseAddress = "http://localhost:8080/full";

	WebClient client = WebClient.create();

	public void demoGetOne() {

		Mono<Product> productMono = client
				.get()
				.uri(URI.create(baseAddress + "/products/1"))
				.exchangeToMono(r -> {
					System.out.println("\nGot product 1, response details:");
					System.out.printf("  Status code: %d\n", r.statusCode().value());
					return r.bodyToMono(Product.class);
				});

		System.out.printf("  Response body: %s\n", productMono.block());
	}

	public void demoGetAll() {

		ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<>() {};

		List<Product> productListMono = client
				.get()
				.uri(URI.create(baseAddress + "/products"))
				.exchangeToMono(r -> r.bodyToMono(responseType))
				.block();

		System.out.println("\nAll products: ");
		for (Product p : productListMono) {
			System.out.printf("  %s\n", p);
		}
	}

	public void demoInsert() {

		Mono<Product> productMono = client
				.post()
				.uri(URI.create(baseAddress + "/products"))
				.bodyValue(new Product("Lear jet", 15_000_000))
				.exchangeToMono(r -> {
					System.out.println("\nInserted product, response details:");
					System.out.printf("  Status code: %d\n", r.statusCode().value());
					System.out.printf("  Location header: %s\n", r.headers().asHttpHeaders().getLocation());
					return r.bodyToMono(Product.class);
				});

		System.out.printf("  Response body: %s\n", productMono.block());
	}

	public void demoUpdate() {

		Product product1 = client
				.get()
				.uri(URI.create(baseAddress + "/products/1"))
				.exchangeToMono(r -> r.bodyToMono(Product.class))
				.block();

		product1.setPrice(product1.getPrice() * 2);

		client
				.put()
				.uri(URI.create(baseAddress + "/products/1"))
				.bodyValue(product1)
				.exchangeToMono(r -> {
					System.out.println("\nUpdated product 1, response details:");
					System.out.printf("  Status code: %d\n", r.statusCode().value());
					return r.bodyToMono(Product.class);
				})
				.block();
	}

	public void demoDelete() {

		client
				.delete()
				.uri(URI.create(baseAddress + "/products/2"))
				.exchangeToMono(r -> {
					System.out.println("\nDeleted product 2, response details:");
					System.out.printf("  Status code: %d\n", r.statusCode().value());
					return r.bodyToMono(Product.class);
				})
				.block();
	}
}