package mypackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests(authz -> authz
					.requestMatchers("/", "/index", "/login", "/logout").permitAll()
					.anyRequest().authenticated()
				)
				.formLogin(form -> form
					.loginPage("/login")
				)
				.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("andy").password("{noop}thatwouldbetelling").roles("USER").and()
			.withUser("jayne").password("{noop}password1").roles("ADMIN").and()
			.withUser("emily").password("{noop}password2").roles("USER").and()
			.withUser("tom").password("{noop}password3").roles("USER");
	}
}