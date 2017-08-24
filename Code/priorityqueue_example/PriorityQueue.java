
package priorityqueue_example;

import exceptions_example.EmptyPriorityQueueException;
import exceptions_example.InvalidKeyException;

/* Interface: PriorityQueue
 * @author - Wade Hedlesky
 * An interface for PriorityQueue abstract data types.
 * 
 * @param <K>
 * @param <V>
 * 
 * Imports:		exceptions_example.EmptyPriorityQueueException
 * 				exceptions_example.InvalidKeyException
 */
public interface PriorityQueue<K, V> {
	
	public PriorityQueueEntry<K, V> insert(K key, V value) throws InvalidKeyException;
	
	public boolean isEmpty();
	
	public PriorityQueueEntry<K, V> min() throws EmptyPriorityQueueException;
	
	public PriorityQueueEntry<K, V> removeMin() throws EmptyPriorityQueueException;
	
	public int size();
}