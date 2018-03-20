package midterm_project.validators;

import java.util.Scanner;

public class NumericValidator extends ValidatorBase {

	/**
	 * Constructor to get the scanner from the super class ValidatorBase
	 */
	public NumericValidator(Scanner sc) {
		super(sc);
	}

	/**
	 * @param sc
	 * @param prompt
	 * @return input checks input is Integer
	 */
	public static int getInt(Scanner sc, String prompt) {
		System.out.println(prompt);
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	/**
	 * 
	 * @param sc
	 * @param prompt
	 * @param min
	 * @param max
	 * @return input Checks input is in valid range
	 */

	public static int getIntWithinRange(Scanner sc, String prompt, double min, double max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min);
			} else if (i >= max) {
				System.out.println("Error! Number must be lesser than " + max);
			} else
				isValid = true;
		}
		return i;
	}

	/**
	 * 
	 * @param prompt
	 * @param min
	 * @param max
	 * @return input checks input is Double
	 */
	public double getDouble(Scanner sc, String prompt) {
		System.out.println(prompt);
		String s;
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			s = sc.nextLine();
			/**
			 * Exception handling for the amount when input is 500 fgj"
			 */
			try {
				d = Double.parseDouble(s);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println("Error! Please enter only number. Try again.");
				continue;
			}
		}
		return d;
	}

	/**
	 * 
	 * @param prompt
	 * @param min
	 * @param max
	 * @return user input which is in range {@code min} {@code max}
	 */
	public double getDoubleWithinRange(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d <= min) {
				System.out.println("Error! Number must be greater than " + min);
			} else if (d >= max) {
				System.out.println("Error! Number must be lesser than " + max);
			} else
				isValid = true;
		}
		return d;
	}

}
