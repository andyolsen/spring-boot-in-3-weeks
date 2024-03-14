package demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DemoConfig2_Tests {

    @TestConfiguration
    static class AdditionalConfigJustForTesting {
        @Bean
        public SomePojo somePojoJustForTesting() {
            return new SomePojo(180);
        }
    }

    @Autowired
    SomePojo somePojoJustForTesting;

    @Test
    public void additional_config_is_available() {
        assertEquals(somePojoJustForTesting.data(), 180);
    }

    @Autowired
    SomePojo somePojo;

    @Autowired
    SomeComponent someComponent;

    @Test
    public void regular_config_is_still_available() {
        assertEquals(somePojo.data(), 42);
        assertEquals(someComponent.method1(), 99);
    }
}
