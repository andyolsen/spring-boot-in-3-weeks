package demo.dependencies;

public class TransactionManager {

    DataSource dataSource;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
    }

    void beginTransaction() {
        System.out.printf("Begun transaction on DataSource: %s\n", dataSource);
    }

    void endTransaction() {
        System.out.printf("Ended transaction on DataSource: %s\n", dataSource);
    }
}
