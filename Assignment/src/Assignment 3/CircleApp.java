package homeWork3;

import java.util.Scanner;

public class CircleApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Circle Tester");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")){
			//get the radius within range
			double radius = Validator.getDoubleWithinRange(sc, "Enter the radius: ", 0, 100);
			//System.out.println(radius);
			Circle circle = new Circle(radius);
			
			//get the circumference and area
			System.out.println("Circumference of Circle is: " + circle.getFormattedCircumference());
			
			System.out.println("Area of Circle is: " + circle.getFormattedArea());
			
			//see if user wants to continue
			System.out.println("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
			
		}
		System.out.println("Goodbye. You created "
				+ Circle.getObjectCount() + " Circle object(s).\n");

	}

}
