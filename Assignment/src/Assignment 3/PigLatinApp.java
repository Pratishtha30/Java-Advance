package homeWork3;

import java.util.*;

public class PigLatinApp {

	static Scanner sc = new Scanner(System.in); // get the scanner

	public static void main(String[] args) {
		System.out.println("Welcome to the Pig Latin Translator.");
		do {
			System.out.println("Enter a line to be translated to Pig Latin:");
			String input = sc.nextLine();
			// parse the input into words and translate each word
			if (input.equals("")) {
				System.out.println("You didn't enter anything.");
			} else {
				String[] words = input.split(" ");
				String pigLatin = "";
				for (String word : words)
					pigLatin += translateWord(word.toLowerCase()) + " ";
				System.out.println("\n" + pigLatin);
			}
		} while (getAnother()); // asks if the user wants to enter another line
	}

	public static String translateWord(String word) {
		char c = word.charAt(0);
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			word += "way";
		} else {
			if (c == 'y') {
				word = word.substring(1);
				word += c;
				c = word.charAt(0);
			}
			while (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
				word = word.substring(1);
				word += c;
				c = word.charAt(0);
			}
			word += "ay";
		}
		return word;
	}

	public static boolean getAnother() {
		System.out.print("\nTranslate another line? (y/n): ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("Y"))
			return true;
		else
			return false;
	}
}
