package demo.exercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Transcript transcript() {
        return new Transcript(5, false);
    }
}
