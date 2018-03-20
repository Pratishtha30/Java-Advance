package homeWork3;

public class PairOfDice {
	private Dice dice1;
	private Dice dice2;
	
	public PairOfDice(){
		dice1 = new Dice();
		dice2 = new Dice();
	}
	
	public PairOfDice(int sides){
		dice1 = new Dice(sides);
		dice2 = new Dice(sides);
	}

	public void roll(){
		dice1.roll();
		dice2.roll();
	}
	
	public int getValue1(){
		return dice1.getValue();
	}
	
	public int getValue2(){
		return dice2.getValue();
	}
	
	public int getSum(){
		int sum = dice1.getValue() + dice2.getValue();
		return sum;
	}
}
