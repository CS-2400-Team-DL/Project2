package main;

public class LinkedStackTest{
	
	public static void main(String[] args) {
		
		String Infix = "2^(2*7)/1";
		System.out.println(LinkedStack.convertToPostFix(Infix));
		String Infix1 = "2^2*(2*7)/1";
		System.out.println(LinkedStack.convertToPostFix(Infix1));
		String Infix2 = "2^(2*7)*(15+4)";
		System.out.println(LinkedStack.convertToPostFix(Infix2));
		
		
		
		
		

	}
	
}