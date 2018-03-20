package homeWork3;

import java.util.Scanner;

public class NumberConverterApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Number to Word Converter.");
		// set up the string arrays
		String[] units = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		String[] tens = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		// the main loop
		do {
			System.out.print("\nEnter the number you want to convert to words: ");
			int num = sc.nextInt();
			sc.nextLine(); // discard the rest of the line
			int onesDigit = num % 10; // get the ones digit
			int tensDigit = (num % 100) / 10; // get the tens digit
			int hundredsDigit = (num % 1000) / 100; // get the hundreds digit
			int thousandsDigit = (num % 10000) / 1000; // get the thousands
														// digit
			String words = "";
			if (thousandsDigit > 0)
				words += units[thousandsDigit - 1] + " thousand ";
			if (hundredsDigit > 0)
				words += units[hundredsDigit - 1] + " hundred ";
			if (tensDigit > 1) // numbers ending in 20 - 99
			{
				words += tens[tensDigit - 2] + " ";
				if (onesDigit > 0)
					words += units[onesDigit - 1];
			} else if (tensDigit == 1) // numbers ending in 10-19
				words += teens[onesDigit];
			else if (tensDigit == 0) // numbers ending in 00 - 09
				if (onesDigit > 0)
					words += units[onesDigit - 1];
			if (num == 0) // all zeros
				words = "zero";
			System.out.println(words + "\n");
		} while (getAnother());
	}

	public static boolean getAnother() {
		System.out.print("Convert another number? (y/n): ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y"))
			return true;
		else
			return false;
	}
}