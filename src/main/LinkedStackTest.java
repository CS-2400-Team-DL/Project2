package main;

import java.util.Scanner;

/**
 * Test the implementation of the convert to postfix algorithm. Prints both the infix notation and the
 * resulting postfix transformation. Continues into a loop where infix notation will transformed into postfix.
 * Type 'exit' to stop the loop.
 */
public class LinkedStackTest{
	/**
	 * Test the implementation of the convert to postfix algorithm. Prints both the infix notation and the
	 * resulting postfix transformation. Continues into a loop where infix notation will transformed into postfix.
	 * Type 'exit' to stop the loop.
	 * @param args -
	 */
	public static void main(String[] args) {
		
		String infix = "a*b/(c-a)+d*e";
		String postfix = LinkedStack.convertToPostfix(infix);
		System.out.print("\ninfix: " + infix + "\npostfix:" + postfix + "\n\n ");

		//User Input Loop
		boolean run = true;
		Scanner input = new Scanner(System.in);
		while (run){
			System.out.println("\nEnter 'exit' or Infix Equations:");
			String postfix1 = input.nextLine();

			if (postfix1.contains("exit")) { 
				run = false;
			} else {
				try {
					System.out.println(LinkedStack.convertToPostfix(postfix1));
				} catch (IllegalArgumentException e) {
					System.out.println("Infix equation is not legal");
				}
			}
		}
		input.close();
		System.out.println("\n -Good Bye- \n");
	}

	/**
	 * Converts the infix equation from task 1 into postfix.
	 * @return The postfix string of the task 1 infix string.
	 */
	public static String getPostfix(){
		String infix = "a*b/(c-a)+d*e";
		String postfix = LinkedStack.convertToPostfix(infix);
		return postfix;
	}
	
}