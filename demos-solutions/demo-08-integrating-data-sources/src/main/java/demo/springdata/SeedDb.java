package demo.springdata;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SeedDb {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostConstruct
    public void initEmployees() {
		jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "James", 21000, "London");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Marie", 22000, "Edinburgh");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Peter", 23000, "Belfast");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Sally", 24000, "Cardiff");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Peter", 51000, "London");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Berty", 52000, "Edinburgh");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Milly", 53000, "Belfast");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Jayne", 54000, "Cardiff");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Wally", 91000, "London");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Emily", 92000, "Edinburgh");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Tommy", 93000, "Belfast");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Colin", 94000, "Cardiff");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Sarah", 121000, "London");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Darel", 122000, "Edinburgh");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Benji", 123000, "Belfast");
        jdbcTemplate.update("INSERT INTO EMPLOYEES (NAME, SALARY, REGION) VALUES (?, ?, ?)", "Carys", 124000, "Cardiff");
    }

    @PostConstruct
    public void initCars() {
        jdbcTemplate.update("INSERT INTO CARS (REGNUM, MAKE, MODEL) VALUES (?, ?, ?)", "AAA 111", "Bugatti", "Divo");
        jdbcTemplate.update("INSERT INTO CARS (REGNUM, MAKE, MODEL) VALUES (?, ?, ?)", "BBB 222", "Lamborghini", "Sian");
        jdbcTemplate.update("INSERT INTO CARS (REGNUM, MAKE, MODEL) VALUES (?, ?, ?)", "CCC 333", "Volkswagen", "Beetle");
    }
}
