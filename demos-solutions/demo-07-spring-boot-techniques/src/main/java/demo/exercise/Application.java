package demo.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.setProperty("spring.config.name", "financial-transactions");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        FinancialTransactionLogger logger = ctx.getBean(FinancialTransactionLogger.class);
        logger.log(10.50);
        logger.log(42.99);
        logger.log(81.25);
    }
}
