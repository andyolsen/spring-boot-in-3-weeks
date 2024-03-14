package demo.configurationlocation.main;

import demo.configurationlocation.pojos.MyPojo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages="demo.configurationlocation.config")
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		MyPojo pojo = ctx.getBean(MyPojo.class);
        System.out.println(pojo);

		LocalDateTime ts1 = ctx.getBean("timestamp1", LocalDateTime.class);
		System.out.printf("Timestamp1: %s\n", ts1);

		LocalDateTime ts2 = ctx.getBean("timestamp2", LocalDateTime.class);
		System.out.printf("Timestamp2: %s\n", ts2);
	}

	@Bean
	public LocalDateTime timestamp1() {
		return LocalDateTime.of(1997, 7, 2, 1, 5, 30);
	}

	@Bean
	public LocalDateTime timestamp2() {
		return LocalDateTime.of(1997, 7, 2, 1, 20, 0);
	}
}
