
package priorityqueue_example;

import java.util.Comparator;

/* Class: PriorityQueueComparator 
 * @author - Wade Hedlesky
 * This class implements java.util.Comparator and includes a method compare(a, b).
 * compare(...) compares the values of the input elements a and b and returns and integer.
 * 
 * @param <E>
 * 
 * Imports:		java.util.Comparator
 */
public class PriorityQueueComparator<E> implements Comparator<E> {
	@SuppressWarnings("unchecked")
	public int compare(E a, E b) throws ClassCastException {
		return ((Comparable<E>) a).compareTo(b);
	}
}
