package midterm_project;

import java.text.NumberFormat;

/**
 * CheckingAccount is the child class of BankAccount class with the fee and no
 * interest.
 * 
 * @author pratishtha
 *
 */
public class CheckingAccount extends BankAccount {
	/**
	 * Constant values as final
	 * values are not going to change in whole transaction
	 */
	public static final double CHECKING_INITIAL_BALANCE = 1000.00;

	public static final double CHECKING_FEE = 1.00;

	/**
	 * Constructor to set the balance
	 */
	public CheckingAccount() {
		super(CHECKING_INITIAL_BALANCE);
	}

	/**
	 * @return balance calculate balance apply checking fee
	 */
	@Override
	public void calculateFinalBalance() {
		balance -= CHECKING_FEE;
	}

	/**
	 * @return string Well formatted fees with the currency modifier
	 */
	@Override
	public String getPrintableFees() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String s = nf.format(CHECKING_FEE);
		return "Checking Fees: " + s;
	}

	/**
	 * @return string Well formatted balance with the currency modifier
	 */
	public String getPrintableBalance() {
		return "Checking Balance: " + super.getPrintableBalance();
	}

	/**
	 * To write the balance in the readable format
	 * @return string
	 */
	@Override
	public String toString() {
		return super.toString() + "Checking Fee = " + CHECKING_FEE + "\n";
	}

}
