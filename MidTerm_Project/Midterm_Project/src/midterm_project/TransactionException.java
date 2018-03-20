package midterm_project;

public class TransactionException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * User tries to withdraw more amount from the existing amount .
	 * 
	 * @param arg0
	 */
	public TransactionException(String arg0) {
		super(arg0);
	}

}
