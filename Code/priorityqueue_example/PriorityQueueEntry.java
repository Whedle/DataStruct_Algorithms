
package priorityqueue_example;

/* Interface: PriorityQueueEntry
 * @author - Wade Hedlesky
 * In order to keep track of associations between keys and values in a priority queue, two kinds of objects are typically used.
 * The first is an entry. The second is a comparator. The entry object uses the Object-Oriented Design Pattern "Composition Pattern"
 * in order to simply and effectively pair keys and values. Each PriorityQueueEntry acts as an ordered pair, with keys mapping to values.
 * The PriorityQueueEntry is exactly identical to the Entry interface typically used, but is given its own class to be placed in the
 * priorityqueue_example package.
 */
public interface PriorityQueueEntry<K, V>{
	/**
	 * Returns the key stored in this entry
	 * @return this PriorityQueueEntry key
	 */
	public K getKey();
	
	/**
	 * Returns the value stored in this entry
	 * @return this PriorityQueueEntry value
	 */
	public V getValue();
}
