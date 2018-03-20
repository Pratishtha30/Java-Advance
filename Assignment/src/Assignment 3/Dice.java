package homeWork3;

public class Dice {
	private int sides;
	private int value;
	
	public Dice(){
		this.sides = 6;
		this.value = 1;
		
	}
	
	public Dice(int sides){
		this.sides = sides;
		this.value = 1;
	}
	
	public void roll(){
		value = (int)(Math.random()*sides);
		value ++;
	}
	
	public int getValue(){
		return value;
	}

}
