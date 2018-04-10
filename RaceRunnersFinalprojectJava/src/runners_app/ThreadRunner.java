package runners_app;

import java.util.Random;

/**
 * This class manages runner as a thread.
 * 
 * @author pratishtha
 *
 */
public class ThreadRunner implements RunnerConstants, Runnable {

	private String runnerName;
	private int runnerSpeed;
	private int restPercentage;

	// Shared by all threads. Set True by the winner
	private static volatile boolean finished;

	private Random rn;
	private int position;

	// For synchronized block. Only one thread can access it.
	private static Object obj = new Object();
	private Thread ct;

	/**
	 * Constructor.
	 * 
	 * @param r
	 *            set the fields for runner
	 */
	public ThreadRunner(Runner r) {

		this.runnerName = r.getRunnerName();
		this.runnerSpeed = r.getRunnerSpeed();
		this.restPercentage = r.getRestPercentage();
		rn = new Random();
		position = 0;
		finished = false;

	}

	/**
	 * Overrides method run from thread Runnable interface. While loop repeats
	 * until the runner has reached 1000 meters. Based on random number the
	 * thread decides whether it should run or rest during each time of loop. If
	 * this random number indicates that the runner should run, the class adds
	 * the speed value. The run method sleeps for 100 milliseconds on each
	 * repetition of the loop. The first runner that reaches 1000 declares
	 * itself as the winner.
	 */
	@Override
	public void run() {
		double random;

		// Returns a reference to the currently executing thread.
		ct = Thread.currentThread();

		ct.setName(runnerName);
		try {
			while (finished == false && position < COURSE_DISTANCE) {
				random = rn.nextInt(100) + 1;// Random number between 1 and 100.

				if (random > restPercentage) {
					position += runnerSpeed;// Move

					if (position < 1000) {

						System.out.printf("%-8s : %5d\n", runnerName, position);

					} else
						break;

				} // end of if
				Thread.sleep(SLEEP_TIME);
			} // end of while

			// Reached 1000
			synchronized (obj) {// Only one thread can access this block.

				if (position >= COURSE_DISTANCE) {

					finished = true; // This thread is winner.
										
					System.out.println("\n");
					System.out.println(runnerName + ": " + COURSE_DISTANCE);

					System.out.println(runnerName + ": I finished!\n");
					Marathon.finished(ct);// Notify other threads.
				} // end if

				else // other than winner
					Thread.sleep(1000);
			}

		} catch (InterruptedException e) { // Interrupted by main thread
			System.out.printf("%-8s : You beat me fair and square.\n", ct.getName());
		}

	}
}
