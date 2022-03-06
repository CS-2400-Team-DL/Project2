package main;
/**
 * Data Nodes used in the the LinkedBag BagInterface. Each node holds two sections.
 * One for data and one for a reference to the next node.
 * @author LeothEcRz
 *
 * @param <T> Type of data the node will store.
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	
	/**
	 * Construction of a node will require at least data for it to store. Will have
	 *  no reference to a next node and will point to null.
	 * @param data - What will be stored on the node.
	 */
	Node(T data){
		this(data, null);
	}
	/**
	 * Construction when given a next a next node will have a next node to reference.
	 * @param next - The node that will be pointed to when this node's next node reference is checked.
	 */
	Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
	/**
	 * Getter method for data of this node.
	 * @return the data store in the node
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Setter method for changing the data store inside a node.
	 * @param newData - The data that will be stored
	 */
	public void setData(T newData) {
		data = newData;
	}
	
	/**
	 * Getter method for the next node reference stored in the node.
	 * @return The node that goes after this node. Nodes without reference return null.
	 */
	public Node<T> getNextNode(){
		return next;
	}
	
	/**
	 * Setter method for the next node reference stored in the node.
	 * @param newNext The node that will instead be pointed to.
	 */
	public void setNextNode(Node<T> newNext) {
		next = newNext;
	}
	
	/**
	 * A method to print the information stored in the node.
	 * Will return a string with the data stored and if the node has a node that goes after it.
	 */
	public String toString() { 
		boolean nextExist = true;
		if (this.next==null) {
			nextExist = false;
		}
		 String output = "[Data: " + data.toString() + " - HasNextNode: " + nextExist + "]";
		 return output;
				 
	 }
	
}
