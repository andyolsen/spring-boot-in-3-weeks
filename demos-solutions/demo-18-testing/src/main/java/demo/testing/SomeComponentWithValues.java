package demo.testing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeComponentWithValues {

    @Value("${name}")
    public String name;

    @Value("${country}")
    public String country;
}
