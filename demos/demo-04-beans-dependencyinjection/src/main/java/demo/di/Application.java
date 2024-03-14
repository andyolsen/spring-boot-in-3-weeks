package demo.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
		BankService bankService = ctx.getBean(BankService.class);
		bankService.depositIntoAccount(1, 100);
		bankService.withdrawFromAccount(1, 25);

		MyBeanWithValues beanWithValues = ctx.getBean(MyBeanWithValues.class);
		System.out.println(beanWithValues);
	}
}
