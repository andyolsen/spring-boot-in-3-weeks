package demo.configurationlocation.config;

import demo.configurationlocation.pojos.MyPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public MyPojo myPojo() {
		MyPojo b = new MyPojo();
		b.setField1(42);
		b.setField2("wibble");
		return b;
	}
}
