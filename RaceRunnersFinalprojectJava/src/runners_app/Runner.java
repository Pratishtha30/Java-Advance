package runners_app;

/**
 * This class sets and gets the fields.
 * 
 * @author pratishtha
 *
 */
public class Runner {

	private String runnerName;
	private int runnerSpeed;
	private int restPercentage;

	/**
	 * Constructor.
	 */
	public Runner() {

	}

	/**
	 * Constructor
	 * 
	 * @param runnerName
	 *            name of runner.
	 * @param runnerSpeed
	 *            speed of the runner.
	 * @param restPercentage
	 *            rest time of the runner.
	 */
	public Runner(String runnerName, int runnerSpeed, int restPercentage) {

		this.runnerName = runnerName;
		this.runnerSpeed = runnerSpeed;
		this.restPercentage = restPercentage;
	}

	/*
	 * getters and setters
	 */

	/**
	 * Set the RunnerName.
	 * 
	 * @return runnerName name of the runner.
	 */
	public String getRunnerName() {
		return runnerName;
	}

	/**
	 * Set the RunnerName.
	 * 
	 * @param runnerName
	 *            name of the runner.
	 */
	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
	}

	/**
	 * Get the RunnerSpeed.
	 * 
	 * @return runnerSpeed speed of the runner.
	 */
	public int getRunnerSpeed() {
		return runnerSpeed;
	}

	/**
	 * Set the RunnerSpeed.
	 * 
	 * @param runnerSpeed
	 *            speed of the runner.
	 */
	public void setRunnerSpeed(int runnerSpeed) {
		this.runnerSpeed = runnerSpeed;
	}

	/**
	 * Get the RestPercentage.
	 * 
	 * @return restPercentage rest time of the runner.
	 */
	public int getRestPercentage() {
		return restPercentage;
	}

	/**
	 * Set the RestPercentage.
	 * 
	 * @param restPercentage
	 *            rest time of the runner.
	 */
	public void setRestPercentage(int restPercentage) {
		this.restPercentage = restPercentage;
	}
@Override
	public String toString(){
		return "RunnerName :" + runnerName + "\n" + "RunnerSpeed :" + runnerSpeed + "\n" + "RestPercentage :" + restPercentage + "\n";
	
	}
}
