package midterm_project;

/**
 * Deals with the accounts, fixed deposit, mutual funds etc.
 * 
 * @author pratishtha
 *
 */
public interface BankingEntity {
	/**
	 * 
	 * @return string Well formatted fees with the currency modifier
	 */
	String getPrintableFees();

	/**
	 * 
	 * @return string Well formatted balance with the currency modifier
	 */
	String getPrintableBalance();
}
