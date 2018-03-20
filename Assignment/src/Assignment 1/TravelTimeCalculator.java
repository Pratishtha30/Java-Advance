package homeWork1;

import java.util.Scanner;

public class TravelTimeCalculator {
	public static void main(String[] args) {

		System.out.println("Welcome to the Travel Time Calculator \n");

		Scanner sc = new Scanner(System.in);

		String user_choice = "y";

		while (user_choice.equalsIgnoreCase("y")) {
			// input from the user
			System.out.println("Enter miles: ");
			double miles = sc.nextDouble();
			System.out.println("Enter miles per hour: ");
			double miles_per_hour = sc.nextDouble();

			// calculate time in hours
			double hours = miles / miles_per_hour;
			// calculate number of minutes
			int minutes = (int) (hours * 60);
			// calculate int value for hour
			int hours_int = minutes / 60;
			minutes = minutes % 60;
			// display the result
			System.out.println("Estimated travel time");
			System.out.println("Hours: " + hours_int);
			System.out.println("Minutes: " + minutes + "\n");
			
			// check user wants to continue
			System.out.print("Continue? (y/n): ");
			user_choice = sc.next();
			System.out.println();

		}

	}
}