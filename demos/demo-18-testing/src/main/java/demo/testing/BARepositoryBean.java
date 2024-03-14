package demo.testing;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BARepositoryBean implements BARepository {

    @Override
    public List<BankAccountBean> getAll() {
        return null;
    }

    @Override
    public BankAccountBean getById(int id) {
        return null;
    }

    @Override
    public int insert(BankAccountBean acc) {
        return 0;
    }

    @Override
    public void update(int id, BankAccountBean acc) {

    }

    @Override
    public void delete(int id) {

    }
}
