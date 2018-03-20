package homeWork1;

import java.util.Scanner;

public class ChangeCalculator {
	public static void main(String[] args) {

		System.out.println("Welcome to the Change Calculator \n");

		Scanner sc = new Scanner(System.in);

		String user_choice = "y";

		while (user_choice.equalsIgnoreCase("y")) {
			// input from the user
			System.out.println("Enter number of cents (0-99): ");
			int total_cents = sc.nextInt();
			// calculate quarters
			int quarters = total_cents / 25;
			total_cents = total_cents % 25;
			// calculate dimes
			int dimes = total_cents / 10;
			total_cents = total_cents % 5;
			// calculate nickels
			int nickles = total_cents / 5;
			// calculate pennies
			int pennies = total_cents % 5;

			// display results
			System.out.println("Quarters:	" + quarters + "\n" + "Dimes:   	" + dimes + "\n" + "Nickles:	" + nickles
					+ "\n" + "Pennies:	" + pennies + "\n");

			// check user wants to continue
			System.out.print("Continue? (y/n): ");
			user_choice = sc.next();
			System.out.println();

		}
	}
}