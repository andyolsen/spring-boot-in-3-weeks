package demo.restclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        Consumer client = context.getBean("viaWebClient", Consumer.class);

        client.demoGetOne();
        client.demoGetAll();
        client.demoInsert();
        client.demoUpdate();
        client.demoDelete();
    }
}