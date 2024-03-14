package demo.spel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		SpelBean bean = ctx.getBean(SpelBean.class);
		
		bean.displayScalarValues();
		bean.displayCollectionIndexing();
		bean.displayCollectionSelectionProjection();
		bean.displayUserName();
	}
}
