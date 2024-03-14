package demo.differentpropertiesfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

    @Value("${name}")
    private String name;   

    @Override
    public String toString() {
        return String.format("Hello from MyBean2, name %s", name);
    }
}
