package homeWork3;

import java.util.Scanner;

public class DiceApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Paradise Roller application");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = Validator.getString(sc, "Roll the dice? (y/n): ");
		System.out.println();

		int counter = 1;
		while (choice.equalsIgnoreCase("y")) {
			PairOfDice dice = new PairOfDice(6);
			dice.roll();

			System.out.println("Roll " + counter + ": ");
			System.out.println(dice.getValue1());
			System.out.println(dice.getValue2());

			if (dice.getSum() == 2) {
				System.out.println("Snake eyes!");
			} else if (dice.getSum() == 7) {
				System.out.println("Craps!");
			} else if (dice.getSum() == 12) {
				System.out.println("Box cars!");

			}
			System.out.println();

			choice = Validator.getString(sc, "Roll again? (y/n): ");
			System.out.println();
			counter++;
		}
	}

}