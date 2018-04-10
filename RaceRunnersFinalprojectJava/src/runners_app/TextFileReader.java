package runners_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class reads from the TEXT file.
 * @author pratishtha
 *
 */
public class TextFileReader implements RunnerDAO {

	private Path runnersPath = null;
	private File runnersFile = null;
	private ArrayList<Runner> runners = null;

	/**
	 * @param fileName from user for TEXT, XML files path.
	 */
	public TextFileReader(String fileName) {

		// Obtain path object of the file
		runnersPath = Paths.get(fileName);

		// Obtain file object for the path
		runnersFile = runnersPath.toFile();
		runners = this.getRunners();
	}

	/**
	 * Returns list of runners from the TEXT file.
	 */
	@Override
	public ArrayList<Runner> getRunners() {

		// Read from text file and connect input stream to the file.
		try (BufferedReader in = new BufferedReader(new FileReader(runnersFile))) {
			
			runners = new ArrayList<>();
			
			String line = in.readLine();
						
			
			// Read the file until EOF.
			while (line != null) {
				
				//if any line is empty then read next line
				if(line.isEmpty()){
					line = in.readLine();
				}

				String columns[] = line.split("\t+");

				//System.out.println(columns.length);
				String runnerName = columns[0];// Stores runnerName.

				String speed = columns[1];
				
				// Runner speed column converted from a String to an integer
				// value.
				int runnerSpeed = Integer.parseInt(speed);

				String rest = columns[2];

				// Rest percentage column converted from a String to an integer
				// value.
				int restPercentage = Integer.parseInt(rest);

				// Create a runner object.
				Runner runner = new Runner(runnerName, runnerSpeed, restPercentage);

				runners.add(runner);// Add to the Runners list

				line = in.readLine();// Read the next line in the file
			} // end while

		} catch (IOException e) {

			System.out.println(e);
			return null;
		}

		return runners;// Return list of runners.
	}

}
