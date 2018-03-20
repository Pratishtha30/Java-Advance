package homeWork2;

import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator {

	public static void main(String[] args) {

		// display a welcome message
		System.out.println(" Welcome To Interest Calculator ");

		// create the scanner object
		Scanner sc = new Scanner(System.in);

		String choice = "y";

		// get the loan information
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter the loan amount");
			String loanAmount = sc.next();
			System.out.println("Enter the interest rate");
			String interestRate = sc.next();
			System.out.println("");

			// format interest amount
			BigDecimal loanAmount_BigDecimal = new BigDecimal(loanAmount);
			BigDecimal interestRate_BigDecimal = new BigDecimal(interestRate);
			BigDecimal interest_BigDecimal = loanAmount_BigDecimal.multiply(interestRate_BigDecimal);
			interest_BigDecimal = interest_BigDecimal.setScale(2, RoundingMode.HALF_UP);

			// format the interest rate
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);
			String interestRate_percent = percent.format(interestRate_BigDecimal);

			// format loan amount and interest
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			String loanAmount_currency = currency.format(loanAmount_BigDecimal);
			String interest_currency = currency.format(interest_BigDecimal);

			// display results
			System.out.println("Loan Amount:   " + loanAmount_currency);
			System.out.println("Interest Rate: " + interestRate_percent);
			System.out.println("Interest:      " + interest_currency);

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
}
