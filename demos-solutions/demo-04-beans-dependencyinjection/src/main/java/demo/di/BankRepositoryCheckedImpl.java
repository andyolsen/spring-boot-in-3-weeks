package demo.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepositoryCheckedImpl implements BankRepository {

	@Value("${threshold:1000}")		// Might be overridden in application.properties
	private double threshold;

	@Override
	public void update(int accountId, double amount) {
		if (Math.abs(amount) > threshold) {
			System.out.printf("\tIn BankRepositoryCheckedImpl.update(%d, %.2f) - REJECTED ************ \n", accountId, amount);
		}
		else {
			System.out.printf("\tIn BankRepositoryCheckedImpl.update(%d, %.2f)\n", accountId, amount);
		}
	}
}
