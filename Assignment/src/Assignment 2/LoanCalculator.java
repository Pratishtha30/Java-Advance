package homeWork2;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println(" Welcome To Loan Calculator ");
		System.out.println("");

		// create the scanner object
		Scanner sc = new Scanner(System.in);

		String user_choice = "y";

		// get the loan information
		while (user_choice.equalsIgnoreCase("y")) {
			System.out.println("DATA ENTRY");
			System.out.println("");
			double loanAmount = getDoubleValue(sc, "Enter the loan amount: ", 0, 1000000);
			double interestRate = getDoubleValue(sc, "Enter the interest rate: ", 0, 20);
			int years = getIntegerValue(sc, "Enter the number of years: ", 0, 100);
			System.out.println("");

			// calculate monthly loan amount
			double monthlyInterestRate = interestRate / 12 / 100;
			int months = years*12;

			double payment = calculateMonthlyPayment(loanAmount, months, monthlyInterestRate);

			// format the loan amount
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMinimumFractionDigits(1);

			System.out.println("FORMATTED RESULTS");
			System.out.println("Loan Amount:          " + currency.format(loanAmount));
			System.out.println("Yearly interest rate: " + percent.format(interestRate/100));
			System.out.println("Number of years:      " + years);
			System.out.println("Payment:              " + currency.format(payment));
			System.out.println("");
			
			// check user wants to continue or not
						user_choice = getValidChoice(sc, "Continue? (y/n):", "y", "n");
						System.out.println("");

		}

	}

	private static String getValidChoice(Scanner sc, String prompt, String str1, String str2) {
		String str = "";
		boolean isValid = false;
		while (isValid == false) {
			str = checkValidChoice(sc, prompt);
			if (!str.equalsIgnoreCase(str1) && !str.equalsIgnoreCase(str2)) {
				System.out.println("Error! Entry must be '" + str1 + "' or '" + str2 + "'. Try again.");
			} else {
				isValid = true;
			}
		}
		return str;
		
	}

	private static String checkValidChoice(Scanner sc, String prompt) {
		String str = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			str = sc.nextLine();
			if (str.equals("")) {
				System.out.println("Error! This entry is required. Try again.");
			} else {
				isValid = true;
			}
		}
		return str;
	}

	private static double calculateMonthlyPayment(double loanAmount, int months, double monthlyInterestRate) {
		double monthlyPayment =
				loanAmount * monthlyInterestRate/(1 - 1/Math.pow(1 + monthlyInterestRate, months));
				return monthlyPayment;
	}

	

	private static double getDoubleValue(Scanner sc, String prompt, int min, int max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getdouble(sc, prompt);
			if (d <= min) {
				System.out.println("Error! Number must be greater than " + min);
			} else if (d >= max) {
				System.out.println("Error! Number must be lesser than " + max);

			} else
				isValid = true;
		}
		return d;
		
	}

	private static double getdouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine();

		}

		return d;
	}
	private static int getInteger(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine();

		}

		return i;
	}

	private static int getIntegerValue(Scanner sc, String prompt, int min, int max) {

		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInteger(sc, prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min);
			} else if (i >= max) {
				System.out.println("Error! Number must be lesser than " + max);

			} else
				isValid = true;
		}
		return i;
	}
}