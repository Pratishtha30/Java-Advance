package Homework5;

import java.util.Scanner;

public class Validator {
	static Scanner sc = new Scanner(System.in);

	public int getStudentCount() {
		int studentCount = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print("\nEnter number of students to enter: ");
			if (sc.hasNextInt()) // make sure the next token is an integer
			{
				studentCount = sc.nextInt(); // discard the entire line if it
												// isn't
				if (studentCount > 0) // make sure it is greater than zero
					isValid = true;
			}
			sc.nextLine(); // discard any remaining data
		}
		return studentCount; // return the studentCount
	}

	public String getString(String prompt) {
		String s = "";
		boolean isValid = false;
		while (!isValid) // loops until user enters a non-blank line
		{
			System.out.print(prompt);
			s = sc.nextLine();
			if (!s.equals(""))
				isValid = true;
		}
		return s;
	}

	public int getScore(String prompt) {
		int score = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				score = sc.nextInt();
				if (score >= 0 && score <= 100)

					isValid = true;
			}
			sc.nextLine(); // discard any remaining data
		}
		return score; // return the score
	}

}
