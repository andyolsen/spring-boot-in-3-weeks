package demo.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class MyBean4Dev implements MyBean4 {

	@Override
	public String toString() {
		return "Hello from MyBean4Dev";
	}
}