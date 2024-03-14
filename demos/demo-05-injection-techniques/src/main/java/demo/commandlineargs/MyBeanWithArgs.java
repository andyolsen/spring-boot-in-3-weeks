package demo.commandlineargs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyBeanWithArgs {

	@Autowired
	public MyBeanWithArgs(ApplicationArguments args) {
		
		System.out.println("Raw (unprocessed) args");
		for (String sourceArg : args.getSourceArgs()) {
			System.out.println("  " + sourceArg);
		}

		System.out.println("Option names");
		for (String optName : args.getOptionNames()) {
			System.out.println("  " + optName);
		}
		
		System.out.println("Values for 'target' option");
		if (args.containsOption("target")) {
			for (String optValue : args.getOptionValues("target")) {
				System.out.println("  " + optValue);
			}
		}
		
		System.out.println("Non-option args");
		for (String nonOptArg : args.getNonOptionArgs()) {
			System.out.println("  " + nonOptArg);
		}
	}
}
