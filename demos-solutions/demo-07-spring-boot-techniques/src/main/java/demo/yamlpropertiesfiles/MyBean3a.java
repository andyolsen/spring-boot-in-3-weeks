package demo.yamlpropertiesfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MyBean3a {

	@Value("${contact.tel}")
	private String tel;
	
	@Value("${contact.email}")
	private String email;

	@Value("${contact.web}")
	private String web;
	
	@Override
	public String toString() {
		return String.format("tel: %s, email: %s, web: %s", tel, email, web );
	}
}