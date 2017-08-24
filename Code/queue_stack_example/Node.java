
package queue_stack_example;

/* Class: Node 
 * @author Wade Hedlesky
 * A simple node with methods setData(E), getData(), setNext(E), and getNext().
 * 
 * @param <E>
 */
public class Node<E> {
	private E element;
	private Node<E> next;
	
	/**
	 * Default constructor for Node. Calls this(null, null).
	 */
	public Node()
	{
		this(null, null);
	}
	
	/**
	 * Constructor for Node. Sets element = elem and next = n.
	 * @param elem
	 * @param n
	 */
	public Node(E elem, Node<E> n)
	{
		element = elem;
		next = n;
	}
	
	// Mutator
	public void setData(E elem) {
		element = elem;
	}
	
	// Getter_Accessor
	public E getData() {
		return element;
	}
	
	// Mutator
	public void setNext(Node<E> new_next) {
		next = new_next;
	}
	
	// Getter_Accessor
	public Node<E> getNext()
	{
		return next;
	}
}
