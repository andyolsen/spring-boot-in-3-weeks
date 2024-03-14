package onlineretailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(authz -> authz
                    .requestMatchers("/admin.html").authenticated()
                    .requestMatchers("/**").permitAll()
                    .anyRequest().anonymous()
                )
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
