
package maps_example;

/* Interface: Map
 * @author - Wade Hedlesky
 * This is an interface for a map that stores a collection of entries (key-value pairs).
 * 
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> 
{

	/**
	 * Returns Iterable collection containing all key-value entries in the Map. So entrySet().iterator() returns iterator of entries.
	 * @return Iterable collection of all entries in Map.
	 */
	public Iterable<Entry<K, V>>entrySet();
	
	/**
	 * Gets the value with key equal to key, or returns null if no such entry.
	 * @return value of entry with key.
	 */
	public V get(K key);
	
	/**
	 * Tests whether M is empty.
	 * @return true if M is an empty Map.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns Iterable collection containing all keys in the Map. So keySet().iterator() returns an iterator of keys.
	 * @return Iterable collection of all keys in Map.
	 */
	public Iterable<K> keySet();
	
	/**
	 * If M does not have an entry with key k, then adds entry (key,value) to the Map and returns null; otherwise it replaces the old value
	 * with value and returns the old value
	 * @param key
	 * @param value
	 * @return Either null or the old value, depending on if an k maps to a value.
	 */
	public V put(K key, V value);
	
	/**
	 * Removes from the map the entry with key k and returns it value; if M does not have such an entry, then the method returns null.
	 * @param key
	 * @return value mapped to by key, or null if no such mapping.
	 */
	public V remove(K key);
	
	/**
	 * Returns the number of entries currently stored in Map.
	 * @return number of entries in Map.
	 */
	public int size();
	
	/**
	 * Returns an Iterable collection containing all values associated with keys stored in M. So values().iterator() returns an iterator of values.
	 * @return Iterable collection of all values in Map.
	 */
	public Iterable<V> values();
}
