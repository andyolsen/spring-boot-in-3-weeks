package demo.di;

public interface BankService {
	void depositIntoAccount(int accountId, double amount);
	void withdrawFromAccount(int accountId, double amount);
	void transferFunds(int fromAccountId, int toAccountId, double amount);
}
