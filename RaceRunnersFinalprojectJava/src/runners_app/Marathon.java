package runners_app;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains all the methods required for the Marathon race runner
 * application.
 * 
 * @author pratishtha
 *
 */
public class Marathon {

	// To store all the runner threads.
	private static ArrayList<Thread> threads = new ArrayList<>();

	private static ArrayList<Runner> runners; // To handle databases.

	private static Scanner input = new Scanner(System.in);

	public Marathon() {

	}

	/*
	 * This method displays the menu of the databases.
	 */
	public void displayDBmenu() {
		String s = "Welcome to the Marathon Race Runner Program\n\n" + "Select your data source:\n"
				+ "1. Derby database\n" + "2. XML file\n" + "3. Text file\n" + "4. Default two runners\n" + "5. Exit\n";
		System.out.println(s);

	}

	/**
	 * This method prompt the user for input and checks for validation.
	 * 
	 * @param min
	 *            number of choice user can enter.
	 * @param max
	 *            number of choice user can enter.
	 * @return valid choice
	 */
	public int getChoice(int min, int max) {
		int choice = Validator.getInt(input, "Enter your choice: ", min, max);
		return choice;

	}

	/**
	 * According to the action of the user This method prompt the user to enter
	 * the filename for txt and xml files.
	 * 
	 * @param choice
	 *            for the filename.
	 * @return true for the valid filename.
	 */
	public String getFileName(int choice) {

		String fileName = null;

		while (true) {

			if (choice == 2) {// Handles XML file.
				fileName = Validator.getString(input, "Enter XML file name: ");

				if (Files.exists(Paths.get(fileName)) && fileName.contains("xml")) {
					break;

				} else {
					System.out.println("Error! File not found.");
					continue;
				}

			} else if (choice == 3) {// Handles TEXT file.
				fileName = Validator.getString(input, "Enter TEXT file name: ");

				if (Files.exists(Paths.get(fileName)) && fileName.contains("txt")) {
					break;

				} else {
					System.out.println("Error! File not found.");
					continue;
				}
			}

		}
		return fileName;

	}

	/**
	 * This method gets runners from the selected data source. Creates a new
	 * thread for each runner. Maintains thread in a arrayList. start each
	 * thread.
	 * Checks and Ignores invalid data in data source files.
	 * @param runnerDAO
	 *            manages data from all the data sources.
	 */
	public void startRace(RunnerDAO runnerDAO) {

		System.out.println("\nGet Set Go....");
		System.out.println();

		Thread t = null;

		// Gets runners from selected data source.
		runners = runnerDAO.getRunners();
		Runner r = null;

		for (int i = 0; i < runners.size(); i++) {

			// Creating a new thread for each runner.
			r = runners.get(i);
			
			if( r == null){
				System.out.println("error");
				continue;
			}


			// Checking for invalid values in data source files
			if (r.getRunnerName().trim().isEmpty()) {
				System.out.println("Ignoring Runner with empty name\n");
				// r.setRunnerName("unnamedRunner " + i);//(set default value)
				continue;
			}

			if (r.getRunnerSpeed() < 0 || r.getRunnerSpeed() > 1000) {
				System.out.println("Ignoring Runner with invalid Runner Speed\n" + r.toString() + "\n");
				continue;
			}

			if (r.getRestPercentage() < 0 || r.getRestPercentage() > 100) {
				System.out.println("Ignoring Runner with invalid Rest Percentage\n" + r.toString() + "\n");
				continue;
			}
			
			
			t = new Thread(new ThreadRunner(r));
			threads.add(t);

			t.start();// Start each thread.

		}

		for (int j = 0; j < threads.size(); j++) {

			try {
				threads.get(j).join();//Main thread waits until all thread finish their execution.

			} catch (InterruptedException e) {
				System.out.println("ERROR: Thread was interrupted");
			}
		}
		runners.clear();

	}

	/**
	 * Wait for the user to press enter key to continue further.
	 */
	public void waitInput() {
		System.out.println();
		System.out.println("Press enter key to continue");
		while (true) {
			if (input.hasNextLine())
				input.nextLine();
			break;
		}

	}

	/**
	 * This method is synchronized so that only one thread enter at a time.
	 * Declares winner. Interrupts rest of the thread.
	 * 
	 * @param winner
	 *            thread access this function.
	 */
	public static synchronized void finished(Thread winner) {

		// Display winner.
		System.out.println("The race is over! The " + winner.getName() + " is the winner.");
		System.out.println();

		// Interrupt rest of the threads.
		for (int j = 0; j < threads.size(); j++) {

			if (!winner.getName().equals(threads.get(j).getName()))
				threads.get(j).interrupt();

		}

	}
}
