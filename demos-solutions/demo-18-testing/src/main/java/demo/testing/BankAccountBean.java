package demo.testing;

import org.springframework.stereotype.Component;

@Component
public class BankAccountBean {

	private String name;
	private int balance = 0;

	public BankAccountBean() {}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		if (amount > balance)
			throw new IllegalArgumentException("Insufficient funds");
		balance -= amount;
	}

	@Override
	public String toString() {
		return String.format("%s, balance %d", name, balance);
	}
}
