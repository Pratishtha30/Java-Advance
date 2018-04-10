package runners_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * This class reads the XML file.
 * 
 * @author pratishtha
 *
 */
public class XMLFileReader implements RunnerDAO {

	private Path runnersPath = null;
	private File runnersFile = null;
	private ArrayList<Runner> runners = null;

	/**
	 * @param fileName
	 *            to read XML file.
	 */
	public XMLFileReader(String fileName) {

		// Obtain path object of the file
		runnersPath = Paths.get(fileName);

		// Obtain file object for the path
		runnersFile = runnersPath.toFile();
		runners = new ArrayList<>();
	}

	/**
	 * Returns list of runners from the TEXT file.
	 */
	@Override
	public ArrayList<Runner> getRunners() {

		Runner runner = null;

		XMLInputFactory inputFactory = XMLInputFactory.newFactory();

		try {

			FileReader in = new FileReader(runnersFile);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);

			while (reader.hasNext()) {

				int eventType = reader.getEventType();

				switch (eventType) {

				case XMLStreamConstants.START_ELEMENT:

					String elementName = reader.getLocalName();

					// Name Attribute
					if (elementName.equals("Runner")) {
						runner = new Runner();
						String runnerName = reader.getAttributeValue(0);
						runner.setRunnerName(runnerName);
					}

					// Element RunnersMoveIncrement is the RunnerSpeed
					if (elementName.equals("RunnersMoveIncrement")) {
						String speed = reader.getElementText();
						int runnerSpeed = Integer.parseInt(speed);
						runner.setRunnerSpeed(runnerSpeed);
					}

					// Element RestPercentage
					if (elementName.equals("RestPercentage")) {
						String rest = reader.getElementText();
						int restPercentage = Integer.parseInt(rest);
						runner.setRestPercentage(restPercentage);
					}
					break;

				// Handle the end element
				case XMLStreamConstants.END_ELEMENT:
					elementName = reader.getLocalName();
					if (elementName.equals("Runner")) {

						// Add runner object to ArrayList of runners
						runners.add(runner);
					}
					break;

				default:
					break;
				}

				reader.next();
			}

		} catch (XMLStreamException | FileNotFoundException e) {

			System.out.println(e);
			return null;
		}

		return runners; // Return the list of runners
	}

}
