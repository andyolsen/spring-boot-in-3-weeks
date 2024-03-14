package demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes={SomeConfig.class, SomeComponent.class})
public class DemoConfig1_Tests {

    @Autowired
    SomePojo p;

    @Autowired
    SomeComponent c;

    @Test
    public void pojo_correct_value() {
        assertEquals(p.data(), 42);
    }

    @Test
    public void component_correct_value() {
        assertEquals(c.method1(), 99);
    }
}
