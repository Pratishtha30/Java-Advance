package midterm_project;

import java.text.NumberFormat;

/**
 * Represents one bank account. Child classes vary based on interest rate and fees. 
 */
public abstract class BankAccount implements Transactions, BankingEntity {

	protected double balance;

	public abstract void calculateFinalBalance();

	public abstract String getPrintableFees();

	/**
	 * Maintains the initial state of the bank account.
	 * 
	 * @param initialBalance
	 *            The initial balance.
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	/**
	 * 
	 * @return current balance.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Makes sure that amount entered by the user for withdraw is in range.
	 * Overridden method from {@link Transaction}.
	 * 
	 * @param amount
	 *            The amount entered by user
	 * @return whether the given {@code amount} be withdrawn.
	 */
	@Override
	public boolean canWithdraw(double amount) {
		return (balance - amount) > Constants.MIN_BALANCE;
	}

	/**
	 * @param amount
	 * The amount entered by user Check for Transaction Exception
	 */
	@Override
	public void withdraw(double amount) throws TransactionException {
		if (!canWithdraw(amount)) {
			throw new TransactionException("Cannot withdraw " + amount + " from existing balance: " + balance);
		}
		balance -= amount;
	}

	/**
	 * @param amount
	 * Deposits the user amount
	 * @return balance
	 */
	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * Prints the balance in the number format.
	 * 
	 * @return format_balance
	 */
	public String getPrintableBalance() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String format_balance = nf.format(balance);
		return format_balance;
	}

	/**
	 * To write the balance in the readable format
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		return "Balance:" + balance + "\n" + "Minimum Balance: " + Constants.MIN_BALANCE + "\n";
	}
}
