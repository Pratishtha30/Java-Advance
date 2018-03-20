package midterm_project.validators;

import java.util.Scanner;

public class StringValidator extends ValidatorBase {
	/**
	 * Constructor for Scanner
	 */
	public StringValidator(Scanner sc) {
		super(sc);
	}

	/**
	 * 
	 * @param prompt
	 * @return string Checks user entered the required string
	 */
	private String getRequiredString(String prompt) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			s = sc.nextLine();
			if (s.isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}
	/**
	 * 
	 * @param prompt
	 * @param s1
	 * @param s2
	 * @return string Checks user entered the right choice
	 */
	public String getChoiceString(String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while (isValid == false) {
			s = this.getRequiredString(prompt);
			if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
				System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			} else
				isValid = true;
		}
		return s;
	}
}
