package demo.spel;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class Timestamp {

    private LocalDateTime now = LocalDateTime.now();

    public LocalDate creationDate() {
        return now.toLocalDate();
    }

    public LocalTime creationTime() {
        return now.toLocalTime();
    }
}
