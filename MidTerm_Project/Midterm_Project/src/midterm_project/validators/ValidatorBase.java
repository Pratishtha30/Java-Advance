package midterm_project.validators;

import java.util.Scanner;

/**
 * Represents base for Validation. Child classes vary based on numeric and
 * string input type.
 * 
 * @author pratishtha
 *
 */

public abstract class ValidatorBase {

	protected Scanner sc = null;

	/**
	 * Scanner for the user input
	 * 
	 * @param sc
	 */
	public ValidatorBase(Scanner sc) {
		this.sc = sc;
	}

}
