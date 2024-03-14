package demo.simpleconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		MyPojo pojo = ctx.getBean(MyPojo.class);
        System.out.println(pojo);

        SomeComponent comp = ctx.getBean(SomeComponent.class);
        comp.someOperation();
	}
}
