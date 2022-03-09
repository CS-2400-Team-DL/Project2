package main;

import java.util.Scanner;

public class LinkedStackTest{
	
	public static void main(String[] args) {
		
		String infix = "a*b/(c-a)+d*e";
		String postfix = LinkedStack.convertToPostFix(infix);
		System.out.print("\ninfix: " + infix + "\npostfix: " + postfix + "\n\n ");

		//User Input Loop
		boolean run = true;
		Scanner input = new Scanner(System.in);
		while (run){
			System.out.println("\nEnter 'exit' or Infix:");
			String postifx1 = input.next();

			if (postifx1.contains("exit")) { 
				run = false;
			} else {
				try {
					System.out.println(LinkedStack.convertToPostFix(postifx1));
				} catch (IllegalArgumentException e) {
					System.out.println("Open Parenthesis Detected");
				}
			}
		}
		input.close();
		System.out.println("Good Bye");
		
	}

	public static String getPostfix(){
		String infix = "a*b/(c-a)+d*e";
		String postfix = LinkedStack.convertToPostFix(infix);
		return postfix;
	}
	
}