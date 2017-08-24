
package priorityqueue_example;

import java.util.Comparator;

import arraylist_iterator_example.Position;
import exceptions_example.InvalidEntryException;
import exceptions_example.InvalidKeyException;


/* Class: PriorityQueueSortedListAdaptable
 * @author - Wade Hedlesky
 * PriorityQueueSortedListAdaptable is an extension of PriorityQueueSortedList that allows for the additional methods of remove(), replaceKey()
 * and replaceValue() to mutate or update the priority queue. This means that rather than removing or updating only the minimum of the priority
 * queue, this class allows for users to remove or update (replace) values within the priority queue itself. These new methods run in O(n) time.
 * 
 * @param <K>
 * @param <V>
 * 
 * Imports:		java.util.Comparator
 * 				arraylist_iterator_example.Position
 * 				exceptions_example.InvalidEntryException
 * 				exceptions_example.InvalidKeyException
 */
public class PriorityQueueSortedListAdaptable<K, V> extends PriorityQueueSortedList<K, V> implements PriorityQueueAdaptable<K, V>{
	
	/** Default constructor */
	public PriorityQueueSortedListAdaptable() {
		super();
	}
	
	/** 
	 * Constructor calls super(comp).  
	 * @param comp
	 */
	public PriorityQueueSortedListAdaptable(Comparator<K> comp)
	{
		super(comp);
	}
	
	/**LocationAwareEntry is a static class that extends MyEntry and is a helper class for PriorityQueueSortedListAdapatable<K, V>.
	 * It also implements PriorityQueueEntry.
	 */
	public static class LocationAwareEntry<K, V> extends MyEntry<K, V> implements PriorityQueueEntry<K, V>
	{
		/* Instance variables */
		private Position<PriorityQueueEntry<K, V>> loc;
		
		/**Default constructor for LocationAwareEntry.
		 * Calls super(key, value).
		 * @param key
		 * @param value
		 */
		public LocationAwareEntry(K key, V value)
		{
			super(key, value);
		}
	
		/**Constructor for LocationAwareEntry.
		 * Calls super(key, value) and sets loc = pos.
		 * @param key
		 * @param value
		 * @param pos
		 */
		public LocationAwareEntry(K key, V value, Position<PriorityQueueEntry<K, V>> pos)
		{
			super(key, value);
			loc = pos;
		}
	
		/**Returns the location of the LocationAwareEntry.
		 * @return loc
		 */
		protected Position<PriorityQueueEntry<K, V>> location() {
			return loc;
		}
		
		/**Sets the location of the LocationAwareEntry.
		 * @param pos the new position of the LocationAwareEntry.
		 * @return oldPosition The old position of the LocationAwareEntry.
		 */
		protected Position<PriorityQueueEntry<K, V>> setLocation(Position<PriorityQueueEntry<K, V>> pos) {
			Position<PriorityQueueEntry<K, V>> oldPosition = location();
			loc = pos;
			return oldPosition;
		}
		
		/**Sets the key of the LocationAwareEntry.
		 * @param key The new key of the LocationAwareEntry.
		 * @return oldKey The old key of the LocationAwareEntry.
		 */
		protected K setKey(K key) {
			K oldKey = getKey();
			k = key;
			return oldKey;
		}
		
		/**Sets the value of the LocationAwareEntry.
		 * @param value The new value of the LocationAwareEntry.
		 * @return oldValue The old value of LocationAwareEntry.
		 */
		protected V setValue(V value) {
			V oldValue = getValue();
			v = value;
			return oldValue;
		}
	}
	
	/**Checks the validity of PriorityQueueEntry.
	 * @param entry The entry to be checked. 
	 * @throws InvalidEntryException thrown if entry == null || !(entry instanceof LocationAwareEntry)
	 */
	@SuppressWarnings("rawtypes")
	protected void checkEntry(PriorityQueueEntry entry) throws InvalidEntryException {
		if(entry == null || !(entry instanceof LocationAwareEntry))
			throw new InvalidEntryException("invalid entry");
	}
	
	/**Creates and Inserts a PriorityQueueEntry with key and value
	 * @param key The key of the PriorityQueueEntry to be inserted.
	 * @param value The value of the PriorityQueueEntry to be inserted.
	 * @return entry The entry that was created and inserted.
	 */
	public PriorityQueueEntry<K, V> insert(K key, V value) throws InvalidKeyException{
		checkKey(key);
		LocationAwareEntry<K, V> entry = new LocationAwareEntry<K, V>(key, value);
		insertEntry(entry);
		entry.setLocation(actionPos);
		return entry;
	}
	
	/**Removes a PriorityQueueEntry
	 * @param entry The entry to be removed.
	 * @return ent The entry that was removed.
	 */
	public PriorityQueueEntry<K, V> remove(PriorityQueueEntry<K, V> entry) {
		checkEntry(entry);
		LocationAwareEntry<K, V> ent = (LocationAwareEntry<K, V>) entry;
		Position<PriorityQueueEntry<K, V>> pos = ent.location();
		entries.remove(pos);
		ent.setLocation(null);
		return ent;
	}
	
	/**Replaces the key of the PriorityQueueEntry entry and updates the priority queue entry locations.
	 * @param entry The PriorityQueueEntry that is being updated (replaced).
	 * @param key The new key of the PriorityQueueEntry.
	 * @return oldKey The old key of the PriorityQueueEntry.
	 */
	public K replaceKey(PriorityQueueEntry<K, V> entry, K key) {
		checkKey(key);
		checkEntry(entry);
		LocationAwareEntry<K, V> ent = (LocationAwareEntry<K, V>) remove(entry);
		K oldKey = ent.setKey(key);
		insertEntry(ent);
		ent.setLocation(actionPos);
		return oldKey;
	}
	
	/**Replaces the value of the PriorityQueueEntry entry.
	 * @param entry The PriorityQueueEntry that is being updated (replaced).
	 * @param value The new value of the PriorityQueueEntry.
	 * @return oldValue The old value of the PriorityQueueEntry.
	 */
	public V replaceValue(PriorityQueueEntry<K, V> entry, V value) {
		checkEntry(entry);
		V oldValue = ((LocationAwareEntry<K, V>) entry).setValue(value);
		return oldValue;
	}
}
