
package arraylist_iterator_example;

import java.util.Iterator;

import exceptions_example.BoundaryViolationException;
import exceptions_example.InvalidPositionException;

/* Interface: PositionList
 * @author - Wade Hedlesky
 * Interface for an Iterable list of Position<E> objects.
 * 
 * @param <E>
 * 
 * Imports:		java.util.Iterator
 * 				exceptions_example.BoundaryViolationException
 * 				exceptions_example.InvalidPositionException
 */
public interface PositionList<E> extends Iterable<E>{
	
	/** Inserts an element after the given node in the list. */
	public void addAfter(Position<E> p, E e) throws InvalidPositionException;
	
	/** Inserts an element before the given node in the list. */
	public void addBefore(Position<E> p, E e) throws InvalidPositionException;
	
	/** Inserts an element at the front of the list. */
	public void addFirst(E e);
	
	/** Inserts an element at the end of the list. */
	public void addLast(E e);
	
	/** Returns the first node in the list. */
	public Position<E> first();
	
	/** Returns true if isEmpty. */
	public boolean isEmpty();
	
	public Iterator<E> iterator();
	
	/** Returns the last node in the list.*/
	public Position<E> last();
	
	/** Returns the next node in the list (the node that follows or is after p). */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	public Iterable<Position<E>> positions();
	
	/** Returns the previous node in the list (the node that is before p). */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	/** Removes a node from the list, returning the element stored there. */
	public E remove(Position<E> p) throws InvalidPositionException;

	/** Replaces the element stored at the given node, returning old element. */
	public E set(Position<E> p, E e) throws InvalidPositionException;
	
	/** Returns the number of elements in this list. */
	public int size();
}
