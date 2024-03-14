package demo.kafka.customobjects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        MyObjectPublisher publisher = context.getBean(MyObjectPublisher.class);
        publisher.sendMessage("key1", new MyData(1, "value1", 1.11));
        publisher.sendMessage("key2", new MyData(2, "value2", 2.22));
        publisher.sendMessage("key3", "This is value 3");
        publisher.sendMessage("key4", "This is value 4");
        publisher.sendMessage("key5", UUID.randomUUID());
        publisher.sendMessage("key6", UUID.randomUUID());
    }
}
