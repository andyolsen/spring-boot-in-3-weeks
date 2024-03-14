package demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationTests {

    @Test
	public void contextLoads() {
	}

    @Autowired
    BankAccountBean fixture;

    @Test
    public void deposit_singleDeposit_correctBalance() {

        // Act.
        fixture.deposit(100);

        // Assert.
        int expected = 100;
        int actual = fixture.getBalance();
        assertEquals(expected, actual);
    }
}
