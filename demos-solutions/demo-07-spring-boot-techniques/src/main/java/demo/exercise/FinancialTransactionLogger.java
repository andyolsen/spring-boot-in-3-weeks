package demo.exercise;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@ConfigurationProperties(prefix="txfmt")
public class FinancialTransactionLogger {

    private String currency;
    private String dtformat;

    public void log(double amount) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern(dtformat);
        System.out.printf(
                "[%s] transaction %s %.2f\n",
                LocalDateTime.now().format(f),
                currency,
                amount);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDtformat() {
        return dtformat;
    }

    public void setDtformat(String dtformat) {
        this.dtformat = dtformat;
    }
}