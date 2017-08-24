
package arraylist_iterator_example;

/* Interface: Position 
 * @author - Wade Hedlesky
 * A very simple interface that will be implemented by classes in need of recognizing the element (data) 
 * of abstract type <E> stored within a position.
 * If you are unfamiliar with the notion of abstract classes, please review it online.
 * 
 * @param <E>
 */
public interface Position<E> {
	/** Return the element stored at this position. */
	E element();
}