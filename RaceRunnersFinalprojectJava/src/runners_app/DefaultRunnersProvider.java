package runners_app;

import java.util.ArrayList;

/**
 * This class handles the default runners by implementing RunnerDAO.
 */
public class DefaultRunnersProvider implements RunnerDAO {

	/**
	 * Overriding the method from RunnerDAO interface for default runners.
	 */
	@Override
	public ArrayList<Runner> getRunners() {

		ArrayList<Runner> defaultRunners = new ArrayList<>();
		Runner tortoise = new Runner("Tortoise", 10, 0);
		defaultRunners.add(tortoise);

		Runner hare = new Runner("Hare", 100, 90);
		defaultRunners.add(hare);
		return defaultRunners;
	}
}
