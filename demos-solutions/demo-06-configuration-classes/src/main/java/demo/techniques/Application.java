package demo.techniques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// Lookup 1st bean via its name.
		MyPojo ref1 = ctx.getBean("cool-bean", MyPojo.class);
		System.out.println(ref1);

		// Lookup 2nd bean via its various aliases.
		MyPojo ref2a = ctx.getBean("subsystemA-bean", MyPojo.class);
		MyPojo ref2b = ctx.getBean("subsystemB-bean", MyPojo.class);
		MyPojo ref2c = ctx.getBean("subsystemC-bean", MyPojo.class);
		System.out.println(ref2a);
		System.out.println(ref2b);
		System.out.println(ref2c);

		// Lookup 3rd bean (lazy), Spring Boot creates bean JIT.
		MyPojo ref3 = ctx.getBean("lazy-bean", MyPojo.class);
		System.out.println(ref3);

		// Lookup 4th bean (prototype), get a new bean every time.
		MyPojo ref4a = ctx.getBean("proto-bean", MyPojo.class);
		MyPojo ref4b = ctx.getBean("proto-bean", MyPojo.class);
		MyPojo ref4c = ctx.getBean("proto-bean", MyPojo.class);
		System.out.println(ref4a);
		System.out.println(ref4b);
		System.out.println(ref4c);
	}
}
