package runners_app;

/**
 * Manages all the user interaction in the Marathon race runners application.
 * 
 * @author pratishtha
 */
public class MarathonApp {

	public static void main(String[] args) {

		/*
		 * This instance provides all functionalities for Marathon application.
		 */
		Marathon marathon = new Marathon();

		int action = 0;
		String fileName;

		while (action != 5) {
			/*
			 * display the menu showing all the database
			 */
			RunnerDAO runnerDAO = null;
			marathon.displayDBmenu();
			action = marathon.getChoice(1, 5);

			switch (action) {

			case 1:// This case handles Derby Database.
			{
				runnerDAO = new DerbyDBReader();
				marathon.startRace(runnerDAO);
				break;
			}

			case 2: // This case handles XML file.
			{
				fileName = marathon.getFileName(action);
				runnerDAO = new XMLFileReader(fileName);
				marathon.startRace(runnerDAO);
				break;
			}

			case 3: // This case handles TEXT file.
			{
				fileName = marathon.getFileName(action);
				runnerDAO = new TextFileReader(fileName);
				marathon.startRace(runnerDAO);
				break;
			}

			case 4: // This case handles default runners.
			{
				runnerDAO = new DefaultRunnersProvider();
				marathon.startRace(runnerDAO);
				break;

			}

			case 5: // This case handles exit of the user.
			{
				System.out.println("\nThank you for using my Marathon Race Program!! ");
				break;
			}

			}// switch case end

			if (action != 5)
				marathon.waitInput(); // Wait any key to be entered

		} // while loop end
	}// main end
}
