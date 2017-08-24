
package queue_stack_example;

/**Interface: Queue
 * @author Wade Hedlesky
 * This is an interface for a Queue. It declares methods for isEmpty(), enqueue(), dequeue(), peek(), and size().
 * 
 * @param <E>
 */
public interface Queue<E> {
	
	/**
	 * Returns true if the queue is empty and false if the queue is not empty.
	 * For circular queue implementation, uses if(f==r).
	 * @return true if empty, false if not empty.
	 */
	public Boolean isEmpty();
	
	/**
	 * Inserts a QueueData object at the end of the queue.
	 * @param E object to be inserted at end of queue.
	 */
	public void enqueue(E elem);
	
	/**
	 * Removes a QueueData object from the front of the queue.
	 * For circular queue implementation, enqueue(...) should not result in the front = rear position.
	 * @return QueueData object removed from queue.
	 * @exception Exception if the queue is empty.
	 */
	public E dequeue() throws Exception;
	
	/**
	 * Accesses the front of the queue without mutating queue.
	 * @return QueueData object at the front of the queue.
	 * @exception Exception if the queue is empty.
	 */
	public E peek() throws Exception;
	
	/**
	 * Returns the number of QueueData objects stored in the queue.
	 * For a circular queue implementation, size should be calculated using Cap - front + rear.
	 * @return number of QueueData objects in the queue.
	 */
	public int size();
}
