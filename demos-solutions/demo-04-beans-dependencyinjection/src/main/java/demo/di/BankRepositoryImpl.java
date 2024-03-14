package demo.di;

import org.springframework.stereotype.Repository;

@Repository
public class BankRepositoryImpl implements BankRepository {

	@Override
	public void update(int accountId, double amount) {
		System.out.printf("\tIn BankRepositoryImpl.update(%d, %.2f)\n", accountId, amount);
	}
}
