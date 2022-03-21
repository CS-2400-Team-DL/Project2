package main;

import java.util.EmptyStackException;

/**
 * Stack implementation using linked data. A stack is a data structure that has a restriction where
 * only the top entity can be altered. 
 * Last In, First Out. 
 * First In, Last Out.
 * 
 * @param <T> Data type of stack contents.
 */
public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> nodeReference;

	/** 
	 * Default constructor
	 */
	LinkedStack(){
		nodeReference = null;
	}

	@Override
	public void push(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNextNode(nodeReference);
		nodeReference = newNode;
		return;
	}
	
	@Override
	public T pop() {
		if (isEmpty()) { throw new EmptyStackException(); }
		Node<T> topNode =  nodeReference;
		nodeReference = topNode.getNextNode();
		return topNode.getData();
	}

	@Override
	public T peek() {
		if (isEmpty()) { throw new EmptyStackException(); }
		Node<T> topNode =  nodeReference;
		return topNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (nodeReference==null);
	}

	@Override
	public void clear() {
		nodeReference = null;
	}
	
	/**
	 * Algorithm to transform a legal infix notation equation into a postfix equation.
	 * Will ignore any non-math symbols including white space and parse through the given equation.
	 * Unbalanced infix notation will get an {@link IllegalArgumentException}
	 * @param inFix input to be transformed into postfix - should be a balanced equation.
	 * @throws IllegalArgumentException if the infix input does not have all parenthesis closed and is not balanced.
	 * @return A string transformation of the infix input into postfix notation.
	 * @author Leonardo
	 */
 	public final static String convertToPostfix(String inFix) {
		
		String postFix = new String(); // output of algorithm
		LinkedStack<Character> opStack = new LinkedStack<>(); // stack used to hold operators
		int opBalance = 0; // counts down with operators and up with variables/numbers
		Character topOp;
		
		for (int i=0;i<inFix.length();i++) {
			
			Character activeChar = inFix.charAt(i); // parses thought every character in the input string.
			switch (activeChar) { // will accept any character. if it does not exist in the cases it will skip it.
			
				case ')': //Must empty opStack up to opening parenthesis
					try {
						
						topOp = opStack.pop();
						while(topOp != '(') {
							postFix = postFix.concat(topOp.toString());
							topOp = opStack.pop();
						}
					;
					} catch (EmptyStackException e) {
						throw new IllegalArgumentException("No starter parenthesis");
					}
					break;
				case '(':
					opStack.push(activeChar);
					break;
					
				case '^':
					opBalance--;
					opStack.push(activeChar);
					break;
					
				case '*': case '/': case '+': case '-': // All have same instructions to execute
					
					opBalance--;
					while ( !opStack.isEmpty() && (precedenceIndex(activeChar) <= precedenceIndex(opStack.peek())) ) {
						topOp = opStack.pop();
						postFix = postFix.concat(topOp.toString());
					}
					opStack.push(activeChar);
					break;
				
				default: // default case handles separating unexpected input. 
					// adds letter variables to postfix
					if ((activeChar >= 65 && activeChar <= 90) | (activeChar >= 97 && activeChar <= 122)){ 
						postFix = postFix.concat(" " + activeChar.toString());
						opBalance++;

					} else {  
						int j = i;
						boolean isNewNumber = true;
						while ( (j < inFix.length()) && ( (inFix.charAt(j)>= 48) && (inFix.charAt(j)<= 57)) ) { //handles separating numbers from unexpected input ###OPTIONAL###
							if (isNewNumber){ postFix = postFix.concat(" "); } //creates white space before first number
							isNewNumber = false;
							Character nextChar = inFix.charAt(j);
							postFix = postFix.concat(nextChar.toString());
							j++;
						}
						if (!isNewNumber) {
							i = j - 1; 
							opBalance++;
						} // if the while loop is entered i has to be updated by the amount of loops that passed inside
					}
					// if input is not caught in either if or else it is ignored.
					break;
			} // Switch End
		} // End of For Loop

		//Empty OpStack
		if (opBalance != 1){ throw new IllegalArgumentException("Uneven infix"); }
		while (!opStack.isEmpty()) { // empty the opStack top to bottom
			topOp = opStack.pop();
			if (topOp == '(') { throw new IllegalArgumentException("Open Parenthesis");}
			postFix = postFix.concat(topOp.toString());
		}
		
		return postFix;
	} // end of Algorithm
	

	/**
	 * Index of precedence level made from a switch case. 
	 * @param Must either be '^, *, /, +, -, or )' to have a proper precedence value
	 * @return the level of precedence from a given legal math operator
	 * @throw {@link IllegalArgumentException} when an operator not accounted for is encountered.
	 */
	final private static int precedenceIndex(char activeOp) {
		switch (activeOp) {
			case '^':
				return 5; // 1st order
			case '*':
				return 3; // 2nd order
			case '/':
				return 3; // 2nd order
			case '+':
				return 1; // 3rd order
			case '-':
				return 1; // 3rd order
			case'(':
				return 0; // 4th order
			default:
				throw new IllegalArgumentException("Unknown Operator"); 
		}
	}

}

class Node<T>{
	private T data;
	private Node<T> nextNode;

	public Node(T data, Node<T> nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	public Node(T data){
		this(data,null);
	}
	public T getData(){
		return this.data;
	}
	public void setData(T newData){
		this.data = newData;
	}
	public Node<T> getNextNode(){
		return this.nextNode;
	}
	public void setNextNode(Node<T> newNode){
		this.nextNode = newNode;
	}
}
