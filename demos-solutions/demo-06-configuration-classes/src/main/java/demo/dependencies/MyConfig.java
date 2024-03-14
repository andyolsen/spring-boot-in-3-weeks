package demo.dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public DataSource dataSource() {
		System.out.println("********** In MyConfig.dataSource() bean method **********");
		DataSource ds = new DataSource();
		ds.setConnectionString("jdbc:mysql://localhost:3306/mydatabase");
		ds.setMaxPoolSize(16);
		return ds;
	}

	@Bean
	public TransactionManager transactionManager1() {
		System.out.println("********** In MyConfig.transactionManager1() bean method **********");
		TransactionManager txMgr = new TransactionManager();
		txMgr.setDataSource(dataSource());
		return txMgr;
	}

	@Bean
	public TransactionManager transactionManager2() {
		System.out.println("********** In MyConfig.transactionManager2() bean method **********");
		TransactionManager txMgr = new TransactionManager();
		txMgr.setDataSource(dataSource());
		return txMgr;
	}

	@Bean
	public TransactionManager transactionManager3(DataSource ds) {
		System.out.println("********** In MyConfig.transactionManager3() bean method **********");
		TransactionManager txMgr = new TransactionManager();
		txMgr.setDataSource(ds);
		return txMgr;
	}
}
