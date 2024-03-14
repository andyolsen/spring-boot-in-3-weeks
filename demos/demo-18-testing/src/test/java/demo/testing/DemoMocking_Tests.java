package demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DemoMocking_Tests {

    @MockBean
    private BARepository mockRepo;

    @Autowired
    BAServiceBean service;

    @Test
    public void testDeposit() {
        BankAccountBean acc = new BankAccountBean();
        when(mockRepo.getById(anyInt())).thenReturn(acc);

        service.depositIntoAccount(1234, 100);
        assertEquals(acc.getBalance(), 100);

        verify(mockRepo).getById(eq(1234));
        verify(mockRepo).update(eq(1234), refEq(acc));
    }
}