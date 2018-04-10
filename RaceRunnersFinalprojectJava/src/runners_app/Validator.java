package runners_app;

import java.util.Scanner;

/**
 * Validates user input.
 * @author pratishtha
 *
 */
public class Validator {

	/**
	 * Validates user input.
	 * @param sc scanner to read line.
	 * @param prompt user to enter choice.
	 * @return s string entered by user.
	 */
	public static String getLine(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine(); // read the whole line
		return s;
	}

	/**
	 * Validates user input.
	 * @param sc scanner to read string.
	 * @param prompt user to enter choice.
	 * @return s string entered by user.
	 */
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read the first string on the line
		sc.nextLine(); // discard the rest of the line
		return s;
	}

	/**
	 * Validates user input for integer value.
	 * @param sc scanner to read.
	 * @param prompt user to enter choice.
	 * @return i integer entered by user.
	 */
	public static int getInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int i = 0;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	/**
	 * Validates user input for integer value.
	 * @param sc scanner to read.
	 * @param prompt prompt user to enter choice.
	 * @param min integer value user can enter.
	 * @param max integer value user can enter.
	 * @return i integer entered by user.
	 */
	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be greater than " + min);
			else if (i > max)
				System.out.println("Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return i;
	}
}
	