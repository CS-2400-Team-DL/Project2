package main;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T>
{
	/** A class of stacks whose entries are stored in an array. */
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ResizeableArrayStack()
	{
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public ResizeableArrayStack(int initialCapacity)
	{
   integrityOK = false;
   checkCapacity(initialCapacity);
      
   // The cast is safe because the new array contains null entries
   @SuppressWarnings("unchecked")
   T[] tempStack = (T[])new Object[initialCapacity];
   stack = tempStack;
	topIndex = -1;
   integrityOK = true;
   } // end constructor
  

   // Throws an exception if receiving object is not initialized.
   private void checkIntegrity() {
	   if (!integrityOK)
		   throw new SecurityException ("ArrayStack object is corrupt.");
   } // end checkintegrity()

   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity) {
      if (capacity > MAX_CAPACITY)
      throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity

	private void ensureCapacity()
	{
   	if (topIndex >= stack.length - 1) // If array is full, double its size
   	{
      	int newLength = 2 * stack.length;
      	checkCapacity(newLength);
      	stack = Arrays.copyOf(stack, newLength);
   	} // end if
	} // end ensureCapacity


	@Override
	public void push(T newEntry) {
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}


	@Override
	public T pop() {
		checkIntegrity();
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} // end if
	} // end pop


	@Override
	public T peek() {
      checkIntegrity();
      if (isEmpty())
         throw new EmptyStackException();
      else
         return stack[topIndex];
	}


	@Override
	public boolean isEmpty() {
		return topIndex<0;
	}


	@Override
	public void clear() {
      checkIntegrity();
      
      // Remove references to the objects in the stack,
      // but does not deallocate the array
      while (topIndex > -1)
      {
          stack[topIndex] = null;
          topIndex--;
      } // end while
      //Assertion: topIndex is -1
	}
}