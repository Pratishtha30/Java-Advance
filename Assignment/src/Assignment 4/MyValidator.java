package homeWork4;

import java.util.Scanner;

public class MyValidator extends OOValidator{
	private Scanner sc = null;

	public MyValidator(Scanner sc) {
		super(sc);
		this.sc= sc;
	}
	
	public String getRequiredString(String prompt){
		String s = "";
		boolean isValid = false;
		while(isValid==false){
			System.out.println(prompt);
			s = sc.nextLine();
			if (s==""){
				System.out.println("Error! This entry is required. Try again.");
			}else{
				isValid = true;
			}
		}
		return s;
	}
	
	public String getChoiceString(String prompt, String s1, String s2){
		String s = "";
		boolean isValid = false;
		while(isValid==false){
			s = this.getRequiredString(prompt);
			if(!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)){
				System.out.println("Error! Entry must be '"+
						s1 +"' or '"+ s2 +"'. Try again.");
			}else
				isValid= true;
	}
	return s;
	}

	
	
}
