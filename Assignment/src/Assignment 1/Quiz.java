package homeWork1;
import java.util.Scanner;


public class Quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		
		      Scanner sc = new Scanner(System.in);
		      String choice = "y";
		      while (choice.equals("y")) {
		         System.out.print("Enter subtotal:   ");
		         double subtotal = sc.nextDouble();
		         double salesTax = subtotal * .0875;
		         double invoiceTotal = subtotal + salesTax;
		         String message = "Subtotal = " + subtotal + "\n"
		                        + "    Sales tax = " + salesTax + "\n"
		                        + "Invoice total = " + invoiceTotal + "\n\n" ;
		                        System.out.println(message);
		         System.out.print("Continue? Enter y or n: ");
		         choice = sc.next();
		      }
		   }
		}


