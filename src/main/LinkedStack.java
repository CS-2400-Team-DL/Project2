package main;

import java.util.EmptyStackException;

// Last In - First Out
public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> nodeReference;
	private int entryCount;

	LinkedStack(){
		nodeReference = null;
		entryCount = 0;
	}

	@Override
	public void push(T newEntry) {

		if (newEntry != null) { 
			Node<T> newNode = new Node<T>(newEntry);
			newNode.setNextNode(nodeReference);
			entryCount++;
			nodeReference = newNode;

		} 
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


	
	
}