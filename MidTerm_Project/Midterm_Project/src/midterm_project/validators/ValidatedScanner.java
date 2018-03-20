package midterm_project.validators;

import java.util.Scanner;

public class ValidatedScanner {

	private StringValidator sv;
	private NumericValidator nv;

	/**
	 * new object for string and numeric validation
	 * 
	 * @param sc
	 */
	public ValidatedScanner(Scanner sc) {

		this.sv = new StringValidator(sc);
		this.nv = new NumericValidator(sc);
	}

	/**
	 * 
	 * @param prompt
	 * @param s1
	 * @param s2
	 * @return string after validation
	 */
	public String getChoiceString(String prompt, String s1, String s2) {
		return this.sv.getChoiceString(prompt, s1, s2);
	}

	/**
	 * 
	 * @param prompt
	 * @param min
	 * @param max
	 * @return input double and in range
	 */
	public double getDoubleWithinRange(String prompt, double min, double max) {
		return this.nv.getDoubleWithinRange(prompt, min, max);
	}
}
