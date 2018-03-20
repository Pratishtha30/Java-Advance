package homeWork2;

import java.util.Scanner;

public class TableOfPowers {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println(" Welcome to the Squares and Cubes table ");

		System.out.println("");

		// create the scanner object
		Scanner sc = new Scanner(System.in);

		String choice = "y";

		// get the number from user
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter the number: ");
			int number = sc.nextInt();
			System.out.println("");

			// define table
			String table = "";
			table += "Number\tSquared\tCubed\n";
			table += "======================\n";

			for (int i = 1; i <= number; i++) {
				int square = i * i;
				int cube = i * i * i;
				table += i + "\t" + square + "\t" + cube + "\n";
			}

			System.out.println(table);

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
}
