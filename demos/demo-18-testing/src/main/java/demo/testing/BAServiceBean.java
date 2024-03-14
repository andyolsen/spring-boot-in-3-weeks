	package demo.testing;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Lazy;
    import org.springframework.stereotype.Component;

    @Component
    public class BAServiceBean {

        private BARepository repo;

        @Autowired
        public BAServiceBean(BARepository repo) {
            this.repo = repo;
        }

        public void depositIntoAccount(int id, int amount) {
            BankAccountBean acc = repo.getById(id);
            acc.deposit(amount);
            repo.update(id, acc);
        }
    }
