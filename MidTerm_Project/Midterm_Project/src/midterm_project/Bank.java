package midterm_project;

import java.util.Scanner;

import midterm_project.validators.ValidatedScanner;

public class Bank {

	Scanner sc = new Scanner(System.in);
	/**
	 * Create fields for checking account and saving account
	 */
	CheckingAccount ca;
	SavingAccount sa;

	/**
	 * Created a Bank constructor which set the fields for checking account and
	 * saving account
	 */
	public Bank() {
		this.ca = new CheckingAccount();
		this.sa = new SavingAccount();

	}

	/**
	 * Prints the initial and final balance for checking account and saving
	 * account
	 */
	public void showBalance() {
		System.out.println(ca.getPrintableBalance());
		System.out.println(sa.getPrintableBalance());
		System.out.println();
	}

	/**
	 * Starts the transaction by creating an object of ValidatedScanner class
	 * which validate the user input. It performs and validate all the user
	 * inputs.
	 */
	public void startTransactions() {

		// Making a new object of ValidatedScanner
		ValidatedScanner vs = new ValidatedScanner(sc);

		String str = "y"; // Initiating string with a yes response

		// Continue while loop until user provides no as an input.
		while (str.equalsIgnoreCase("y")) {

			// Prompt user for withdrawal or deposit and validate the input
			String trans_type = vs.getChoiceString("Withdrawal or deposit? (w/d):", "w", "d");

			// Prompt user for checking or savings and validate the input
			String account_type = vs.getChoiceString("Checking or savings? (c/s):", "c", "s");

			// Prompt user for amount and validate the input
			double amount = vs.getDoubleWithinRange("Amount?", Constants.MIN_TRANSACTION_LIMIT,
					Constants.MAX_TRANSACTION_LIMIT);
			/**
			 * Checking for Transaction Exception for the withdraw. Check the
			 * withdraw amount is not less than the set limit for bank account.
			 */
			if (trans_type.equals("w") && account_type.equals("c")) {
				try {
					ca.withdraw(amount);
				} catch (TransactionException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (trans_type.equals("w") && account_type.equals("s")) {
				try {
					sa.withdraw(amount);
				} catch (TransactionException e) {
					System.out.println(e.getMessage());
					continue;
				}
				/*
				 * Deposit amount is already validated
				 */
			} else if (trans_type.equals("d") && account_type.equals("c")) {
				ca.deposit(amount);
			} else if (trans_type.equals("d") && account_type.equals("s")) {
				sa.deposit(amount);
			}
			// prompt user whether he wants to continue or not
			str = vs.getChoiceString("Continue? (y/n):", "y", "n");
		} // end while loop
	}

	/**
	 * Calculate the final balance after the user is done with the transactions.
	 */
	public void calculateFinalBalance() {
		ca.calculateFinalBalance();
		sa.calculateFinalBalance();
	}

	/**
	 * Calculate and show the rate and fees applied for checking account and
	 * saving account.
	 */

	public void showRateAndFees() {
		System.out.println("\nMonthly Payments and Fees");
		System.out.println(ca.getPrintableFees());
		System.out.println(sa.getPrintableFees());

	}
}
