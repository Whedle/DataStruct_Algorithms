
package queue_stack_example;

import exceptions_example.EmptyStackException;
import exceptions_example.FullStackException;

/**Class: StackUsingArray
 * @author - Wade Hedlesky
 * This class implements the stack interface and uses an array instead of a linked list.
 * 
 * @param <E>
 * 
 * Imports:		exceptions_example.EmptyStackException
 * 				exceptions_example.FullStackException
 */
public class StackUsingArray<E> implements Stack<E> {
	protected int cap;
	public static final int CAPACITY = 1000;
	protected E stack[];
	protected int top = -1;
	
	// Constructor_default
	public StackUsingArray()
	{
		this(CAPACITY);
	}
	
	/**
	 * Constructor for StackUsingArray. Sets cap = con_cap and set stack to a new array of length cap and type E.
	 * @param con_cap
	 */
	@SuppressWarnings("unchecked")
	public StackUsingArray(int con_cap)
	{
		cap = con_cap;
		// Eclipse may throw a warning here, but this is to due possible implementation problems during code reuse.
		// Be sure to implement objects such that they can be placed in stack securely, or alternatively, use a linked list
		// based stack in actual practice.
		stack = (E[]) new Object [cap];
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	// Mutates stack by adding a node to the top of the stack.
	public void push(E elem) throws FullStackException
	{
		if(size()==cap)
			throw new FullStackException("Stack is full.");
		stack[++top] = elem;
	}
	
	public E top() throws EmptyStackException
	{
		if(isEmpty())
			throw new EmptyStackException("Cannot access empty stack");
		return stack[top];
	}
	
	public E pop() throws EmptyStackException
	{
		E data;
		if(isEmpty())
			throw new EmptyStackException("Cannot access empty stack");
		data = stack[top--];
		return data;
	}
	
	public int size() {
		return (top + 1);
	}
}
