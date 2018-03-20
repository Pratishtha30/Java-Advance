package midterm_project;
/**
 * Default methods for transactions
 * 
 * @author pratishtha
 *
 */
public interface Transactions {
	/**
	 * 
	 * @param amount Amount for withdrawing
	 * @throws TransactionException
	 */
	void withdraw(double amount) throws TransactionException;

	/**
	 * 
	 * @param amount Amount for Deposit
	 */
	void deposit(double amount);

	/**
	 * This method must performs the necessary calculations to check whether the
	 * specified amount can be withdrawn or not.
	 * @param amount
	 * @return whether {@code amount} can be withdrawn.
	 */
	public boolean canWithdraw(double amount);
}
