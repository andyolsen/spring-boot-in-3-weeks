package demo.kafka.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mykafka")
@CrossOrigin
public class MyRestController {

    @Autowired
    private MyPublisher publisher;

    @GetMapping("/publish")
    public String publish(@RequestParam("value") String value) {
        for (int i = 1; i <= 5; i++) {
            this.publisher.sendMessage("key" + i, value);
        }
        return "Published 5 messages, keys: 1-5, value: " + value;
    }
}