package main;

public class LinkedStackTest{
	
	public static void main(String[] args) {
		
		String infix = "a*b/(c-a)+d*e";
		String postfix = LinkedStack.convertToPostFix(infix);
		System.out.println(postfix);
	}
	
}