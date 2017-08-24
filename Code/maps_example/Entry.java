
package maps_example;

/* Interface: Entry
 * @author - Wade Hedlesky
 * Interface for a key-value pair entry
 * 
 * @param <K>
 * @param <V>
 */
public interface Entry<K, V> {
	
	/** return key of this entry */
	public K getKey();
	
	/** return value of this entry */
	public V getValue();
}
