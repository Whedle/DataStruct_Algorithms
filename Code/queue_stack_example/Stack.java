
package queue_stack_example;

/**Interface: Stack
 * @author Wade Hedlesky
 * An interface for a stack. This interface declares the methods isEmpty(), push(..), top(), pop(), and size().
 * 
 * @param <E>
 */
public interface Stack<E> {
	/**
	 * Returns true if the stack is empty and false if the stack is not empty (tests if the top of the stack is null).
	 * @return true if empty, false if not empty.
	 */
	public boolean isEmpty();
	/**
	 * Returns the StackData object at the top of the stack without mutating the stack.
	 * @return top StackData object in the stack.
	 * @exception Exception thrown if the stack is empty.
	 */
	public void push (E elem) throws Exception;
	/**
	 * Remove the top StackData object from the stack.
	 * @return StackData object removed from the stack.
	 * @exception Exception thrown if the stack is empty.
	 */
	public E top() throws Exception;
	/**
	 * Insert a StackData object at the top of the stack.
	 * @param StackData object to be inserted.
	 * @exception Exception thrown if the stack is full.
	 */
	public E pop() throws Exception;
	/**
	 * Returns the number of StackData objects in the stack.
	 * @return the number of StackData objects in the stack.
	 */
	public int size();
}