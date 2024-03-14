package demo.profiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="apiserver")
public class MyBeanWithValues  {

	private String address;
	private String port;

	@Override
	public String toString() {
		return String.format("apiserver.address: %s, apiserver.port: %s", address, port);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}