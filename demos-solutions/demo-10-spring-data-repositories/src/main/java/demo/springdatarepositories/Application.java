package demo.springdatarepositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        EmployeeService service = context.getBean(EmployeeService.class);
        service.useCustomModifierMethod();
        service.useStandardRepoMethods();
        service.useCustomQueryMethods();
    }
}