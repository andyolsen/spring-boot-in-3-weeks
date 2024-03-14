package demo.exercise;

import demo.simpleconfiguration.SomeComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        MyComponent bean = ctx.getBean(MyComponent.class);
        bean.doSomething();
    }
}
