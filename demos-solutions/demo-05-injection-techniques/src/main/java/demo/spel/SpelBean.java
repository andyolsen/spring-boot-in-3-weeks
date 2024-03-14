package demo.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public class SpelBean {

	// Scalar values.
	@Value("#{ 5 * 7.5 }")
	private double workingWeek;
	
	@Value("#{ new java.util.Date() }")
	private Date timestamp;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private int luckyNumber;
	
	// Collection indexing.
	@Value("#{ info.cities[9] }")
	private String city;

	@Value("#{ info.currencies['UK'] }")
	private String currency;
	
	// Collection selections and projections.
	@Value("#{ info.cities.?[startsWith('B')] }")
	private List<String> allBCities;

	@Value("#{ info.cities.^[startsWith('B')] }")
	private String firstBCity;

	@Value("#{ info.cities.$[startsWith('B')] }")
	private String lastBCity;

	@Value("#{ info.cities.![toUpperCase()] }")
	private List<String> upperCities;

	// Using SpEL in autowired methods (also see setUserName() method below).
	private String userName;
	
	@Autowired
	public void setUserName(@Value("#{systemProperties['user.name'] }") String n) {
		this.userName = n;
	}

	// Methods to display the injected values...
	public void displayScalarValues() {
		System.out.printf("\nworkingWeek: %.2f\n", workingWeek);
		System.out.printf("\ntimestamp: %s\n", timestamp);
		System.out.printf("\nluckyNumber: %d\n", luckyNumber);
	}

	public void displayCollectionIndexing() {
		System.out.printf("\nCity: %s\n", city);
		System.out.printf("Currency: %s\n", currency);
	}
	
	public void displayCollectionSelectionProjection() {
		System.out.println("Cities that starts with B:");
		for(String bCity : allBCities) {
			System.out.printf("\t%s\n", bCity);
		}

		System.out.printf("First city that starts with B: %s\n", firstBCity);
		System.out.printf("Last  city that starts with B: %s\n", lastBCity);

		System.out.println("Cities in uppercase:");
		for(String uCity : upperCities) {
			System.out.printf("\t%s\n", uCity);
		}
	}

	public void displayUserName() {
		System.out.printf("\nUser name : %s\n", userName);
	}

	// Bits for end-of-chapter exercise...
	@Value("#{ timestamp.creationDate }")
	private LocalDate localDate;

	@Value("#{ timestamp.creationTime }")
	private LocalTime localTime;

	private String displayTimestampMode;

	@Autowired
	public SpelBean(ApplicationArguments args) {
		if (args.containsOption("displayTimestampMode"))
			displayTimestampMode = args.getOptionValues("displayTimestampMode").get(0);
		else
			displayTimestampMode = "none";
	}

	public void displayDateAndOrTime() {

		if (displayTimestampMode.equals("date") || displayTimestampMode.equals("both"))
			System.out.printf("Creation date: %s\n", localDate);

		if (displayTimestampMode.equals("time") || displayTimestampMode.equals("both"))
			System.out.printf("Creation time: %s\n", localTime);
	}

}
