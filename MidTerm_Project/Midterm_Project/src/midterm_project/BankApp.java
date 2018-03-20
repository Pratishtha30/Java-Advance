package midterm_project;

public class BankApp {

	public static void main(String[] args) throws TransactionException {

		/**
		 * Display welcome page to the user
		 */
		System.out.println("\tWelcome to the Account application\t");

		/**
		 * object "bank" performs all the user interfaces
		 */
		Bank bank = new Bank();
		/**
		 * Displaying the initial balance
		 */
		System.out.println("\nStarting Balances are: ");
		System.out.println();
		bank.showBalance();
		/**
		 * Prompt the user to start the transaction
		 */
		bank.startTransactions();
		/**
		 * Calculate final balance Show rate and fees
		 */
		bank.calculateFinalBalance();

		bank.showRateAndFees();
		/**
		 * Display final balance.
		 */
		System.out.println("\nFinal Balances");
		System.out.println();
		bank.showBalance();
		System.out.println("\nThank you for banking with us!!\n");

	}

}
