package demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations={"/test1.properties", "/test2.properties"})
public class DemoProperties1_Tests {

    @Autowired
    SomeComponentWithValues c;

    @Test
    public void component_uses_test_name_from_test_property_file() {
        assertEquals(c.name, "TestNameFromTestPropertiesFile");
    }

    @Test
    public void component_uses_test_country_from_test_property_file() {
        assertEquals(c.country, "TestCountryFromTestPropertiesFile");
    }
}
