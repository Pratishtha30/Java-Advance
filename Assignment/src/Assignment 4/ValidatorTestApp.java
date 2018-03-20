package homeWork4;

import java.util.Scanner;

public class ValidatorTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Validator Tester Application");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		MyValidator v = new MyValidator(sc);

		System.out.println("Int Test ");
		
		int i = v.getIntWithRange("Enter an integer between -100 and 100: ", -101, 101);
        
		System.out.println();
		
		System.out.println("Double Test");
		double d = v.getDoubleWithRange("Enter any number between -100 and 100: ", -101, 101);
		System.out.println();
		
		System.out.println("Required String Test");
		String s1 = v.getRequiredString("Enter your email address: ");
		System.out.println();
		
		System.out.println("String Choice Test");
		String s2 = v.getChoiceString("Select one (x/y): ", "x", "y");
		System.out.println();

	}

}
