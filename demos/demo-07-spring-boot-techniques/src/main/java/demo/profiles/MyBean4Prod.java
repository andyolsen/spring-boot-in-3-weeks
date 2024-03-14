package demo.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class MyBean4Prod implements MyBean4 {

	@Override
	public String toString() {
		return "Hello from MyBean4Prod";
	}
}