package midterm_project;

import java.text.NumberFormat;

/**
 * SavingAccount is the child class of BankAccount class with interest and no
 * fee.
 * 
 * @author pratishtha
 *
 */
public class SavingAccount extends BankAccount {
	/**
	 * Constant values as final values are not going to change in whole
	 * transaction
	 */
	private static final double SAVING_INITIAL_BALANCE = 1000.00;

	private static final double SAVING_INTEREST_RATE = 0.01;

	private double interest = 0.00;

	/**
	 * Constructor to set the balance
	 */
	public SavingAccount() {
		super(SAVING_INITIAL_BALANCE);
	}

	/**
	 * 
	 * @return interest Interest amount on the savings
	 */
	private double getInterest() {
		return interest;
	}

	/**
	 * 
	 * @return interest Calculate the interest
	 */
	private double calculateInterest() {
		interest = balance * SAVING_INTEREST_RATE;
		return interest;
	}

	/**
	 * @return balance calculate balance adds interest
	 */
	public void calculateFinalBalance() {
		balance += calculateInterest();
	}

	/**
	 * @return string Well formatted fees with the currency modifier
	 */
	public String getPrintableFees() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String s = nf.format(getInterest());
		return "Savings Interest Payment: " + s;
	}

	/**
	 * Prints the saving balance.
	 */
	public String getPrintableBalance() {
		return "Savings Balance : " + super.getPrintableBalance();
	}

	/**
	 * To write the balance in the readable format
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		return super.toString() + "Savings Interest = " + interest + "\n";
	}

}
