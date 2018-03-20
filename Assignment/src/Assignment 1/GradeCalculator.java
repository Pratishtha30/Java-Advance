package homeWork1;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args)
	{

	System.out.println("Welcome to Grade Converter \n");

	Scanner sc = new Scanner(System.in);

	String user_choice = "y";

	while(user_choice.equalsIgnoreCase("y")) {
		//input from the user
		System.out.println("Enter the numerical grade: ");
		int numerical_grade = sc.nextInt();
		
		String letter_grade = null;
		
		if (numerical_grade > 100){
			System.out .println("Numerical grade: " + numerical_grade + " is invalid\n");
			letter_grade = "Invalid";
			}
			else if (numerical_grade >= 88)
			letter_grade = "A";
			else if (numerical_grade >= 80)
			letter_grade = "B";
			else if (numerical_grade >= 67)
			letter_grade = "C";
			else if (numerical_grade >= 60)
			letter_grade = "D";
			else
			letter_grade = "F";
			// display the result of the conversion
			System.out .println("Letter grade: " + letter_grade + "\n");
			// see if the user wants to continue
			System.out .print("Continue? (y/n): ");
			user_choice = sc.next();
			System.out .println();
		
	}
  }
}
