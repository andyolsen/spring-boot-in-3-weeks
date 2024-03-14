package demo.testing;

import java.util.List;

public interface BARepository {
    List<BankAccountBean> getAll();
    BankAccountBean getById(int id);
    int insert(BankAccountBean acc);
    void update(int id, BankAccountBean acc);
    void delete(int id);
}
