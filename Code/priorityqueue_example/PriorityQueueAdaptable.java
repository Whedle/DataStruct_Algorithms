
package priorityqueue_example;

/* Interface: PriorityQueueAdaptable
 * @author Wade Hedlesky
 * This interface extends PriorityQueue<K, V> and assists in the implementation of adaptable priority queues.
 * 
 * @param <K>
 * @param <V>
 */
public interface PriorityQueueAdaptable<K, V> extends PriorityQueue<K, V> {
	
	/**
	 * Remove and return PriorityQueueEntry<K, V> entry from priority queue.
	 * @param entry
	 * @return entry
	 */
	public PriorityQueueEntry<K, V> remove(PriorityQueueEntry<K, V> entry);
	
	/**
	 * Remove and return key associated with PriorityQueueEntry<K, V> entry. 
	 * Replace it with K key (a new key).
	 * @param entry
	 * @param key
	 * @return the key that was originally associated with entry.
	 */
	public K replaceKey(PriorityQueueEntry<K, V> entry, K key);
	
	/**
	 * Remove and return value associated with PriorityQueueEntry<K, V> entry.
	 * Replace this value with V value.
	 * @param entry 
	 * @param value
	 * @return The old value associated with entry.
	 */
	public V replaceValue(PriorityQueueEntry<K, V> entry, V value);
}
