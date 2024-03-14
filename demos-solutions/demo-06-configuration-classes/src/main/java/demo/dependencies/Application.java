package demo.dependencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		TransactionManager txMgr1 = ctx.getBean("transactionManager1", TransactionManager.class);
        txMgr1.beginTransaction();
        txMgr1.endTransaction();

		TransactionManager txMgr2 = ctx.getBean("transactionManager2", TransactionManager.class);
		txMgr2.beginTransaction();
		txMgr2.endTransaction();

		TransactionManager txMgr3 = ctx.getBean("transactionManager3", TransactionManager.class);
		txMgr3.beginTransaction();
		txMgr3.endTransaction();
	}
}
