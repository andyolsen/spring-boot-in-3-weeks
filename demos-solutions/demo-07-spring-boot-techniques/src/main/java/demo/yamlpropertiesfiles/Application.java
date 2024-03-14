package demo.yamlpropertiesfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.setProperty("spring.config.name", "app3");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        MyBean3a bean3a = ctx.getBean(MyBean3a.class);
        System.out.println(bean3a);

        MyBean3b bean3b = ctx.getBean(MyBean3b.class);
        System.out.println(bean3b);
    }
}
