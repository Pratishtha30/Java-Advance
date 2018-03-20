package homeWork1;

import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {

		System.out.println("Welcome to the Temperature Converter \n");

		Scanner sc = new Scanner(System.in);

		String user_choice = "y";
		//Integer i = null;

		while (user_choice.equalsIgnoreCase("y")) {
			// input from the user
			System.out.println("Enter degrees in Fahrenheit: ");
			double temp_F = sc.nextDouble();

			double temp_C = (temp_F - 32) * 5 / 9;

			// converting celsius upto 2 decimal
			NumberFormat number = NumberFormat.getNumberInstance();
			number.setMaximumFractionDigits(2);
			String celsius = number.format(temp_C);

			// display results
			System.out.println("Degrees in Celsius: " + celsius);
			System.out.println();

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			user_choice = sc.next();
			System.out.println();
		}
	}
}
