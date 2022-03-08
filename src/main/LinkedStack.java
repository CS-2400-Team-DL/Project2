package main;

import java.util.EmptyStackException;

/**
 * 
 *
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> nodeReference;
	private int entryCount;

	/** 
	 * Default constructor for a linked stack.
	 */
	LinkedStack(){
		nodeReference = null;
		entryCount = 0;
	}

	@Override
	public void push(T newEntry) {

		entryCount++;
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNextNode(nodeReference);
		nodeReference = newNode;
		return;
	}
	
	@Override
	public T pop() {
		if (isEmpty()) { throw new EmptyStackException(); }
		entryCount--;
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
		return (entryCount<=0);
	}

	@Override
	public void clear() {
		nodeReference = null;
		entryCount = 0;
	}
	/**
	 * @author Leonardo.
	 * Ignores any none math operator
	 * Will work around white space
	 * expects balanced infix equation.
	 * @param inFix
	 * @return
	 */
	public static String convertToPostFix(String inFix) {
		
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String postFix = new String(); 
		LinkedStack<Character> opStack = new LinkedStack<>();
		Character activeChar, topOp;
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
				if (Character.isDigit(activeChar)) { 
					postFix = postFix.concat(activeChar.toString() + " ");
				} else if (-1 != alpha.indexOf(activeChar)){
					postFix = postFix.concat(activeChar.toString() + " ");
				}
				
				break;
			}
		}
		while (!opStack.isEmpty()) {
			topOp = opStack.pop();
			postFix = postFix.concat(topOp.toString() + " ");
		}
		
		return postFix;
		
	} // end of Algorithm
	
	/**
	 * 
	 * @param activeOp
	 * @return
	 */
	private static int precedenceIndex(char activeOp) {
		switch (activeOp) {
		case '^':
			return 5;
		case '*':
			return 3;
		case '/':
			return 3;
		case '+':
			return 1;
		case '-':
			return 1;
		case'(':
			return 0;
		default:
			throw new IllegalArgumentException("Unknow Operator");
		}
	}
	
}// end of class


