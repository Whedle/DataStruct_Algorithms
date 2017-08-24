
package queue_stack_example;

/**Class: StackUsingList
 * @author Wade Hedlesky
 * This class implements the Stack interface and uses a linked list to create a stack.
 * 
 * @param <E>
 */
public class StackUsingList<E> implements Stack<E> {
	protected Node<E> top;
	protected int size;
	
	// Constructor
	public StackUsingList()
	{
		top = null;
		size = 0;
	}
	
	// Checks if the top of the stack is null. If so, then the stack is storing no more data and the stack is empty.
	public boolean isEmpty() {
		if(top == null) 
			return true;
		return false;
	}
	
	// Mutates stack by adding a node to the top of the stack.
	public void push(E elem) {
		Node<E> node = new Node<E>(elem, top);
		top = node;
		size++;
	}
	
	// Returns the data contained in the node at the top of the stack without mutating the stack.
	public E top() {
		return top.getData();
	}
	
	// Returns the data contained in the node at top of the stack and mutates the stack by moving the top of the stack to the node below it.
	public E pop() throws Exception {
		if(isEmpty()) throw new Exception("Stack is Empty");
		E temp = top.getData();
		top = top.getNext();
		size--;
		return temp;
	}
	
	// Getter_Accessor
	public int size() {
		return size;
	}
}
