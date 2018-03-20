package homeWork4;

import java.util.Scanner;

public class OOValidator {
	private Scanner sc = null;
	
	public OOValidator(Scanner sc){
		
		this.sc =sc;
	}
	
	public int getInt(String prompt){
		return Validator.getInt(sc, prompt);
	}
	
	public int getIntWithRange(String prompt, int min, int max){
		return Validator.getIntWithRange(sc, prompt, min, max);
	}
	
	
	public double getDouble(String prompt){
		return Validator.getDouble(sc, prompt);
	}
	
	public double getDoubleWithRange(String prompt, int min, int max){
		return Validator.getDoubleWithRange(sc, prompt, min, max);
	}
	
	
}
