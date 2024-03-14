package demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties={"name=ThisTestName", "country=ThisTestCountry"})
public class DemoProperties2_Tests {

    @Autowired
    SomeComponentWithValues c;

    @Test
    public void component_uses_test_name() {
        assertEquals(c.name, "ThisTestName");
    }

    @Test
    public void component_uses_test_country() {
        assertEquals(c.country, "ThisTestCountry");
    }
}
