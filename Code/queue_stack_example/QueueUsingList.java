
package queue_stack_example;

/* Class: QueueUsingList
 * @author - Wade Hedlesky
 * This class implements the Queue interface. It is a Queue that uses a linked list with nodes.
 * 
 * @param <E>
 */
public class QueueUsingList<E> implements Queue<E>{
	protected int size;
	private Node<E> head;
	private Node<E> tail;
	
	// Constructor
	public QueueUsingList()
	{
		size = 0;
	}
	
	// Checks if the top of the stack is null. If so, then the stack is storing no more data and the stack is empty.
	public Boolean isEmpty()
	{
		if(size()==0)
			return true;
		return false;
	}
	
	// Mutates queue by adding a node to the queue. The new node is always set to be the tail of the queue.
	public void enqueue(E data) {
		Node<E> node = new Node<E>();
		node.setData(data);
		node.setNext(null);
		if(size == 0)
			head = node;
		else
			tail.setNext(node);
		tail = node;
		size++;
	}
	
	// Returns data at the head of the queue and mutates queue by shifting the head of the queue to the node behind it.
	public E dequeue() throws Exception{
		if(size == 0) 
			throw new Exception("ERROR: Method \"dequeue()\" cannot dequeue from an empty queue.");
		E temp = head.getData();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return temp;
	}
	
	// Peeks at the head of the Queue and returns data without mutating queue.
	public E peek() throws Exception{
		if(size == 0)
			throw new Exception("Error: Method \"peek()\" cannot access an empty queue.");
		return head.getData();
	}
	
	// Getter_Accessor
	public int size() {
		return size;
	}
}
