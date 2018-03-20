package homeWork1;

import java.util.Scanner;

public class RectangleCalculator {

public static void main(String[] args)
{

System.out.println("Welcome to the Area and Perimeter Calculator \n");

Scanner sc = new Scanner(System.in);

String user_choice = "y";

while(user_choice.equalsIgnoreCase("y")) {
	//input from the user
	System.out.println("Enter the length: ");
	double length = sc.nextDouble();
	System.out.println("Enter the width: ");
	double width = sc.nextDouble();
	
	//calculate area and perimeter
	
	double area = length*width;
	double perimeter = 2*(length+width);
	
	//display results
	System.out.println("Area:	" + area);
	System.out.println("Perimeter:	" + perimeter);
	
	//check user wants to continue or not
	System.out.println("Continue? (y/n):");
	user_choice = sc.next();
	
	}
  }
}
