package demo.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBeanWithValues {

    @Value("${name}")           // Inject value of "name" application property.
    private String name;   

    @Value("#{ 5 * 7.5 }")      // Inject general Java value using SpEL.
    private double workingWeek;

    @Override
    public String toString() {
        return String.format("Hello from MyBeanWithValues, name %s, working week %.2f", name, workingWeek);
    }
}
