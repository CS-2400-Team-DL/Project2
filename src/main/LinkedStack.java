package main;

import java.util.EmptyStackException;

/**
 * Stack implenmation using linked data. A stack is a data struture that has a restriction where
 * only the top entity can be altered. 
 * Last In, First Out. 
 * First In, Last Out.
 * @param <T> Data type of stack contents.
 */
public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> nodeReference;

	/** 
	 * Default constructor for a linked stack.
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
	 * @author Leonardo.
	 * Algorithm to transform a legal infix notation equation into a postfix equation.
	 * Will ignore any non-math symbols including white space and parse through the given equation.
	 * @param inFix
	 * @return
	 */
	public static String convertToPostFix(String inFix) {
		
		
		String postFix = new String(); 
		LinkedStack<Character> opStack = new LinkedStack<>();
		Character activeChar, topOp;
		String exceptions = "0123456789abcdefghijklmnopqrstuvwxyz";
		
		for (int i=0;i<inFix.length();i++) {
			activeChar = inFix.charAt(i);
			
			switch (activeChar) {
			
			case ')':
				topOp = opStack.pop();
				while(topOp != '(') {
					postFix = postFix.concat(topOp.toString() + " ");
					topOp = opStack.pop();
				}
				break;
				
			case '(':
				opStack.push(activeChar);
				break;
				
			case '^':
				opStack.push(activeChar);
				break;
				
			case '*':	
			case '/':	
			case '+':				
			case '-':
				
				while (!opStack.isEmpty() && ( LinkedStack.precedenceIndex(activeChar) <= LinkedStack.precedenceIndex(opStack.peek()))) {
					
					postFix = postFix.concat(opStack.pop().toString() + " ");
				}
				opStack.push(activeChar);
				break;
				
			default: // default case handles separating numbers from unexpected input. 
				if (-1 != exceptions.indexOf(activeChar)){ // adds anything to postFix that is part of the exceptions String.
					postFix = postFix.concat(activeChar.toString() + " ");
				}
				
				break;
			} // Switch End
			
		} // End of For Loop
		
		while (!opStack.isEmpty()) {
			topOp = opStack.pop();
			postFix = postFix.concat(topOp.toString() + " ");
		}
		
		return postFix;
		
	} // end of Algorithm
	
	/**
	 * Index of precedence level made from a switch case.
	 * @param Must either be '^, *, /, +, -, or )' to have a proper precedence value
	 * @return the level of precedence from a given legal math operator
	 */
	private static int precedenceIndex(char activeOp) {
		switch (activeOp) {
		case '^':
			return 5; // Highest Precedent
		case '*':
			return 3; // Second Highest
		case '/':
			return 3; // Equal to Second
		case '+':
			return 1; // Low Precendent
		case '-':
			return 1; // Same as above
		case'(':
			return 0; // Lowest precendent
		default:
			throw new IllegalArgumentException("Unknow Operator"); 
		}
	}
	
}// end of class


