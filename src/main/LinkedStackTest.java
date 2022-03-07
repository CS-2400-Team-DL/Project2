package main;

public class LinkedStackTest{
	
	public static void main(String[] args) {
		LinkedStack<String> strStack = new LinkedStack<>();
		strStack.push("Hello");
		strStack.push("World");
		System.out.println(strStack.isEmpty());
		System.out.println(strStack.peek());
		System.out.println(strStack.pop());
		System.out.println(strStack.peek());
		System.out.println(strStack.pop());
		System.out.println(strStack.isEmpty());

	}
	
}