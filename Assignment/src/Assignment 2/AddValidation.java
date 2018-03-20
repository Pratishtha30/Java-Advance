package homeWork2;

import java.util.Scanner;

public class AddValidation {

	public static void main(String[] args) {

		System.out.println("Welcome to the Area and Perimeter Calculator \n");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String user_choice = "y";

		while (user_choice.equalsIgnoreCase("y")) {
			// input from the user

			double length = getDoubleValue(sc, "Enter the length: ", 0, 10000);

			double width = getDoubleValue(sc, "Enter the width: ", 0, 10000);

			// calculate area and perimeter

			double area = length * width;
			double perimeter = 2 * (length + width);

			// display results
			System.out.println("Area:	" + area);
			System.out.println("Perimeter:	" + perimeter);

			// check user wants to continue or not
			user_choice = getValidChoice(sc, "Continue? (y/n):", "y", "n");
			System.out.println("");

		}
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

}
