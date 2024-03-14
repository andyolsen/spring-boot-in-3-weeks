package demo.clientservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.time.LocalTime;

@RestController
public class ClientController {

    @GetMapping("/client/{index}")
    public String getItem(@PathVariable int index){

        String result = getCatalogData(index);
        return String.format("[%s] Item %d %s", LocalTime.now(), index, result);
    }

    private String getCatalogData(int index) {

        URI catalogUri = URI.create("http://localhost:8081/catalog/" + index);
        RestClient client = RestClient.create();

        return client
                .get()
                .uri(catalogUri)
                .retrieve()
                .body(String.class);
    }
}