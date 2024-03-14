package demo.techniques;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Configuration
public class MyConfig {

	@Bean(name="cool-bean")
	public MyPojo bean1() {
		return new MyPojo(1111, UUID.randomUUID().toString());
	}

	@Bean(name = {"subsystemA-bean", "subsystemB-bean", "subsystemC-bean"})
	public MyPojo bean2() {
		return new MyPojo(2222, UUID.randomUUID().toString());
	}

	@Bean(name="lazy-bean")
	@Lazy
	public MyPojo bean3() {
		return new MyPojo(3333, UUID.randomUUID().toString());
	}

	@Bean(name="proto-bean")
	@Scope("prototype")
	public MyPojo bean4() {
		return new MyPojo(4444, UUID.randomUUID().toString());
	}
}
