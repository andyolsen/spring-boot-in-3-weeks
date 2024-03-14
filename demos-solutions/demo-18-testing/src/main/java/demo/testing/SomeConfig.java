package demo.testing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeConfig {

    @Bean
    public SomePojo somePojo() {
        return new SomePojo(42);
    }
}
